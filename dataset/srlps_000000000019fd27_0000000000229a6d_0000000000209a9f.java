import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();

        List<Integer> s;
        String sPrime;
        for (int t = 1; t <= tests; ++t) {
            s = in.next().chars().map(c -> c - '0').collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            sPrime = enclose(s, 0).stream().map(x -> x == -1 ? "(" : (x == -2 ? ")" : String.format("%d", x)))
                    .collect(Collectors.joining());

            System.out.printf("Case #%d: %s\n", t, sPrime);
        }
    }

    private static List<Integer> enclose(List<Integer> list, int iteration) {
        int x = -1, y = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > iteration && x == -1) {
                x = i;
            } else if (list.get(i) <= iteration && x > -1) {
                y = i;
                break;
            }
        }
        if (x == -1) {
            return list;
        }
        y = y == -1 ? y = list.size() : y;
        return Stream
                .of(list.subList(0, x), Collections.singletonList(-1), enclose(list.subList(x, y), iteration + 1),
                        Collections.singletonList(-2), enclose(list.subList(y, list.size()), iteration))
                .flatMap(List::stream).collect(Collectors.toList());
    }
}