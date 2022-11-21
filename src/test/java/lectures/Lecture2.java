package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {
    IntStream.range(0,11).forEach(x -> System.out.println(x));
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0,people.size()).forEach(x -> System.out.println(people.get(x)));
  }

  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(0,operand -> operand+1)
              .filter(value -> value % 2 == 0)
              .limit(20)
              .forEach(System.out::println);
  }
}
