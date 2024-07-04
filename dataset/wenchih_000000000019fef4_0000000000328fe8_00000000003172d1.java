import java.util.*;

/**
 * Created by wenchihhsieh on 2017/4/15.
 */
public class Solution {
    static Map<Character, int[]> map;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for(int k = 1; k <= num; k++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            scanner.nextLine();
            long pieces[] = new long[n];
            for(int i = 0; i < n; i++) {
               pieces[i] = scanner.nextLong();
            }
            scanner.nextLine();
            System.out.println("Case #" + k + ": " + helper(pieces, n, d));
        }
    }

    private static String helper(long pieces[], int n, int d) {
        Arrays.sort(pieces);
        int minCut = d;
        for(int i = 0; i < n; i++) {
            long a = pieces[i];
            minCut = Math.min(minCut, cut(pieces, a, i+1, d - 1, n));
        }
        return String.valueOf(minCut);
    }

    private static int cut(long pieces[], long a, int j, int remain, int n) {
        long cut = 0;
        for(int i = j; i < n; i++) {
            if(pieces[i] % a == 0) {
                long p = pieces[i]/a;
                cut += Math.min(remain, p);

                if(p <= remain) {
                    cut--;
                }
                remain -= p;
                if(remain <= 0) {
                    break;
                }
            }
        }
        if(remain > 0) {
            return remain;
        }
        return cut;
    }


}
