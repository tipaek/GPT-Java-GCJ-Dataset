import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; ++t) {
            int X = in.nextInt(),Y=in.nextInt();
            char M[]=in.next().toCharArray();
            boolean done = false;
            for(int m = 0;m<M.length;m++) {
                done = false;
                if(M[m]=='S') Y--;
                if(M[m]=='N') Y++;
                if(M[m]=='E') X++;
                if(M[m]=='W') X--;
                if((m+1)>=(Math.abs(X) + Math.abs(Y))) {
                    System.out.println("Case #" + t + ": " + (m+1));
                    m=M.length;
                    done = true;
                }
            }
            if(!done) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}
