package com.datos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wesker
 */
@Path("obtenerTodos")
public class obtenerTodos {
     /**
    @return String
    */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String obtenerTodos (@PathParam("usuario") String usuario)
    {
        
        return db.aTexto(db.obtenerRegistros());
    }
}
