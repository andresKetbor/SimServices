/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.service.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author adengra
 */

@Path("/MensajeResource") 
public class MensajeResource {
    
    
 @POST   
 public void addMensaje(){
     
     
 }  
 
 
 @GET
 public String getMensaje(){
     
     
     return "hola mundo";
     
 }
 
 
 
    
}
