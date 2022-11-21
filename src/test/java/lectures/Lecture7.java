package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    List<Person> personList = MockData.getPeople();
    long female = personList.stream().filter(person -> person.getGender().equalsIgnoreCase("Female")).count();
    System.out.println(female);
  }

  @Test
  public void min() throws Exception {
    double yellow = MockData.getCars()
            .stream().filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .min().getAsDouble();
  }

  @Test
  public void max() throws Exception {
    double yellow = MockData.getCars()
            .stream().filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .max().getAsDouble();
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double carPriceAverage = cars.stream().mapToDouble(car -> car.getPrice()).average().getAsDouble();
    System.out.print(carPriceAverage);


  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream().mapToDouble(Car::getPrice).sum();
    BigDecimal bigDecimal = new BigDecimal(String.valueOf(sum));
    System.out.println(bigDecimal);



  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics doubleSummaryStatistics = cars.stream().mapToDouble(Car::getPrice).summaryStatistics();
    System.out.println(doubleSummaryStatistics.getMax());
    System.out.println(doubleSummaryStatistics.getAverage());
    System.out.println(doubleSummaryStatistics.getCount());
    System.out.println(doubleSummaryStatistics.getSum());


  }

}