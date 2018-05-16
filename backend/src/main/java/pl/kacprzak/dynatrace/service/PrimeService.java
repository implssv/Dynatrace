package pl.kacprzak.dynatrace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kacprzak.dynatrace.domain.DynatraceEntity;
import pl.kacprzak.dynatrace.exception.FilterStrategyNotFoundException;
import pl.kacprzak.dynatrace.util.FilterStrategy;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class PrimeService {


    @Autowired
    private RequestService requestService;

    @Autowired
    private Map<String, FilterStrategy> filterStrategies;


    public DynatraceEntity getRandomPrimeNumbers(String strategy) throws FilterStrategyNotFoundException {


        DynatraceEntity entity = requestService.getNumbers();
        FilterStrategy filterStrategy = getStrategy(strategy);
        List<Integer> filteredNumbers = filterStrategy.filter(entity.getData());
        filteredNumbers.sort(Integer::compareTo);
        entity.setData(filteredNumbers);
        return entity;

    }

    private FilterStrategy getStrategy(String strategy) throws FilterStrategyNotFoundException {


      Optional<FilterStrategy> filterStrategy = Optional.ofNullable(filterStrategies.get(strategy));

      if(!filterStrategy.isPresent())
          throw new FilterStrategyNotFoundException();

      return filterStrategy.get();

    }


}
