import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.*;

public class Solution {
    // The complete absolute path from where application was initialized.
    final static String USER_DIR = System.getProperty("user.dir");
    final static String CNAME = MethodHandles.lookup().lookupClass().getName();
    final static Random RAND = new Random();

    static String join(Collection<?> objs) {
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

            TreeSet<Character> uniqueChars = new TreeSet<>();
            TreeMap<Character, Integer> charFrequency = new TreeMap<>();

            for (QR query : queries) {
                char firstChar = query.R.charAt(0);
                charFrequency.put(firstChar, charFrequency.getOrDefault(firstChar, 0) + 1);
                for (char c : query.R.toCharArray()) {
                    uniqueChars.add(c);
                }
            }

            char zeroChar = 0;
            for (char c : uniqueChars) {
                if (!charFrequency.containsKey(c)) {
                    zeroChar = c;
                    break;
                }
            }

            TreeMap<Integer, Character> reverseFrequencyMap = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
                reverseFrequencyMap.put(entry.getValue(), entry.getKey());
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroChar);
            for (char c : reverseFrequencyMap.values()) {
                result.append(c);
            }

            System.out.format("Case #%d: %s\n", t, result.toString());
        }

        in.close();
    }
}