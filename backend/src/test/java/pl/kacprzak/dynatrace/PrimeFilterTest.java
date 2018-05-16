package pl.kacprzak.dynatrace;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kacprzak.dynatrace.util.FilterStrategy;
import pl.kacprzak.dynatrace.util.SimplePrimeFilter;

import java.util.*;


@RunWith(SpringRunner.class)
public class PrimeFilterTest {





    @TestConfiguration
    static class PrimeFilterImplTestContextConfiguration {

        @Bean
        public FilterStrategy simpleFilterStrategy() {
            return new SimplePrimeFilter();
        }
    }



    public static List<List<Integer>> data() {
        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(388,285,535,532,963,532,169,328,51,71,973,665,766,267,756,755,258,10,914,937));
        data.add(Arrays.asList(638,725,530,220,849,15,559,9,794,257));
        data.add(Arrays.asList(378,742,635,728,577,323,456,587,650,155,283,701,396,915,42));
        data.add(Arrays.asList(1,382,732,920,902,511,740,869,289,479,232,520,449,673,468));
        data.add(Collections.emptyList());
        return data;
    }

    public static List<List<Integer>> filteredData()
    {
        List<List<Integer>> filteredData = new ArrayList<>();
        filteredData.add(Arrays.asList(71, 937));
        filteredData.add(Arrays.asList(257));
        filteredData.add(Arrays.asList(283, 577, 587, 701));
        filteredData.add(Arrays.asList(449, 479, 673));
        filteredData.add(Collections.emptyList());
        return filteredData;
    }

    @Autowired
    private FilterStrategy filterStrategy;


    @Test
    public void testPrimeFilter()
    {


     for(var i = 0 ; i<data().size();i++)
     {
         List<Integer> filteredNumbers =  filterStrategy.filter(data().get(i));
         filteredNumbers.sort(Integer::compareTo);
         assertEquals(filteredNumbers,filteredData().get(i));
     }
    }

}
