package pl.kacprzak.dynatrace.util;

import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;


@Component("simple")
public class SimplePrimeFilter implements FilterStrategy<Integer> {

    @Override
    public List<Integer> filter(List<Integer> numbers) {


        return numbers.stream().filter(number -> isPrime(number)).distinct().collect(Collectors.toList());


    }

    private boolean isPrime(int number) {


        if (number == 1)
            return false;

        for (var i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }


}
