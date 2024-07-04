import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int nact = sc.nextInt();
            processing(nact, i + 1);
        }
    }

    public static void processing(int nact, int ncase) {
        Integer[][] ordered = new Integer[nact][2];
        for (int i = 0; i < nact; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            ordered[i][0] = start;
            ordered[i][1] = end;
        }
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (true) {
            int st = ordered[i][0];
            int ed = ordered[i][1];
            if (i + 1 < ordered.length) {
                //Get Next
                int overlapst = ordered[i + 1][0];

                //OVERLAP
                if (overlapst < ed) {
                    if (i + 2 != ordered.length) {
                        //IMPOSSIBLE
                        int overoverlapst = ordered[i + 2][0];
                        if (overoverlapst < ordered[i + 1][1] && overoverlapst < ed) {
                            result = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                    result.append("JC");
                    i = i + 2;
                } else {
                    //NO OVERLAP
                    result.append("J");
                    i++;
                }
            } else {
                result.append("J");
                break;
            }
        }
        System.out.println("Case #" + ncase + ":" + " " + result.toString());
    }
}
