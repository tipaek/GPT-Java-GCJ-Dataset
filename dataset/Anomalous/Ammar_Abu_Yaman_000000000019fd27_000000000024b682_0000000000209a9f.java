import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Character> filtered;
    static List<Integer> depths;
    static int n, t;
    static String input;

    public static void main(String[] args) {
        t = scanner.nextInt();
        StringBuilder buffer = new StringBuilder();

        for (int i = 1; i <= t; ++i) {
            input = scanner.next();
            buffer.setLength(0);

            filtered = input.chars()
                    .filter(c -> c != '(' && c != ')')
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());

            n = filtered.size();
            depths = new ArrayList<>(n);
            filtered.forEach(c -> depths.add(Character.getNumericValue(c)));
            solve();

            filtered.forEach(buffer::append);
            System.out.println("Case #" + i + " " + buffer.toString());
        }
    }

    static void solve() {
        boolean found = false;
        int range = 0, index = 0;
        int n_copy = n;

        for (int i = 0; i < n_copy; ++i) {
            if (!found && depths.get(i) == 0) {
                continue;
            } else if (!found) {
                found = true;
                index = i;
                ++range;
            } else if (found && depths.get(i) > 0) {
                ++range;
            }

            if (found && (depths.get(i) == 0 || i == n_copy - 1)) {
                int min = depths.subList(index, index + range).stream().min(Integer::compare).orElse(10);

                for (int k = 0; k < min; ++k) {
                    filtered.add(index, '(');
                    depths.add(index, 0);
                    ++index;

                    filtered.add(index + range, ')');
                    depths.add(index + range, 0);
                }

                for (int v = index; v < index + range; ++v) {
                    depths.set(v, depths.get(v) - min);
                }

                found = false;
                i = -1;
                n_copy = filtered.size();
                range = 0;
                index = 0;
            }
        }
    }
}