import java.util.*;

public class Solution {
    Scanner sc = new Scanner(System.in);

    void run(){
        int tests = sc.nextInt();

        for( int t = 0; t < tests; t++){
            solve(t);
        }
    }

    void solve(int t){
        int X = sc.nextInt();
        int Y = sc.nextInt();
        String M = sc.next();
        char[] m = M.toCharArray();
        System.out.print("Case #" + (t+1) +": ");

        for(int i = 0; i < M.length(); i++) {
            int dist = Math.abs(X) + Math.abs(Y);
            if (dist <= i) {
                System.out.println(i);
                return;
            }

            char step = m[i];
            if (step == 'N') {
                Y += 1;
            } else if (step == 'E') {
                X += 1;
            } else if (step == 'S') {
                Y -= 1;
            } else {
                X -= 1;
            }

        }

        if (Math.abs(X) + Math.abs(Y) <= M.length()) {
            System.out.println(M.length());
        } else {
            System.out.println("IMPOSSIBLE");
        }


    }

    public static void main(String[] args){
        (new Solution()).run();
    }
}
