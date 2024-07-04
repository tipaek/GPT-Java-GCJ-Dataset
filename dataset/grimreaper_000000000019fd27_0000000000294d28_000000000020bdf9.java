import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.printf("\nCase #%d: ", i+1);
            int n = in.nextInt();
            int[] pre = new int[1441];
            int[] whichStart = new int[1441];
            int[] whichEnd = new int[1441];
            char[] ret = new char[n];
            boolean[] newTask = new boolean[1441];
            for (int j = 0; j < n; j++) {
                int k = in.nextInt();
                whichStart[k] = j+1;
                pre[k]++;
                newTask[k] = true;
                int l = in.nextInt();
                whichEnd[l] = j+1;
                pre[l]--;
            }

            int total = 0;
            boolean cLast = false;
            boolean possible = true;
            for (int j = 0; j < 1441; j++) {
                total += pre[j];
                if (total > 2) {
                    possible = false;
                    break;
                }

                if (pre[j] == -1) {
                    cLast = ret[whichEnd[j]-1] == 'C';
                } else if (newTask[j]) {
                    if (cLast)
                        ret[whichStart[j]-1] = 'J';
                    else
                        ret[whichStart[j]-1] = 'C';
                    cLast = !cLast;
                }
            }

            if (possible)
                System.out.print(ret);
            else
                System.out.print("IMPOSSIBLE");
        }
    }
}