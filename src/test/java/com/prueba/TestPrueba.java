/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba;

import com.datos.db;
import com.datos.eliminar;
import com.datos.insertar;
import com.datos.obtener;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;


public class TestPrueba {
    
    private ArrayList<BasicDBObject> lista;
    private String nombre;
    private String email;
    insertar i;
    eliminar e;
    obtener o;
    @Before
    public void setUp()
    {  
        BasicDBObject row1 = new BasicDBObject("nombre","Jorge");
        row1.append("email", "fedoral10@gmail.com");
        BasicDBObject row2 = new BasicDBObject("nombre","Juanito");
        row2.append("email", "juanito@gmail.com");
        BasicDBObject row3 = new BasicDBObject("nombre","debian");
        row1.append("email", "linux@debian.org");
        BasicDBObject row4 = new BasicDBObject("nombre","fedora");
        row1.append("email", "linux@fedora.org");
        lista = new ArrayList<BasicDBObject>();
        lista.add(row1);
        lista.add(row2);
        lista.add(row3);
        lista.add(row4);
        
        for (BasicDBObject item : lista) {
            db.insertarUsuario(item);
        }
        nombre="Albert";
        email = "wesker@umbrella.org";
        i = new insertar();
        e = new eliminar();
        o = new obtener();
    }
    @Test
    public void testCrud()
    {
        assertEquals("ok",i.insertar(nombre, email));
        assertNotNull(o.obtener(nombre));
        assertEquals("ok",e.eliminar(nombre));
    }
}
