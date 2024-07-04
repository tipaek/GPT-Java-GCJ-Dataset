import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str[] = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);
            int num = 0;
            int rs = r; int ss = s;
            StringBuilder sb2 = new StringBuilder();
            for (int j = r; j >1 ; j--) {
                int s1 = j*(s-1);
                int s2 = r*s -1;
                for (int k = s; k >1; k--) {
                    sb2.append(s1).append(" ").append(s2).append("\n");
                    s1--;
                    s2--;
                    num++;
                }
            }
            sb.append("Case #").append(i+1).append(": ");
            sb.append(num).append("\n").append(sb2);

        }
            System.out.println(sb);
        }
}
