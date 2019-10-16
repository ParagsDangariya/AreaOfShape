/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import java.util.Date;
import javafx.scene.media.Media;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * REST Web Service
 *
 * @author 1894264
 */
@Path("mobile")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of Application.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("shapeList")
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
   
        JSONArray mainArray = new JSONArray();
        JSONObject shapeObject = new JSONObject();
        
        shapeObject.accumulate("name", "Circle");
        shapeObject.accumulate("NumberofParam", 1);
        
        mainArray.add(shapeObject);
        shapeObject.clear();
   
        shapeObject.accumulate("name", "Square");
        shapeObject.accumulate("NumberofParam", 1);
        
        mainArray.add(shapeObject);
        shapeObject.clear();
        
        shapeObject.accumulate("name", "Rectangle");
        shapeObject.accumulate("NumberofParam", 2);
        
        mainArray.add(shapeObject);
        shapeObject.clear();
        
        shapeObject.accumulate("name", "Triangle");
        shapeObject.accumulate("NumberofParam", 2);
        
        mainArray.add(shapeObject);
        shapeObject.clear();
        
        shapeObject.accumulate("name", "Parallelogram");
        shapeObject.accumulate("NumberofParam", 2);
        
        mainArray.add(shapeObject);
        shapeObject.clear();
        
        shapeObject.accumulate("name", "Ellipse");
        shapeObject.accumulate("NumberofParam", 2);
        
        mainArray.add(shapeObject);
        shapeObject.clear();
        
        shapeObject.accumulate("name", "Sector");
        shapeObject.accumulate("NumberofParam", 2);
        
        mainArray.add(shapeObject);
        shapeObject.clear();
        
        shapeObject.accumulate("name", "Trapezoid");
        shapeObject.accumulate("NumberofParam", 3);
        
        mainArray.add(shapeObject);
        shapeObject.clear();
        
        
        return mainArray.toString();
    }

    @GET
    @Path("shapeThree&{shape}&{value1}&{value2}&{value3}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText7(@PathParam("shape")String shape,
            @PathParam("value1")double value1,
            @PathParam("value2")double value2, 
            @PathParam("value3")double value3) {
        JSONObject singleObject = new JSONObject();
        String trapezoid = "trapezoid";
        Date date = new Date();
        long time = date.getTime();
        
        if(shape.toLowerCase().equals(trapezoid)){
            singleObject.accumulate("Status", "OK");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", trapezoid.toUpperCase());
            singleObject.accumulate("base1", value1);
            singleObject.accumulate("base2", value2);
            singleObject.accumulate("height", value3);
            
            double area = ((value1+value2)*0.5)*value3;
            singleObject.accumulate("area", area);
            
        }else{
            singleObject.accumulate("Status", "Error");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shape);
            singleObject.accumulate("Message", "Not the good Shape");
            
        }
 
        return singleObject.toString();
    }
    @GET
    @Path("shapeOne&{shape}&{value1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getShape2(@PathParam("shape")String shape,
            @PathParam("value1")double radius) {
        JSONObject singleObject = new JSONObject();
        String shapeName1 = "circle";
        String shapeName2 = "square";
        Date date = new Date();
        long time = date.getTime();
        
        if(shape.toLowerCase().equals(shapeName1)){
            singleObject.accumulate("Status", "OK");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shapeName1.toUpperCase());
            singleObject.accumulate("base1", radius);
            
            
            double area = 3.14* radius*radius;
            singleObject.accumulate("area", area);
            
        }else if (shape.toLowerCase().equals(shapeName2)) {
             singleObject.accumulate("Status", "OK");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shapeName1.toUpperCase());
            singleObject.accumulate("base1", radius);
            
            
            double area = radius*radius;
            singleObject.accumulate("area", area);
        } else {
            singleObject.accumulate("Status", "Error");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shape);
            singleObject.accumulate("Message", "Not the good Shape");
            
        }
        
       
        return singleObject.toString();
    }
    
    @GET
    @Path("shapeTwo&{shape}&{value1}&{value2}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getshape3(@PathParam("shape")String shape,
            @PathParam("value1")double value1,
            @PathParam("value2")double value2) {
        JSONObject singleObject = new JSONObject();
        String shape1 = "triangle";
        String shape2 = "rectangle";
        String shape3 = "parallelogram";
        String shape4 = "ellipse";
        String shape5 = "sector";
        
        Date date = new Date();
        long time = date.getTime();
        
        if(shape.toLowerCase().equals(shape1)){
            singleObject.accumulate("Status", "OK");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shape1.toUpperCase());
            singleObject.accumulate("base1", value1);
            singleObject.accumulate("base2", value2);
            
            
            double area = value1 * value2 * 0.5;
            singleObject.accumulate("area", area);
            
        }else if (shape.toLowerCase().equals(shape2)) {
          singleObject.accumulate("Status", "OK");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shape2.toUpperCase());
            singleObject.accumulate("base1", value1);
            singleObject.accumulate("base2", value2);
            
            
            double area = value1 * value2 ;
            singleObject.accumulate("area", area);  
        }else if (shape.toLowerCase().equals(shape3)) {
         singleObject.accumulate("Status", "OK");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shape3.toUpperCase());
            singleObject.accumulate("base1", value1);
            singleObject.accumulate("base2", value2);
            
            
            double area = value1 * value2 ;
            singleObject.accumulate("area", area);   
        }else if (shape.toLowerCase().equals(shape4)) {
            singleObject.accumulate("Status", "OK");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shape4.toUpperCase());
            singleObject.accumulate("base1", value1);
            singleObject.accumulate("base2", value2);
            
            
            double area = value1 * value2 * 3.14;
            singleObject.accumulate("area", area);
        }else if (shape.toLowerCase().equals(shape5)) {
            singleObject.accumulate("Status", "OK");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shape5.toUpperCase());
            singleObject.accumulate("base1", value1);
            singleObject.accumulate("base2", value2);
            
            
            double area = value1 * value2 * 0.5*value1;
            singleObject.accumulate("area", area);
        }else{
            singleObject.accumulate("Status", "Error");
            singleObject.accumulate("Timestamp", time);
            singleObject.accumulate("Shape", shape);
            singleObject.accumulate("Message", "Not the good Shape");
            
        }
 
        return singleObject.toString();
    }
}
