import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        int T = Integer.parseInt(br.readLine());
        char c1 = '(', c2 = ')';
        for (int k=1; k <= T; k++) {
            String s = br.readLine();
            char[] chs = s.toCharArray();
            int left = chs[0] - '0';
            sb.append("Case #"+ k + ": ");
            for (int i=0; i<chs.length; i++) {
                int current = chs[i] - '0';
                int next = (i==chs.length - 1? 0: chs[i+1] - '0');
                while(left > 0) {
                    sb.append(c1);
                    left--;
                }
                sb.append(chs[i]);
                if (current < next) {
                    left = next - current;
                } else {
                    left = 0;
                    int right = current - next;
                    while(right > 0) {
                        sb.append(c2);
                        right--;
                    }
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}