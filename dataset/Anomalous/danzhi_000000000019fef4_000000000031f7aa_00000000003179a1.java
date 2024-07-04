import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();
    private static final Random RAND = new Random();

    private static String join(Collection<?> objs) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        boolean first = true;
        while (it.hasNext()) {
            if (!first) sb.append(',');
            sb.append(it.next().toString());
            first = false;
        }
        return sb.toString();
    }

    private static class QR {
        int Q;
        String R;

        QR(int q, String r) {
            this.Q = q;
            this.R = r;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File fin = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner in = fin.exists() ? new Scanner(fin) : new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int U = in.nextInt();
            List<QR> queries = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                queries.add(new QR(in.nextInt(), in.next()));
            }
            queries.sort(Comparator.comparingInt(o -> o.Q));

            TreeSet<Character> uniqueChars = new TreeSet<>();
            for (QR query : queries) {
                for (char c : query.R.toCharArray()) {
                    uniqueChars.add(c);
                }
            }

            TreeSet<Character> possibleZeros = new TreeSet<>(uniqueChars);
            for (QR query : queries) {
                possibleZeros.remove(query.R.charAt(0));
            }

            TreeMap<Character, TreeSet<Integer>> charValues = new TreeMap<>();
            char zeroChar = possibleZeros.first();
            for (char c : uniqueChars) {
                if (c == zeroChar) continue;
                TreeSet<Integer> values = new TreeSet<>();
                for (int i = 1; i <= 9; i++) {
                    values.add(i);
                }
                charValues.put(c, values);
            }

            TreeMap<Character, Integer> charToValueMap = new TreeMap<>();
            TreeMap<Integer, Character> valueToCharMap = new TreeMap<>();
            valueToCharMap.put(0, zeroChar);
            charToValueMap.put(zeroChar, 0);

            for (QR query : queries) {
                if (query.Q < 10) {
                    char c = query.R.charAt(0);
                    if (charToValueMap.containsKey(c)) continue;
                    TreeSet<Integer> values = charValues.get(c);
                    for (int m = query.Q + 1; m < 10; m++) {
                        values.remove(m);
                    }
                    values.removeAll(valueToCharMap.keySet());
                    if (values.size() == 1) {
                        int value = values.first();
                        valueToCharMap.put(value, c);
                        charToValueMap.put(c, value);
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (char c : valueToCharMap.values()) {
                result.append(c);
            }
            System.out.format("Case #%d: %s\n", t, result.toString());
        }
        in.close();
    }
}