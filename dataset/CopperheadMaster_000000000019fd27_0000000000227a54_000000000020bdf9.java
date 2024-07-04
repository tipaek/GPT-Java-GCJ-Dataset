
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int c = 1; c <= t; c++) {
            int aCount = in.nextInt();
            StringBuilder out = new StringBuilder();
            int [][] pairs = new int[aCount][4];
            for (int a = 0; a < aCount; a++) {
                int start = in.nextInt();
                int end = in.nextInt();
                pairs[a][0] = start;
                pairs[a][1] = end;
                pairs[a][2] = a;
            }
            java.util.Arrays.sort(pairs, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Double.compare(a[0], b[0]);
                }
            });
            int lastEndJ = 0;
            int lastEndC = 0;
            boolean isImpossible = false;
            for (int[] pair : pairs) {
                int start = pair[0];
                int end = pair[1];
                if (start >= lastEndC) {
                    lastEndC = end;
                    pair[3] = 0;
                } else if (start >= lastEndJ) {
                    lastEndJ = end;
                    pair[3] = 1;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            if (isImpossible){
                out.append("IMPOSSIBLE");
            }else{
                java.util.Arrays.sort(pairs, new java.util.Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return Double.compare(a[2], b[2]);
                    }
                });
                for (int[] pair : pairs) {
                    out.append(pair[3] == 0 ? 'C' : 'J');
                }
            }
            System.out.println("Case #" + c + ": " + (out));
        }
    }
}
