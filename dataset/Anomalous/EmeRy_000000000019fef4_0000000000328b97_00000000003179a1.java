import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static String solve() throws Exception {
        // Solve the problem
        BigInteger upperLimit = BigInteger.TEN.pow(nin()).subtract(BigInteger.ONE);

        Map<String, List<String>> translator = new HashMap<>();
        Map<Long, String> results = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            long keyLong = nlo();
            String value = nl();
            String key = Long.toString(keyLong);

            if (key.length() == value.length()) {
                List<String> list = translator.getOrDefault(key, new ArrayList<>());
                if (!list.contains(value)) {
                    list.add(value);
                }
                translator.put(key, list);
            }
        }

        // Process data and solve the problem
        String initial = "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        long i = 0;
        long limit = upperLimit.longValue();

        while (i < limit) {
            String key = String.valueOf(i);
            List<String> list = translator.get(key);

            if (list != null && list.size() == 1) {
                String value = list.get(0);
                results.put(i, value);

                for (int c = 0; c < value.length(); c++) {
                    long subKey = Long.parseLong(key.substring(c, c + 1));
                    String subValue = value.substring(c, c + 1);
                    results.put(subKey, subValue);

                    List<String> subList = new ArrayList<>();
                    subList.add(subValue);
                    translator.put(String.valueOf(subKey), subList);
                }
            }

            String next = initial.substring(0, key.length() + 1);
            i = Long.parseLong(next);
        }

        for (int x = 0; x <= 10; x++) {
            String stringX = String.valueOf(x);
            Long longX = Long.parseLong(stringX);
            List<String> list = translator.getOrDefault(stringX, new ArrayList<>());

            if (list.size() > 1) {
                for (int y = x - 1; y >= 0; y--) {
                    String stringY = String.valueOf(y);
                    Long longY = Long.parseLong(stringY);

                    if (list.contains(results.get(longY))) {
                        list.remove(results.get(longY));
                    }
                }

                translator.put(stringX, list);

                if (list.size() == 1) {
                    results.put(longX, list.get(0));
                }
            }
        }

        // Build the result string
        StringBuilder resultBuilder = new StringBuilder();
        for (int x = 0; x <= 9; x++) {
            resultBuilder.append(results.get(Long.parseLong(String.valueOf(x))));
        }

        return resultBuilder.toString();
    }

    static Scanner in;
    static BufferedWriter out;

    public static void main(String[] args) throws Exception {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = in.nextInt();

        for (int t = 1; t <= cases; t++) {
            out.write(String.format("Case #%d: %s\n", t, solve()));
        }

        out.flush();
    }

    static String nl() {
        return in.nextLine().trim();
    }

    static long nlo() {
        return in.nextLong();
    }

    static int nin() {
        return in.nextInt();
    }

    static double ndo() {
        return in.nextDouble();
    }

    static char nch() {
        return in.next().charAt(0);
    }
}