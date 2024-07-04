import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.*;

public class Solution {
    final static String USER_DIR = System.getProperty("user.dir");
    final static String CNAME = MethodHandles.lookup().lookupClass().getName();
    final static Random RAND = new Random();

    static String join(Collection<?> objs) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) sb.append(',');
        }
        return sb.toString();
    }

    static class QR {
        int Q;
        String R;
        int qlen;
        int lead;

        public QR(int q, String r) {
            this.Q = q;
            this.R = r;
            this.qlen = Integer.toString(Q).length();
            this.lead = Integer.toString(Q).charAt(0) - '0';
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

            TreeSet<Character> characters = new TreeSet<>();
            for (QR query : queries) {
                for (char c : query.R.toCharArray()) {
                    characters.add(c);
                }
            }

            TreeSet<Character> zeros = new TreeSet<>(characters);
            for (QR query : queries) {
                zeros.remove(query.R.charAt(0));
            }

            TreeMap<Character, TreeSet<Integer>> potentialValues = new TreeMap<>();
            char zeroChar = zeros.first();
            for (char c : characters) {
                if (c != zeroChar) {
                    TreeSet<Integer> values = new TreeSet<>();
                    for (int i = 1; i <= 9; i++) {
                        values.add(i);
                    }
                    potentialValues.put(c, values);
                }
            }

            TreeMap<Character, Integer> charToValue = new TreeMap<>();
            TreeMap<Integer, Character> valueToChar = new TreeMap<>();
            valueToChar.put(0, zeroChar);
            charToValue.put(zeroChar, 0);

            for (int i = 0; i < 10; i++) {
                if (valueToChar.size() >= 10) break;
                for (QR query : queries) {
                    if (query.qlen == query.R.length()) {
                        char c = query.R.charAt(0);
                        if (charToValue.containsKey(c)) continue;
                        TreeSet<Integer> values = potentialValues.get(c);
                        values.removeIf(v -> v > query.lead);
                        values.removeAll(valueToChar.keySet());
                        if (values.size() == 1) {
                            int value = values.first();
                            valueToChar.put(value, c);
                            charToValue.put(c, value);
                        }
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (char c : valueToChar.values()) {
                result.append(c);
            }
            System.out.format("Case #%d: %s\n", t, result.toString());
        }
        in.close();
    }
}