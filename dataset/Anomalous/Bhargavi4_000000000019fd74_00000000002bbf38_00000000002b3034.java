import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tests = br.readLine();
        if (tests == null) return;

        int t = Integer.parseInt(tests);
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < t; k++) {
            sb.append("case #").append(k).append(": ");
            String num = br.readLine();
            if (num == null) return;

            int n = Integer.parseInt(num);
            String[] prefix = new String[n];
            String[] suffix = new String[n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                if (str == null) return;

                if (str.startsWith("*")) {
                    prefix[i] = "";
                    suffix[i] = str.substring(1);
                } else if (str.endsWith("*")) {
                    prefix[i] = str.substring(0, str.length() - 1);
                    suffix[i] = "";
                } else {
                    String[] s = str.split("\\*");
                    prefix[i] = s[0];
                    suffix[i] = s[s.length - 1];
                }
            }

            Arrays.sort(prefix, (a, b) -> Integer.compare(a.length(), b.length()));
            Arrays.sort(suffix, (a, b) -> Integer.compare(a.length(), b.length()));

            String outP = null;
            boolean isPrefixEmpty = false;
            for (String p : prefix) {
                if (p.isEmpty()) {
                    isPrefixEmpty = true;
                    continue;
                }
                if (outP == null) {
                    outP = p;
                } else if (p.contains(outP)) {
                    outP = p;
                } else {
                    outP = null;
                    break;
                }
            }

            String outS = null;
            boolean isSuffixEmpty = false;
            for (String s : suffix) {
                if (s.isEmpty()) {
                    isSuffixEmpty = true;
                    continue;
                }
                if (outS == null) {
                    outS = s;
                } else if (s.contains(outS)) {
                    outS = s;
                } else {
                    outS = null;
                    break;
                }
            }

            if (outP != null && !outP.isEmpty()) {
                sb.append(outP);
            }

            if (outS != null && !outS.isEmpty()) {
                sb.append(outS);
            }

            if ((outP == null || outP.isEmpty()) && (outS == null || outS.isEmpty())) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb.toString().trim());
    }
}