import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class NestingDepth {

    static Scanner scanner = new Scanner(System.in);
    static List<Character> filtered;
    static List<Integer> depths;
    static int t;

    public static void main(String[] args) {
        t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            String input = scanner.next();
            StringBuilder buffer = new StringBuilder();

            filtered = input.chars()
                    .filter(c -> c != '(' && c != ')')
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());

            depths = new ArrayList<>(filtered.size());
            filtered.forEach(c -> depths.add(Character.getNumericValue(c)));
            solve();

            filtered.forEach(buffer::append);
            System.out.println("Case #" + i + ": " + buffer.toString());
        }
    }

    static void solve() {
        boolean found = false;
        int range = 0, index = 0;
        int n = filtered.size();

        for (int i = 0; i < n; ++i) {
            if (!found && depths.get(i) == 0) {
                continue;
            } else if (!found) {
                found = true;
                index = i;
                ++range;
            } else if (found && depths.get(i) > 0) {
                ++range;
            }

            if (found && (depths.get(i) == 0 || i == n - 1)) {
                int minDepth = depths.subList(index, index + range).stream().min(Integer::compare).orElse(0);

                for (int k = 0; k < minDepth; ++k) {
                    filtered.add(index, '(');
                    depths.add(index, 0);
                    index++;
                    filtered.add(index + range, ')');
                    depths.add(index + range, 0);
                }

                for (int v = index; v < index + range; ++v) {
                    depths.set(v, depths.get(v) - minDepth);
                }

                found = false;
                i = -1;  // reset loop to start from the beginning
                n = filtered.size();
                range = 0;
                index = 0;
            }
        }
    }
}