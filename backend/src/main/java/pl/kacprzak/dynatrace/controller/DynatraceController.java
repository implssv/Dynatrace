package pl.kacprzak.dynatrace.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kacprzak.dynatrace.domain.DynatraceEntity;
import pl.kacprzak.dynatrace.exception.FilterStrategyNotFoundException;
import pl.kacprzak.dynatrace.service.PrimeService;


@RestController
public class DynatraceController {


    @Autowired
    private PrimeService primeService;

    @RequestMapping(method = RequestMethod.GET, value = "/primes/{strategy}")
    public DynatraceEntity getPrimeNumbers(@PathVariable("strategy") String strategy) throws FilterStrategyNotFoundException {
        return primeService.getRandomPrimeNumbers(strategy);

    }


}
