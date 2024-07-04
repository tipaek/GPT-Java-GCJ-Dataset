
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Acesine on 4/3/20.
 */
public class Solution {
    Scanner in = new Scanner(System.in);

    void perm(int n, int[] arr, List<int[]> ret) {
        if (n >= arr.length) {
            ret.add(Arrays.copyOf(arr, arr.length));
            return;
        }

        for (int i=n;i<arr.length;i++) {
            int t = arr[i];
            arr[i] = arr[n];
            arr[n] = t;
            perm(n+1, arr, ret);
            t = arr[i];
            arr[i] = arr[n];
            arr[n] = t;
        }
    }

    void brute() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            int n = in.nextInt(), k = in.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++) arr[i] = i+1;
            List<int[]> firstLines = new ArrayList<>();
            perm(0, arr, firstLines);
            boolean found = false;
            for (int[] first : firstLines) {
                int[] move = new int[n-1];
                for (int i=1;i<n;i++) move[i-1] = i;
                List<int[]> moves = new ArrayList<>();
                perm(0, move, moves);
                for (int[] m : moves) {
                    int sum = first[0];
                    for (int i=0;i<m.length;i++) {
                        sum += first[(i+1+n-m[i])%n];
                    }
                    if (sum == k) {
                        found = true;
                        System.out.println(String.format("Case #%d: POSSIBLE", t));
                        for (int x : first) System.out.print(x + " ");
                        System.out.println();
                        for (int mv : m) {
                            for (int d=0;d<n;d++) {
                                System.out.print(first[(-mv+n+d)%n] + " ");
                            }
                            System.out.println();
                        }
                        break;
                    }
                }
                if (found) break;
            }
            if (!found) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            }
        }
    }

    public static void main(String[] args) {
        new Solution().brute();
    }
}
