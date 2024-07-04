import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(reader.readLine());

            if (D == 2) {
                boolean hasDuplicate = false;
                HashSet<Long> numbers = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    long x = Long.parseLong(st.nextToken());
                    if (numbers.contains(x)) {
                        hasDuplicate = true;
                        break;
                    }
                    numbers.add(x);
                }
                System.out.println("Case #" + t + ": " + (hasDuplicate ? 0 : 1));
            } else {
                boolean zero = false;
                boolean one = false;
                HashMap<Long, Integer> numberCounts = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    long x = Long.parseLong(st.nextToken());
                    int count = numberCounts.getOrDefault(x, 0);

                    if (count == 2) {
                        zero = true;
                        break;
                    }

                    if (x % 2 == 0 && numberCounts.containsKey(x / 2)) {
                        one = true;
                    }

                    if (numberCounts.containsKey(x * 2)) {
                        one = true;
                    }

                    numberCounts.put(x, count + 1);
                }

                if (zero) {
                    System.out.println("Case #" + t + ": 0");
                } else if (one) {
                    System.out.println("Case #" + t + ": 1");
                } else {
                    System.out.println("Case #" + t + ": 2");
                }
            }
        }
    }
}