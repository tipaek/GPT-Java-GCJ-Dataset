package Practice;
import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        int t, n, r,cl,s,f;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            s=0;
            n = sc.nextInt();
            int[][] a = new int[n][n];
            r=0;
            for (int j = 0; j < n; j++) {
                f=0;
                int[] c = new int[n];
                for (int l = 0; l < n; l++) {
                    a[j][l] = sc.nextInt();
                    if(l==j)
                        s=s+a[j][l];
                    if(c[a[j][l] - 1]==1 && f==0)
                    {
                        r++;
                        f=1;
                    }
                    else
                        c[a[j][l] - 1]=1;
                }
            }
            cl=0;
            for (int l = 0; l < n; l++) {
                f=0;
                int[] c = new int[n];
                for (int j = 0; j < n; j++) {
                    if(c[a[j][l] - 1]==1 && f==0)
                    {
                        cl++;
                        f=1;
                    }
                    else
                        c[a[j][l] - 1]=1;
                }
            }
                System.out.println("Case #"+(i+1)+": "+s+" "+r+ " "+cl);
        }
    }
}