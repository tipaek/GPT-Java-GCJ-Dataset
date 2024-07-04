import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        for(int tim=1;tim<=t;tim++) {
            int n = ob.nextInt();
            int[][] time = new int[n][3];
            char c[] = new char[n];
            Arrays.fill(c, 'C');
            for(int i=0;i<n;i++) {
                time[i][0]=ob.nextInt();
                time[i][1]=ob.nextInt();
                time[i][2]=i;
            }
            Arrays.sort(time, (a,b) -> Integer.compare(a[0], b[0]));
            //for(int i=0;i<n;i++) {
            //    System.out.println(time[i][0]+" "+time[i][1]+" "+time[i][2]);
            //}
            int cs=time[0][0], ce=time[0][1];
            int js=-1, je=-1;
            int flag=0;
            for(int i=1;i<n;i++) {
                if(time[i][0]>=ce) {
                    cs=time[i][0];
                    ce=time[i][1];
                    c[time[i][2]]='C';
                } else if(time[i][0]>=je) {
                    js=time[i][0];
                    je=time[i][1];
                    c[time[i][2]]='J';
                } else {
                    System.out.println("Case #"+tim+": IMPOSSIBLE");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.println("Case #"+tim+": "+String.valueOf(c));
        }
    }
}