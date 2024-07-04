import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    private static Stream<String> generateBrackets(String bracket, boolean reverse) {
        return IntStream.rangeClosed(1, 9)
                .map(n -> reverse ? 10 - n : n)
                .boxed()
                .map(n -> IntStream.rangeClosed(1, n)
                        .mapToObj(i -> bracket)
                        .collect(Collectors.joining()));
    }

    private static final List<String> BRACKETS = Stream.concat(
            Stream.concat(generateBrackets(")", true), Stream.of("")),
            generateBrackets("(", false))
        .collect(Collectors.toList());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<String> inputStrings = new ArrayList<>(t);

        for (int i = 0; i < t; i++) {
            inputStrings.add("0" + scanner.next() + "0");
        }

        AtomicInteger caseNumber = new AtomicInteger(1);
        inputStrings.stream()
                .map(s -> Arrays.stream(s.split("(?<=.)(?=.)"))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
                .map(numbers -> IntStream.range(1, numbers.size())
                        .map(index -> numbers.get(index - 1) * 100 + 9 + numbers.get(index) - numbers.get(index - 1))
                        .mapToObj(n -> Math.abs(n / 100) + BRACKETS.get(n % 100))
                        .collect(Collectors.joining()))
                .map(result -> "Case #" + caseNumber.getAndIncrement() + ": " + result.substring(1))
                .forEachOrdered(System.out::println);
    }
}