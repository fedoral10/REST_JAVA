/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("insertar/{usuario}/{correo}")
public class insertar {
    
    
    /**
    @return String
    */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String insertar (@PathParam("usuario") String usuario,@PathParam("correo") String email)
    {
        db.insertarUsuario(usuario, email);
        return "ok";
    }
}
