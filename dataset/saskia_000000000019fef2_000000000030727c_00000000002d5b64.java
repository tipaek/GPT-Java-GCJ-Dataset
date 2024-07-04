import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++)
        {

            int r = in.nextInt();
            int s = in.nextInt();
            int rCurr = r;
            int sCurr = s;
            int tot = r * s;
            int sInt = s;
            HashMap<Integer, int[]> endOrder = new HashMap<>();
            int counter = -1;

            while(true) {

                int[] result = null;


                //System.out.println(r + " " + rCurr + " " + s + " " + sCurr );
                if (r > s) {
                    result = rGreaterS(rCurr, sCurr);
                    rCurr--;
                    //sCurr--;
                }

                if (s > r ) {
                    /*int sub = 0;
                    if (tot % 2 > 0) {
                        sub = 1;
                    }*/
                    sCurr = tot - r - 1;
                    result = sGreaterR(rCurr, sCurr);
                    sCurr--;
                }

                if (r == s) {
                    //sCurr = (s * r) - r - 1;
                    int x = 0;
                    if (sCurr == s * r - r - 1)
                        x = sCurr;
                    else
                        x = tot - r - 1;
                    result = sEqualR(rCurr, x);
                    sCurr--;
                    if (sCurr < r) {
                        //System.out.println(sCurr + " " + r + " " + rCurr);
                        r--;
                        sCurr--;
                        rCurr = r;
                    }
                }


                if (rCurr <= 1) {
                    r--;
                }

                if (sCurr < 1) {
                    s--;
                }

                tot--;


                //System.out.println(r + " " + rCurr + " " + s + " " + sCurr );
                if (r < 1 || s < 1 || sCurr <= 0 || rCurr <= 0 || sCurr + rCurr < sInt) {
                    break;
                }

                counter++;
                endOrder.put(counter, result);

            }

            int caseNo = i+1;
            System.out.println("Case #" + caseNo + ": " + endOrder.size());
            for (int j = 0; j < endOrder.size(); j++) {
                int[] res = endOrder.get(j);
                System.out.println(res[0] + " " + res[1]);
            }

        }

    }


    public static int[] rGreaterS(int r, int s) {
        int[] result = new int[2];
        result[0] = r;
        result[1] = (r * s) - r - 1;

        return result;
    }

    public static int[] sGreaterR(int r, int s) {
        int[] result = new int[2];
        result[0] = r;
        result[1] = s;

        return result;
    }

    public static int[] sEqualR(int r, int s) {
        int[] result = new int[2];
        result[0] = r;
        result[1] = s;

        return result;
    }

}
