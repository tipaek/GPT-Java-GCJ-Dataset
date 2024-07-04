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
        int x = t + 1;
        String S = sc.next();
        int open = 0;

        System.out.print("Case #" + x + ": ");

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int n = c - '0';
            if (n == open) {
                System.out.print(c);
            } else if (n > open) {
                while (n > open) {
                    open++;
                    System.out.print("(");
                }
                System.out.print(c);
            } else {
                while (n < open) {
                    open--;
                    System.out.print(")");
                }
                System.out.print(c);
            }
        }


        while (open > 0) {
            open--;
            System.out.print(")");
        }
        System.out.println();
    }

    public static void main(String[] args){
        (new Solution()).run();
    }
}
