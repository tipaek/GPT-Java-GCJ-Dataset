import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int n = s.length();
            sb.append("Case ").append(i+1).append(": ");
            int o[] = new int[n+1];
            int c[] = new int[n+1];
            for (int j = 0; j < 9; j++) {
                boolean in = false;
                for (int k = 0; k < n; k++) {
                    int posNum = s.charAt(k)-'0';
                    if (in){
                        if (posNum<=j) {
                            c[k]++;
                            in=false;
                        }
                    }else{
                        if (posNum>j){
                            o[k]++;
                            in = true;
                        }
                    }
                }
                if (in)
                    c[n]++;
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < c[j]; k++) {
                    sb.append(")");
                }
                for (int k = 0; k < o[j]; k++) {
                    sb.append("(");
                }
                sb.append(s.charAt(j));
            }
            for (int k = 0; k < c[n]; k++) {
                sb.append(")");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
