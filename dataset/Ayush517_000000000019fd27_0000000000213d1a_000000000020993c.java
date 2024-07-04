import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        for(int tim=1;tim<=t;tim++) {
            int n = ob.nextInt();
            int[][] a= new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++) {
                    a[i][j]=ob.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                }
            int r=0, c=0;
            HashSet<Integer> hs;
            for(int i=0;i<n;i++) {
                hs = new HashSet<Integer>();
                for(int j=0;j<n;j++)
                    hs.add(a[i][j]);
                if(hs.size()!=n)
                    r++;
            }
            for(int i=0;i<n;i++) {
                hs = new HashSet<Integer>();
                for(int j=0;j<n;j++)
                    hs.add(a[j][i]);
                if(hs.size()!=n)
                    c++;
            }
            System.out.println("Case #"+tim+": "+trace+" "+r+" "+c);
        }
    }
}