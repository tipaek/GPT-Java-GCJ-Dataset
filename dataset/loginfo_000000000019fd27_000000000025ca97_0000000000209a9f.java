import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                String S = br.readLine();
                sb.append("Case #").append(t).append(": ").append(gogo(S)).append('\n');
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static String gogo(String S) {
        List<Character> result = new LinkedList<>();
        for (char c : S.toCharArray()) {
            result.add(c);
        }

        for (int loop = 0; loop < 10; loop++) {
            boolean start = false;
            for (int i = 0; i < result.size(); i++) {
                char c = result.get(i);
                int remain = c - '0' - loop;
                if (start && (!isNumber(c) || remain <= 0)) {
                    start = false;
                    result.add(i++, ')');
                } else if (!start && remain > 0) {
                    start = true;
                    result.add(i++, '(');
                    if ((i == result.size() - 1)) {
                        result.add(++i, ')');
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(sb::append);
        return sb.toString();
    }

    private static boolean isNumber(char c) {
        int number = c - '0';
        return 0 < number && number < 10;
    }
}