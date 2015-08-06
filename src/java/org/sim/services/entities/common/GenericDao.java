package org.sim.services.entities.common;

import static org.hibernate.criterion.Example.create;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.sim.service.util.HibernateUtil;
import org.hibernate.criterion.Example;     

/**
 *
 * @author Diego Arrighi
 * @param <T>
 */
public abstract class GenericDao<T> {

    protected static Logger log;
    private Boolean flushAndRefreshOnPersist = false;
    private Boolean flushOnDelete = false;

    /**
     * @return the log
     */
    public static Logger getLog() {
        return log;
    }

    /**
     * @param aLog the log to set
     */
    public static void setLog(Logger aLog) {
        log = aLog;
    }
    protected Class<T> persistentClass;
    protected SessionFactory sessionFactory;

    protected SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = HibernateUtil.getSessionFactory();
            //System.out.println("getSessionFactory");
        }
        return sessionFactory;
    }

    public GenericDao(Class<T> clase) {
        if (clase == null) {
            throw new NullPointerException();
        }
        this.persistentClass = clase;
        GenericDao.log = Logger.getLogger(this.getClass().getName());
    }

    protected Session getSession() {
        return getSessionFactory().getCurrentSession();
    }

    public void persist(T transientInstance) {

        getLog().info("persisting " + transientInstance.getClass().toString() + " instance");
        try {
            getSession().persist(transientInstance);

            if (getFlushAndRefreshOnPersist()) {
                getLog().info("Flush and refresh of the persisted entity");
                getSession().flush();
                getSession().refresh(transientInstance);
            }
            getLog().info("persist successful");
        } catch (RuntimeException re) {
            re.printStackTrace();
            getLog().log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }

    public void attachDirty(T instance) {
        getLog().info("attaching dirty " + this.getPersistentClass().getName() + " instance");
        try {
            getSession().saveOrUpdate(instance);
            getLog().info("attach successful");
        } catch (RuntimeException re) {
            getLog().log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    public void attachClean(T instance) {
        getLog().info("attaching clean " + this.getPersistentClass().getName() + " instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            getLog().info("attach successful");
        } catch (RuntimeException re) {
            getLog().log(Level.SEVERE, "attach failed", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public <E extends Serializable> T merge(T detachedInstance) {
        getLog().info("merging " + this.getPersistentClass().getName() + " instance");
        try {
            T result = (T) getSession().merge(detachedInstance);
            getLog().info("merge successful");
            return result;
        } catch (RuntimeException re) {
            getLog().log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }

    protected <E extends Serializable> T findById(E id) {
        getLog().info("getting instance of " + this.getPersistentClass().getName() + " with id: " + id.toString());
        try {
            @SuppressWarnings(value = "unchecked")
            T instance = (T) this.getSession().get(this.getPersistentClass(), id);
            if (instance == null) {
                getLog().info("get successful, no instance found");
            } else {
                getLog().info("get successful, instance found");
            }
            return instance;
        } catch (RuntimeException re) {
            getLog().log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findByExample(T instance) {
        getLog().info("finding " + this.getPersistentClass().getName() + " instance by example");
        try {
            Example example = Example.create(instance).excludeZeroes().ignoreCase();
            List<T> results = (List<T>) getSession().createCriteria(this.getPersistentClass()).add(create(instance)).add(example).list();
            getLog().info("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            getLog().log(Level.SEVERE, "find by example failed", re);
            throw re;
        }
    }

    public void delete(T persistentInstance) {
        getLog().info("deleting instance of " + this.getPersistentClass().getName());
        try {
            getSession().delete(persistentInstance);

            if (getFlushOnDelete()) {
                getSession().flush();
            }
            getLog().info("delete successful");
        } catch (RuntimeException re) {
            getLog().log(Level.SEVERE, "delete failed", re);
            throw re;
        }
    }

    public void refresh(T persistentInstance) {
        getLog().info("refreshing instance of " + this.getPersistentClass().getName());
        try {
            getSession().refresh(persistentInstance);
            getLog().info("refresh successful");
        } catch (RuntimeException re) {
            getLog().log(Level.SEVERE, "refresh failed", re);
            throw re;
        }
    }

    /**
     * Gets the whole BusinessObjects list
     * Only for compatibility issues
     * @return the BusinessObject list
     */
    public List<T> getList() {
        return this.findAll();
    }

    /**
     * Gets the whole BusinessObjects list
     * @return the BusinessObject list
     */
    public List<T> findAll() {
        getLog().info("getting all " + this.getPersistentClass().getName() + " instances");
        try {
            List<T> results = (List<T>) getSession().createCriteria(this.getPersistentClass()).list();
            if (results == null) {
                getLog().info("get successful, no instance found");
            } else {
                getLog().info("get successful, instance found");
            }
            return results;
        } catch (RuntimeException re) {
            getLog().log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
    
    /**
     * @return the PersistentClass
     */
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    /**
     * Indica si hay que hacer un flush y refresh luego de persistir una entidad
     * Esto es util, si la tabla de la entidad, contiene triggers que modifiquen algun valor y se
     * quiera tener reflejado en la entidad esos cambios
     * @return the flushAndRefreshOnPersist
     */
    public Boolean getFlushAndRefreshOnPersist() {
        return flushAndRefreshOnPersist;
    }

    /**
     * @param flushAndRefreshOnPersist the flushAndRefreshOnPersist to set
     */
    public void setFlushAndRefreshOnPersist(Boolean flushAndRefreshOnPersist) {
        this.flushAndRefreshOnPersist = flushAndRefreshOnPersist;
    }

    /**
     * Indica si hay que hacer un flush luego de remover una entidad
     * @return the flushOnDelete
     */
    public Boolean getFlushOnDelete() {
        return flushOnDelete;
    }

    /**
     * @param flushOnDelete the flushOnDelete to set
     */
    public void setFlushOnDelete(Boolean flushOnDelete) {
        this.flushOnDelete = flushOnDelete;
    }
}
