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
            HashMap<Integer, int[]> endOrder = new HashMap<>();
            int counter = -1;

            while(true) {

                int[] result = null;



                if (r > s) {
                    result = rGreaterS(rCurr, sCurr);
                    rCurr--;
                    //sCurr--;
                }

                if (s > r) {
                    sCurr = tot - r - 1;
                    result = sGreaterR(rCurr, sCurr);
                    sCurr--;
                }

                if (r == s) {
                    result = sEqualR(rCurr);
                    rCurr--;
                }


                if (rCurr <= 1) {
                    r--;
                }

                if (sCurr < 1) {
                    s--;
                }

                tot--;


                //System.out.println(r + " " + rCurr + " " + s + " " + sCurr );
                if (r < 1 || s < 1 || sCurr <= 0 || rCurr <= 0) {
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
        int[] result = new int[4];
        result[0] = r;
        result[1] = (r * s) - r - 1;

        if (r == 1)
        result[2] = r-1;
        result[3] = s-1;
        return result;
    }

    public static int[] sGreaterR(int r, int s) {
        int[] result = new int[4];
        result[0] = r;
        result[1] = s;

        result[2] = r;
        result[3] = s-1;
        return result;
    }

    public static int[] sEqualR(int r) {
        int[] result = new int[4];
        result[0] = r;
        result[1] = (r * r) - r - 1;

        result[2] = r-1;
        result[3] = r;
        return result;
    }

}
