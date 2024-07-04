import java.io.*;
import java.util.*;

public class Solution {
    private static final int NUMBER_OF_LINES = 10000;
    private static final int NUMBER_OF_DIGITS = 10;
    private static boolean[] isVisited;
    private static int U;
    private static long[] Q;
    private static String[] R;
    private static List<Character> dList;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder result = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                U = Integer.parseInt(br.readLine());
                isVisited = new boolean[NUMBER_OF_DIGITS];
                sb = new StringBuilder();
                Q = new long[NUMBER_OF_LINES];
                R = new String[NUMBER_OF_LINES];
                Set<Character> dSet = new HashSet<>();
                for (int i = 0; i < NUMBER_OF_LINES; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    Q[i] = Long.parseLong(st.nextToken());
                    R[i] = st.nextToken();
                    for (char c : R[i].toCharArray()) {
                        dSet.add(c);
                    }
                }
                dList = new ArrayList<>(dSet);
                String D = dfs();
                result.append(String.format("Case #%d: %s%n", t, D));
            }

            bw.write(result.toString());
            bw.flush();
        }
    }

    private static String dfs() {
        if (sb.length() == NUMBER_OF_DIGITS) {
            String D = sb.toString();
            return isValid(D) ? D : null;
        }

        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sb.append(dList.get(i));

                String D = dfs();
                if (D != null) {
                    return D;
                }

                isVisited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return null;
    }

    private static boolean isValid(String D) {
        Map<Character, Integer> dMap = new HashMap<>();
        for (int i = 0; i < D.length(); i++) {
            dMap.put(D.charAt(i), i);
        }

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            long decryptNumber = decrypt(dMap, R[i]);
            if (decryptNumber < 1 || Q[i] < decryptNumber) {
                return false;
            }
        }

        return true;
    }

    private static long decrypt(Map<Character, Integer> dMap, String R) {
        long result = 0;
        for (char r : R.toCharArray()) {
            result *= 10;
            result += dMap.get(r);
            if(result == 0){
                return -1;
            }
        }
        return result;
    }
}