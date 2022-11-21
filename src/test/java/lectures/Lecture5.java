package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> lowPriceCars = cars.stream().filter(predicateCar)
            .collect(Collectors.toList());
    lowPriceCars.forEach(System.out::println);

  }
  final Predicate<Car> predicateCar = car -> car.getPrice() > 1000;
  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> personDTOS = people
            .stream()
            .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
            .collect(Collectors.toList());

    List<PersonDTO> personDTO = people
            .stream()
            .map(PersonDTO::map)
            .collect(Collectors.toList());
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    double averagePrice = cars.stream().mapToDouble(car -> car.getPrice()).average().orElse(0);
    System.out.print(averagePrice);
  }

  @Test
  public void test() throws Exception {

  }
}



