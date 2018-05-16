package pl.kacprzak.dynatrace.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kacprzak.dynatrace.domain.DynatraceEntity;


@Service
public class RequestService {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${dynatrace.url.path}")
    private String path;



    public DynatraceEntity getNumbers() {


      return  restTemplate.getForObject(path, DynatraceEntity.class);



    }




}
