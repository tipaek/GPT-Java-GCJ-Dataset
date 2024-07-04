import java.util.Arrays;
import java.util.Scanner;

public  class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int N = sc.nextInt();
            String[] S = new String[N];
            for (int i=0; i<N; i++) {
                S[i] = sc.next();
            }

            System.out.println("Case #" + (t+1) + ": " + solve(N, S));
        }
    }

    private static String solve(int N, String[] S) {
        String front = "";
        String back = "";

        for (int i=0; i<N; i++) {
            String[] token = S[i].split("\\*", 2);
            
            // System.err.println("ans=" + front + "," + back + ", token=" + Arrays.toString(token));

            if (token[0].startsWith(front) || front.equals("")) {
                front = token[0];
            } else if (front.startsWith(token[0])) {
            } else {
                return "*";
            }

            if (token[1].endsWith(back) || back.equals("")) {
                back = token[1];
            } else if (back.endsWith(token[1])) {
            } else {
                return "*";
            }
        }


        return front + back;
    }
}
