import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine(); // Go to second line
        for (int i = 1; i <= t; i++) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int prev = 0;

            for (char c : s.toCharArray()){
                int n = c - '0';

                if (n > prev){
                    for (int j = 0; j < n - prev; j++){
                        sb.append('(');
                    }
                }else if (n < prev){
                    for (int j = 0; j < prev - n; j++){
                        sb.append(')');
                    }
                }
                sb.append(n);
                prev = n;
            }

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ')'){
                for (int j = 0; j < prev; j++){
                    sb.append(')');
                }
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
