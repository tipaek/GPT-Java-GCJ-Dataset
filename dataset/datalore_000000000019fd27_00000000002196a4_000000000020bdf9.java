import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

    private static int T;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i=0; i<T; i++) {
            int N = sc.nextInt();
            int arr[][] = new int[N][3];

            for (int j=0; j<N; j++) {
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
                arr[j][2] = j;
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(final int[] entry1, final int[] entry2) {
                    if (entry1[0] > entry2[0])
                        return 1;
                    else
                        return -1;
                }
            });

            String assign[] = new String[N];

            int cMax = arr[0][1];
            assign[arr[0][2]] = "C";
            for (int j=1; j<N; j++) {
                if (arr[j][0] >= cMax) {
                    assign[arr[j][2]] = "C";
                    cMax = arr[j][1];
                }
                else
                    assign[arr[j][2]] = "J";
            }

            int jMax = 0;
            for (int j=1; j<N; j++) {
                if (assign[arr[j][2]].equals("J"))
                    if (arr[j][0] < jMax) {
                        assign[0] = "IMPOSSIBLE";
                        break;
                    }
                    else
                        jMax = arr[j][1];
            }

            String str = "";
            for (int j=0; j<N; j++) {
                if (j==0 && assign[0].equals("IMPOSSIBLE")) {
                    str = assign[0];
                    break;
                }
                else
                    str += assign[j];
            }

            System.out.println("Case #" + (i+1) + ": " + str);
        }
    }
}
