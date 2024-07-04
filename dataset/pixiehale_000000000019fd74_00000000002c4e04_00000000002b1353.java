import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.append("Case #").append(i+1).append(": ").append("\n");
            int n = Integer.parseInt(br.readLine());
            if (n<=500){
                for (int j = 0; j < n; j++) {
                    sb.append(j+1).append(" 1").append("\n");
                }
            } else if(n==501){
                sb.append("1 1").append("\n");
                sb.append("2 1").append("\n");
                for (int j = 2; j < 500; j++) {
                    sb.append(j+1).append(" 1").append("\n");
                }
            }else if (n<=1000){
                
                for (int j = 0; j < n; j++) {
                    sb.append(j+1).append(" 1").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
