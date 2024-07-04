import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
//    public static long MIN(long a,long b,long c)
//    {
//        if (a < b && a<c)
//            return a;
//        else if (b < a && b < c)
//            return b;
//        else
//            return c;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int l = 0;
        while (t-- > 0){
            l++;
            int n = sc.nextInt();
            int[][] a = new int[n][n];

            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++)
                    a[i][j] = sc.nextInt();
            }
            int k = 0;
            for (int i=0;i<n;i++){
                k += a[i][i];
            }
            int r = 0;
            for (int i=0;i<n;i++){
                Set<Integer> set = new HashSet<>();
                for (int j=0;j<n;j++){
                    if (set.size()!=0 && set.contains(a[i][j])){
                        r++;
                        break;
                    }
                    else
                        set.add(a[i][j]);
                }
            }
            int c = 0;
            for (int i=0;i<n;i++){
                Set<Integer> set = new HashSet<>();
                for (int j=0;j<n;j++){
                    if (set.size()!=0 && set.contains(a[j][i])) {
                        c++;
                        break;
                    }
                    else
                        set.add(a[j][i]);
                }
            }
            System.out.println("Case #" + l + ": " + k + " " + r + " " + c );
        }
    }
}
