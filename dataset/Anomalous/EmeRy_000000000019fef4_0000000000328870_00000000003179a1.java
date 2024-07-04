import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    private static String solve() throws Exception {
        // Solve the problem
        BigInteger upperLimit = BigInteger.TEN.pow(readInt()).subtract(BigInteger.ONE);

        Map<String, List<String>> translator = new HashMap<>();
        Map<Long, String> results = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            long number = readLong();
            String text = readLine();
            String key = Long.toString(number);

            if (key.length() == text.length()) {
                List<String> list = translator.getOrDefault(key, new ArrayList<>());
                if (!list.contains(text)) {
                    list.add(text);
                }
                translator.put(key, list);
            }
        }

        String initial = "1" + "0".repeat(250);
        long i = 0;
        long limit = Long.parseLong(upperLimit.toString());

        while (i < limit) {
            String key = Long.toString(i);
            if (translator.containsKey(key) && translator.get(key).size() == 1) {
                String value = translator.get(key).get(0);
                results.put(i, value);

                for (int c = 0; c < value.length(); c++) {
                    long subKey = Long.parseLong(key.substring(c, c + 1));
                    String subValue = value.substring(c, c + 1);
                    results.put(subKey, subValue);

                    List<String> list = new ArrayList<>();
                    list.add(subValue);
                    translator.put(key.substring(c, c + 1), list);
                }
            }
            i = Long.parseLong(initial.substring(0, key.length() + 1));
        }

        for (int x = 0; x <= 10; x++) {
            String stringX = String.valueOf(x);
            long longX = Long.parseLong(stringX);
            List<String> list = translator.getOrDefault(stringX, new ArrayList<>());

            if (list.size() > 1) {
                for (int y = x - 1; y >= 0; y--) {
                    String stringY = String.valueOf(y);
                    long longY = Long.parseLong(stringY);

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

        StringBuilder resultBuilder = new StringBuilder();
        for (int x = 0; x <= 9; x++) {
            resultBuilder.append(results.get(Long.parseLong(String.valueOf(x))));
        }

        return resultBuilder.toString();
    }

    private static Scanner in;
    private static BufferedWriter out;

    public static void main(String[] args) throws Exception {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = in.nextInt();
        for (int t = 1; t <= cases; t++) {
            out.write(String.format("Case #%d: %s\n", t, solve()));
        }
        out.flush();
    }

    private static String readLine() {
        return in.nextLine().trim();
    }

    private static long readLong() {
        return in.nextLong();
    }

    private static int readInt() {
        return in.nextInt();
    }

    private static double readDouble() {
        return in.nextDouble();
    }

    private static char readChar() {
        return in.next().charAt(0);
    }
}