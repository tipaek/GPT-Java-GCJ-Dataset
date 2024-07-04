import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
                int X = in.nextInt();
                int Y = in.nextInt();
                String M = in.next();
                String result = "IMPOSSIBLE";
                if (M.length() >= X) {
                    // move X to east
                    String Mx = M.substring(0, X);
                    long nbSouthMx = Mx.chars().filter(c -> c == 'S').count();
                    long pos = Y + (Mx.length() - nbSouthMx) - nbSouthMx;
                    if (pos == 0L) {
                        result = "" + X;
                    }
                    else {
                        String MLast = M.substring(X);
                        char[] chars = MLast.toCharArray();
                        for (int i1 = 0; i1 < chars.length; i1++) {
                            pos += (chars[i1] == 'S' ? -1 : +1);
                            if (pos == i1) {
                                result = "" + (X+i1+1);
                                break;
                            }
                        }
                    }

                }
                System.out.println("case #" + i + ": " + result);
            }
        }

}
