/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos;
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import java.net.UnknownHostException;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.BSONObject;
/**
 *
 * @author wesker
 */
public class db {
    
    private static MongoClient conexion()
    {
        MongoClient mongoClient=null;
        try {
           mongoClient = new MongoClient();
        } catch (UnknownHostException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mongoClient;
    }
    
    private static DBCollection obtieneColeccion(String nombre_coleccion)
    {
        return conexion().getDB("test").getCollection(nombre_coleccion);
    }
    public static DBCollection obtieneColeccionUsuario()
    {
        return obtieneColeccion("usuario");
    }
    
    public static void insertarUsuario(String usuario,String correo)
    {
        BasicDBObject o = new BasicDBObject("nombre",usuario);
        o.append("email",correo);
        obtieneColeccionUsuario().insert(o);
    }
    
    public static void insertarUsuario(BasicDBObject objeto)
    {
        obtieneColeccionUsuario().insert(objeto);
    }
    
    public static void eliminarUsuarioPorNombre(String nombre)
    {
        obtieneColeccionUsuario().remove(new BasicDBObject("nombre",nombre));
    }
    public static DBCursor obtenerDatosUsuario(String nombre)
    {
        BasicDBObject obj = new BasicDBObject("nombre",nombre);
        return obtieneColeccionUsuario().find(obj);
    }
    public static DBCursor obtenerRegistros()
    {
        return obtieneColeccionUsuario().find();
    }
    
    public static String aTexto(DBCursor resultado)
    {
        String texto = "";
        while (resultado.hasNext()) {
		texto += resultado.next().toString();
	}
        return texto;
    }
    
}
