import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= t; ++i) {
            String[] temp = reader.readLine().split("[ ]");
            int X = Integer.parseInt(temp[0]);
            int Y = Integer.parseInt(temp[1]);
            String M = temp[2];


            System.out.println("Case #" + i + ": " + solution(X, Y, M));
        }
    }

    public static String solution(int X, int Y, String M) {
        if(X==0 && Y==0) {
            return String.valueOf(0);
        }

        for(int i=0;i<M.length();i++) {
            char c = M.charAt(i);
            if(c=='N') {
                Y++;
            } else if(c=='S') {
                Y--;
            } else if(c=='E') {
                X++;
            } else {
                X--;
            }
            if(Math.abs(X) + Math.abs(Y) <=(i+1)) {
                return String.valueOf(i+1);
            }
        }
        return "IMPOSSIBLE";
    }
}
