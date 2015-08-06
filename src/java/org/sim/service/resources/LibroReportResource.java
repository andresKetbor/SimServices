/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.service.resources;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.sim.services.entities.LibroReport;
import org.sim.services.entities.common.daos.LibroReportDao;

/**
 *
 * @author adengra
 */

@Path("/MensajeResource") 
public class LibroReportResource {
    
    private LibroReportDao libroReportDao = new LibroReportDao(); 
    
    
    
 @POST   
 public void addLibroReport(String libroReportString){
      
     Gson gson = new Gson();
     
     LibroReport libroReport = gson.fromJson(libroReportString, LibroReport.class);
     
     libroReportDao.persist(libroReport);
     
 }  
 
 
 @GET
 public String getLibroReport(){
     
     
     return "hola mundo";
     
 }
 
 
 
    
}
