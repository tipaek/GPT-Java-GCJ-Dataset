import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int trace = 0;
            int nR = 0;
            int nC = 0;

            boolean[] flagC = new boolean[N];
            Arrays.fill(flagC, Boolean.TRUE);
            Map<Integer, Boolean>[] colEle = new HashMap[N];
            for (int k = 0; k < N; k++)
                colEle[k] = new HashMap<>();
            for (int j = 0; j < N; j++) {
                boolean flagR = true;
                Map<Integer, Boolean> rowEle = new HashMap<>();
                for (int k = 0; k < N; k++) {
                    int ele = scan.nextInt();
                    if (j == k) trace += ele;
                    if (rowEle.containsKey(ele) && flagR) {
                        nR += 1;
                        flagR = false;
                    }
                    else rowEle.put(ele, true);
                    if(colEle[k].containsKey(ele) && flagC[k]) {
                        nC += 1;
                        flagC[k] = false;
                    }
                    else colEle[k].put(ele, true);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + ' ' + nR + ' ' + nC);
        }
    }
}