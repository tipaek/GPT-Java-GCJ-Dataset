import java.util.*;


public class Solution {

    static String a;

    public static void main(String[] args) {
        int t1, n, m ,min,s,f,j;
        Scanner sc = new Scanner(System.in);
        t1 = sc.nextInt();
        for (int i = 0; i < t1; i++) {
            n=sc.nextInt();
            int[][] t = new int[n][4];
            for (int k = 0; k < n; k++) {
                t[k][0]=sc.nextInt();
                t[k][1]=sc.nextInt();
                t[k][2]=k;
            }
            Arrays.sort(t, (a, b) -> Integer.compare(a[0], b[0]));
            t[0][3]= 0;
            int ct=0,jt=0;
            ct = t[0][1];
            f=0;
            for (int k = 1; k < n; k++) {
                if(ct<=t[k][0])
                {
                    t[k][3]= 0;
                    ct=t[k][1];
                }
                else if(jt<=t[k][0])
                {
                    t[k][3]= 1;
                    jt=t[k][1];
                }
                else
                {
                    f=1;
                    break;
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            if(f==1)
                System.out.println("IMPOSSIBLE");
            else
            {
                Arrays.sort(t, (a, b) -> Integer.compare(a[2], b[2]));


            for (int k = 0; k < n; k++) {
                if(t[k][3]==0)
                    System.out.print("C");
                else
                    System.out.print("J");

            }
                System.out.println("");
        }
        }
    }

}