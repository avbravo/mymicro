package com.mycompany.mymicro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.avbravo.horarioejb.entity.Agente;
import com.avbravo.horarioejb.repository.AgenteRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.bson.Document;


/**
 *
 * @author Juneau
 */
@Stateless
@Path("suggestedNameService")
public class SuggestedNameService {

   @Inject
   AgenteRepository agenteRepository;


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Agente find(@PathParam("id") String id) {
        Agente suggestedName = null;
        try {
            List<Agente> list = new ArrayList<>();
          
              list=      agenteRepository.findBy(new Document("idagente", id));
                suggestedName = list.get(0);
                 
        } catch (NoResultException ex){
            System.out.println("Error: "  + ex);
        }
        return suggestedName;
    }
   
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Agente> findAll() {
        List<Agente> suggestedNames = null;
        try {
            suggestedNames = agenteRepository.findAll();
        } catch (NoResultException ex){
            System.out.println("Error: "  + ex);
        }
        return suggestedNames;
    }

   
    
}
