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

        boolean[] o = new boolean[size];
        boolean[][] n = new boolean[5][2];

        for (int block = 0; block < 15; block++) {

            int blockDist = 5 * block;
            if (blockDist >= size / 2) {
                blockDist = 0;
            }
            System.err.println("Blockdist for block=" + block + ": " + blockDist);
            for (int dist = blockDist; dist < blockDist + 5; dist++) {
                System.out.println(dist + 1);
                n[dist-blockDist][0] = in.nextInt() == 1;

                System.out.println(size - dist);
                n[dist-blockDist][1] = in.nextInt() == 1;
            }

            System.err.println("Old after block=" + block + ": " + formatResult(o));

            if (block != 0) {
                //check what happened
                boolean ttStays = true;
                boolean tfStays = true;

                // check tt pairs
                for (int i = 0; i < 5; i++) {
                    if (n[i][0] == n[i][1]) {
                        ttStays = o[blockDist + i] == n[i][0];
                        break;
                    }
                }

                // check tf pairs
                for (int i = 0; i < 5; i++) {
                    if (n[i][0] != n[i][1]) {
                        tfStays = o[blockDist + i] == n[i][0];
                        break;
                    }
                }

                if (ttStays && !tfStays) {
                    System.err.println("reverse");
                    o = reverse(o);
                }
                if (!ttStays && tfStays) {
                    System.err.println("reverse+complement");
                    o = reverseAndComplement(o);
                }
                if (!ttStays && !tfStays) {
                    System.err.println("complement");
                    o = complement(o);
                }
                if (ttStays && tfStays) {
                    System.err.println("nothing");
                }
            }

            //persist updated values
            for (int dist = blockDist; dist < blockDist+5; dist++) {
                o[dist] = n[dist-blockDist][0];
                o[size - 1 - dist] = n[dist-blockDist][1];
            }

            System.err.println("Reordered old after block=" + block + ": " + formatResult(o));
        }

        //postResult
        System.out.println(formatResult(o));
        return in.next(); //Y or N
    }

    private static boolean[] complement(boolean[] a) {
        boolean[] res = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = a[a.length - 1 - i];
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

    private static String formatResult(boolean[] result) {
        StringBuilder res = new StringBuilder();
        for (boolean val : result) {
            if (val) {
                res.append("1");
            } else {
                res.append("0");
            }
        }
        return res.toString();
    }
}