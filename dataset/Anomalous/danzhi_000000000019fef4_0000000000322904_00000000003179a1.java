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
            sb.append(it.next());
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

            TreeSet<Character> characters = new TreeSet<>();
            TreeMap<Character, Integer> frequencyMap = new TreeMap<>();

            for (QR query : queries) {
                char firstChar = query.R.charAt(0);
                frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0) + 1);
                for (char c : query.R.toCharArray()) {
                    characters.add(c);
                }
            }

            for (char c : characters) {
                frequencyMap.putIfAbsent(c, 0);
            }

            TreeMap<Integer, Character> reverseMap = new TreeMap<>();
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                reverseMap.put(entry.getValue(), entry.getKey());
            }

            StringBuilder result = new StringBuilder();
            for (char c : reverseMap.values()) {
                result.append(c);
            }

            System.out.format("Case #%d: %s\n", t, result.toString());
        }
        in.close();
    }
}