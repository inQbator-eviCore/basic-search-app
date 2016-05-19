package com.qpidhealth.qpid.search.services;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.ejb.LockType.READ;

@Path("/patients")
@Singleton
@Lock(READ)
public class PatientService {
    
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> searchPatients(@QueryParam("query") String query) {
        Patient p1 = new Patient();
        p1.setId(1000000L);
        p1.setName("Mary TestPerson");
        List<String> docs = new ArrayList<String>();
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_1"));
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_2"));
        p1.setDocuments(docs);
        
        Patient p2 = new Patient();
        p2.setId(1000001L);
        p2.setName("Joe TestPerson");
        List<String> docs2 = new ArrayList<String>();
        docs2.add("Clinical Note:::4/6/2010:::" + resource("Joe_1"));
        docs2.add("Summary:::7/2/2010:::" + resource("Joe_2"));
        p2.setDocuments(docs2);
        
        Patient p3 = new Patient();
        p3.setId(1000002L);
        p3.setName("Sam TestPerson");
        List<String> docs3 = new ArrayList<String>();
        docs3.add("Patient Note:::8/3/2012:::" + resource("Sam_1"));
        p3.setDocuments(docs3);
        
        List<Patient> results = new ArrayList<Patient>();
        results.add(p1);
        results.add(p2);
        results.add(p3);
        
        return results;
    }
    
    private static String resource(String fileName) {	
    	ClassLoader classLoader = PatientService.class.getClassLoader();
    	try {
    	    return IOUtils.toString(classLoader.getResourceAsStream("documents/"+fileName+".txt"));
    	} catch (IOException e) {
    	    e.printStackTrace();
    	    return "Failed to retrieve resource "+fileName;
    	}
    }
    
    @XmlRootElement
    public static class Patient {
        
        private Long id;    
        private String name;
        private List<String> documents; // id ::: date ::: contents
        
        public Patient() {
            documents = new ArrayList<String>();
        }
        
        public static Patient create() {
            return new Patient();
        }
        
        public Long getId() {
            return id;
        }
        
        public void setId(Long id) {
            this.id = id;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public List<String> getDocuments() {
            return documents;
        }
        
        public void setDocuments(List<String> documents) {
            this.documents = documents;
        }
        
    }

}
