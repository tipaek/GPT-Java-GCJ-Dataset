import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nProblems = in.nextInt();
        int nBits = in.nextInt();

        for (int problem = 0; problem < nProblems; problem++) {
            String res = solve(nBits, in);
            if (res.equals("N")) {
                break;
            }
        }

    }

    private static String solve(int size, Scanner in) {

        boolean[] o = new boolean[150];
        boolean[] n = new boolean[150];

        for (int block = 0; block < 15; block++) {

            for (int dist = 0; dist < 5; dist++) {
                System.out.println(dist + 1); //2, first
                n[dist] = in.nextBoolean();

                System.out.println(size - dist); //3, last
                n[size - 1 - dist] = in.nextBoolean();
            }

            if (block == 0) {
                o = n; //nothing to compare
            } else {
                boolean ttStays = true;
                boolean tfStays = true;

                // check tt pairs
                for (int dist = 0; dist < 4; dist++) {
                    if (n[dist] == n[size-dist]) {
                        ttStays = o[dist] == n[dist];
                        break;
                    } ;
                };

                // check tf pairs
                for (int dist = 0; dist < 4; dist++) {
                    if (n[dist] != n[size-dist]) {
                        tfStays = o[dist] == n[dist];
                        break;
                    } ;
                };

                if (ttStays && !tfStays) o = reverse(n);
                if (!ttStays && tfStays) o = reverseAndComplement(n);
                if (!ttStays && !tfStays) o = complement(n);

            }
        }

        //postResult
        System.out.println(formatResult(o));
        return in.next(); //Y or N
    }

    private static boolean[] complement(boolean[] a) {
        boolean[] res = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[a.length-1-i];
        }
        return res;
    }

    private static boolean[] reverse(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = !a[i];
        }
        return a;
    }

    private static boolean[] reverseAndComplement(boolean[] a) {
        boolean[] res = reverse(a);
        return complement(res);
    }

    private static String formatResult(int[] result) {
        return Arrays.toString(result).replaceAll("\\[|\\]|,|\\s", "");
    }
}