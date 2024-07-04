import java.util.*;
class Solution{
    public static void main(String[]args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t=1; t<=T; t++) {
            int n = s.nextInt();
            int[][]a=new int[n][n];
            int rc=0,cc=0,trace=0;
            for(int i=0;i<n;i++) {
                HashSet<Integer>set = new HashSet<>();
                for(int j=0;j<n;j++) {
                    a[i][j]=s.nextInt();
                    set.add(a[i][j]);
                    if(i==j) trace+=a[i][j];
                }
                rc += set.size()<n ? 1:0;
            }
            for(int i=0;i<n;i++) {
                HashSet<Integer>set = new HashSet<>();
                for(int j=0;j<n;j++) {
                    set.add(a[j][i]);
                }
                cc += set.size()<n ? 1 : 0;
            }
            System.out.println("Case #" + t + ": " + trace + " " + rc + " " + cc);
        }
    }
}
           