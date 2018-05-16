package pl.kacprzak.dynatrace.util;

import pl.kacprzak.dynatrace.domain.DynatraceEntity;

import java.util.List;

public interface FilterStrategy<T> {

    List<T> filter (List<T> numbers);
}
