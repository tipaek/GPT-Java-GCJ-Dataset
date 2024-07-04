import java.io.*;
import java.util.*;

public class Solution {
    private static final int NUMBER_OF_LINES = 10000;
    private static final int NUMBER_OF_DIGITS = 10;
    private static boolean[] isVisited;
    private static int[] Q;
    private static String[] R;
    private static List<Character> dList;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                int U = Integer.parseInt(br.readLine());
                isVisited = new boolean[10];
                sb = new StringBuilder();

                Q = new int[NUMBER_OF_LINES];
                R = new String[NUMBER_OF_LINES];
                Set<Character> dSet = new HashSet<>();
                for (int i = 0; i < NUMBER_OF_LINES; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    Q[i] = Integer.parseInt(st.nextToken());
                    R[i] = st.nextToken();
                    for (char c : R[i].toCharArray()) {
                        dSet.add(c);
                    }
                }
                dList = new ArrayList<>(dSet);

                sb.append(String.format("Case #%d: %s\n", t, dfs()));
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static String dfs() {
        if (sb.length() == 10) {
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
        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            int decryptNumber = decrypt(D, R[i]);
            if (Q[i] != -1 && Q[i] < decryptNumber) {
                return false;
            }
        }

        return true;
    }

    private static int decrypt(String D, String R) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < D.length(); i++) {
            map.put(D.charAt(i), i);
        }

        int result = 0;
        for (char r : R.toCharArray()) {
            result *= 10;
            result += map.get(r);
        }
        return result;
    }
}