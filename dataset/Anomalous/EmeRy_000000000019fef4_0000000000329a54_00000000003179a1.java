import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final BigInteger TEN = new BigInteger("10");
    private static final String LARGE_NUMBER = "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
    
    private static String solve() throws Exception {
        BigInteger upperLimit = TEN.pow(nin()).subtract(BigInteger.ONE);
        Map<String, List<String>> translator = new HashMap<>();
        Map<Long, String> results = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            long q = nlo();
            String r = nl();
            String key = Long.toString(q);

            if (key.length() == r.length()) {
                translator.computeIfAbsent(key, k -> new ArrayList<>());
                List<String> list = translator.get(key);
                if (!list.contains(r)) {
                    list.add(r);
                }
            }
        }

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
                    translator.put(Long.toString(subKey), Collections.singletonList(subValue));
                }
            }
            i = Long.parseLong(LARGE_NUMBER.substring(0, key.length() + 1));
        }

        do {
            for (int x = 0; x <= limit; x++) {
                String stringX = String.valueOf(x);
                List<String> list = translator.getOrDefault(stringX, new ArrayList<>());

                if (list.size() > 1) {
                    for (int y = x - 1; y >= 0; y--) {
                        String stringY = String.valueOf(y);
                        String resValue = results.get((long) y);
                        if (list.contains(resValue)) {
                            list.remove(resValue);
                        }
                    }
                    translator.put(stringX, list);
                    if (list.size() == 1) {
                        results.put((long) x, list.get(0));
                    }
                }
            }

            StringBuilder resultBuilder = new StringBuilder();
            for (int x = 0; x <= 9; x++) {
                resultBuilder.append(results.get((long) x));
            }
            String result = resultBuilder.toString();
            if (result.length() == 10) {
                return result;
            } else {
                if (String.valueOf(i).equals(upperLimit.toString())) {
                    i = 0;
                }
            }
        } while (i < limit);

        return "";
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