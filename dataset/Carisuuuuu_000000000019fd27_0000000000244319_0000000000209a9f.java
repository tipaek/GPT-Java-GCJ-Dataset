import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    private static Stream<String> brackets(String bracket, boolean reverse) {
        return IntStream.rangeClosed(1, 9)
                .map(n -> reverse ? 10 - n : n)
//                .peek(System.out::print)
                .boxed()
                .map(n -> IntStream.rangeClosed(1, n)
                        .mapToObj(d -> bracket)
                        .collect(Collectors.joining()))
//                .peek(System.out::println);
        ;
    }

    private static final List<String> BRACKETS = Stream.concat(
            Stream.concat(brackets(")", true), Stream.of(""))
            , brackets("(", false))
        .collect(Collectors.toList());

    public static void main(String[] args) {
//        System.out.println(BRACKETS);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<String> ss = new ArrayList<>(t);
        for (int g = 1; g <= t; ++g) {
            ss.add("0" + in.next() + "0");
        }
        AtomicInteger gp = new AtomicInteger(1);
        ss.stream()
//                .peek(System.out::println)
                .map(s -> Arrays.stream(s.split("(?<=.)(?=.)"))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
//                .peek(System.out::println)
                .map(sl -> IntStream.range(1, sl.size())
                            .map(p -> sl.get(p-1)*100 + 9 + sl.get(p) - sl.get(p-1))
//                            .peek(System.out::println)
                            .mapToObj(n -> Math.abs(n/100) + BRACKETS.get(n%100))
//                            .peek(System.out::println)
                            .collect(Collectors.joining()))
                .map(s -> "Case #" + gp.getAndAdd(1) + ": " + s.substring(1))
                .forEachOrdered(System.out::println);

//            Pattern p = Pattern.compile("1(2+)");
//            n = p.matcher(n).replaceAll("1($1");
//            System.out.print(n + " ");
//            p = Pattern.compile("(2+)1");
//            n = p.matcher(n).replaceAll("$1)1");
//            System.out.print(n + " ");
//            p = Pattern.compile("(^|[^()])(2+)");
//            n = p.matcher(n).replaceAll("$1(($2");
//            System.out.print(n + " ");
//            p = Pattern.compile("(2+)([^()]|$)");
//            n = p.matcher(n).replaceAll("$1))$2");
//            System.out.print(n + " ");
//            p = Pattern.compile("([^)]|^)(1+)");
//            n = p.matcher(n).replaceAll("$1($2");
//            System.out.print(n + " ");
//            p = Pattern.compile("(1+)([^(]|$)");
//            n = p.matcher(n).replaceAll("$1)$2");
//            System.out.println(n + " ");
    }
}
