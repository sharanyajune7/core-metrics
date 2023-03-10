package com.zaga;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zaga.entity.Perrson;
import com.zaga.service.MetricService;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@Path("/counter")
public class MetricsCounterCheck {

 @Inject
 MetricService service;

 private final MeterRegistry registry ;

    MetricsCounterCheck(MeterRegistry registry) {
        this.registry = registry;
        
    }

@GET
@Produces(MediaType.TEXT_PLAIN)
public void count(){
    service.count();
}

@POST
@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
public Perrson create(Perrson person){
    Timer timer = registry.timer("example.timer");
    return timer.record(()->{
        Perrson.persist(person);
     return person ;

    });
     
} 
}