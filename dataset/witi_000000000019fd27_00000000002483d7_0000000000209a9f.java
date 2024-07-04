import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int t = 1; t<=T; t++) {

            String S = in.next();
            int[] numA = new int[S.length()];
            for (int i = 0; i < S.length(); i++)
                numA[i] = Character.getNumericValue(S.charAt(i));


            int[] open = new int[S.length()];
            int[] close = new int[S.length()];

            for (int i = 0; i < S.length(); i++) {
                while (numA[i] > 0) {
                    open[i] += 1;
                    opened(i, close, numA);
                }
            }


            String out = new String("Case #" + t + ": ");

            for (int i=0;i< S.length(); i++) {
                for (int count=0; count < open[i]; count ++)
                    out = out + "(";
                out = out + S.charAt(i);
                for (int count=0; count < close[i]; count ++)
                    out = out + ")";
            }

            System.out.println(out);

        }
    }
    static void opened(int i, int[] close, int[] numA ) {
        numA[i]--;
        if (i+1 >= numA.length || numA[i+1] == 0)
            close[i]++;
        else {
            opened(i+1, close, numA);
        }

    }
}
