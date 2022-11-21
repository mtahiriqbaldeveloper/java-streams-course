package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11};
    Integer found = Arrays.stream(numbers).filter(x -> x > 10).findAny().orElseThrow(() -> new RuntimeException("not found"));
    System.out.println(found);
  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer result = Arrays.stream(numbers).filter(x -> x < 6).findFirst().get();
    System.out.println(result);

  }
}

