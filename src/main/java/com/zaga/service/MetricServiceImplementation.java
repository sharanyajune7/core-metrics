package com.zaga.service;

import javax.enterprise.context.ApplicationScoped;

import io.micrometer.core.instrument.MeterRegistry;

@ApplicationScoped
public class MetricServiceImplementation implements MetricService{
    
    private final MeterRegistry registry ;

    MetricServiceImplementation(MeterRegistry registry) {
        this.registry = registry;
        
    }

    public void count (){
          registry.counter("example.count.check").increment();
    }

}
