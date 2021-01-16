package cz.kct.exam.rest;

/**
 * Main class for all REST API
 * Has to be registered in web.xml for com.ibm.websphere.jaxrs.server.IBMRestServlet
 * 
 * Each class that produce REST API has to be registered in getClasses() method
 *  
 * @author wojta
 *
 */
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import io.swagger.api.V1Api;

public class RestApplications extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(V1Api.class);

        return classes;
    }

}