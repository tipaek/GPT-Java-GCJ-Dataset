import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static final int STEPS = 12;

    private static class Pair {
        long first;
        long second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public static void main(String[] args) {
        Map<Pair, char[]> field = new HashMap<>();
        Map<Pair, char[]> globalField = new HashMap<>();
        field.put(new Pair(0, 0), new char[STEPS]);
        long step = 1;
        for (int i = 0; i < STEPS; i++) {
            Map<Pair, char[]> nextField = new HashMap<>();
            for (Map.Entry<Pair, char[]> entry : field.entrySet()) {
                long first = entry.getKey().first;
                long second = entry.getKey().second;

                Pair left = new Pair(first - step, second);
                if (!field.containsKey(left)) {
                    char[] copied = Arrays.copyOf(entry.getValue(), STEPS);
                    copied[i] = 'W';
                    nextField.put(left, copied);
                }

                Pair right = new Pair(first + step, second);
                if (!field.containsKey(right)) {
                    char[] copied = Arrays.copyOf(entry.getValue(), STEPS);
                    copied[i] = 'E';
                    nextField.put(right, copied);
                }

                Pair up = new Pair(first, second - step);
                if (!field.containsKey(up)) {
                    char[] copied = Arrays.copyOf(entry.getValue(), STEPS);
                    copied[i] = 'N';
                    nextField.put(up, copied);
                }

                Pair down = new Pair(first, second + step);
                if (!field.containsKey(down)) {
                    char[] copied = Arrays.copyOf(entry.getValue(), STEPS);
                    copied[i] = 'S';
                    nextField.put(down, copied);
                }
            }
            field = nextField;
            nextField.forEach(globalField::putIfAbsent);
            step *= 2;
        }

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            Pair target = new Pair(x, y);
            if (globalField.containsKey(target)) {
                StringBuilder sb = new StringBuilder();
                for (char c : globalField.get(target)) {
                    if (Character.isAlphabetic(c)) {
                        sb.append(c);
                    }
                }
                System.out.println(String.format("Case #%d: %s", i, sb.reverse().toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", i));
            }
        }
    }
}
