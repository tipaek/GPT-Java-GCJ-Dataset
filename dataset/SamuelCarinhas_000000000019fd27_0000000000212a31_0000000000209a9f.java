import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static String getSol(String s) {
        StringBuffer sol = new StringBuffer();
        int current = 0;
        for(int i = 0; i < s.length(); i++) {
            int t = s.charAt(i) - '0';
            if(t > current) {
                for(int j = 0; j < t - current; j++) {
                    sol.append('(');
                }
            } else {
                for(int j = 0; j < current - t; j++) {
                    sol.append(')');
                }
            }
            current = t;
            sol.append(s.charAt(i));
        }
        for(int j = 0; j < current; j++) {
            sol.append(')');
        }
        return sol.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(input.readLine());
        for(int t = 1; t <= tests; t++) {
            System.out.println("Case #" + t + ": " + getSol(input.readLine()));
        }
    }

}
