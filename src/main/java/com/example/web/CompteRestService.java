package com.example.web;


import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.dao.CompteRepository;
import com.example.entities.Compte;

import javassist.tools.web.BadHttpRequest;

@Component

public class CompteRestService {
	@Autowired
	private CompteRepository compteRepository;
	
	
	
	@GetMapping(value = "/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> getComptes(){
	return compteRepository.findAll();
	}
	@GetMapping(value = "/")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam (value="code") long code) {
		Optional<Compte> cpp = compteRepository.findById(code);
	    if (cpp.isPresent()) {
	        return cpp.get();
	    }
	    return null;	
	}
	
	@PostMapping(value = "/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Compte compte) {
		 compteRepository.save(compte);
	   
	}

	@DeleteMapping(value = "/")
	public void delete(@PathParam (value="code") long code) {
		compteRepository.deleteById(code);
	}
	@PutMapping(value = "/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Compte update(@PathParam(value="code") long code,Compte compte)throws BadHttpRequest  {
        if (compteRepository.existsById(code)) {
        	compte.setCode(code);
            return compteRepository.save(compte);
        } else {
            throw new BadHttpRequest();
        }
    }


}
