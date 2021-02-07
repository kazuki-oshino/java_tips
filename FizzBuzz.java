import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        forFizzBuzz();
        streamFizzBuzz();
    }

    public static void forFizzBuzz() {
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void streamFizzBuzz() {
        IntStream.rangeClosed(1, 30)
                 .mapToObj(i -> i%3==0 && i%5==0 ? "FizzBuzz" : i%3==0 ? "Fizz" : i%5==0 ? "Buzz" : i)
                 .forEach(System.out::println);
    }
}
