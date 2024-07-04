import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;
class pair{
    int x;
    int y;
    public pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
class pair1{
    int x;
    char y;
    public pair1(int x, char y)
    {
        this.x = x;
        this.y = y;
    }
}

 class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n=s.nextInt();
pair ar[]=new  pair[n];

            for (int j = 0; j < n; j++) {

               int x=s.nextInt();
                int y=s.nextInt();
                ar[j]=new pair(x,y);

        }
           pair ar3[]= Arrays.copyOf(ar,n);
            Arrays.sort(ar,new Comparator<pair>(){
                @Override public int compare(pair p1, pair p2)
                {
                    return p1.x - p2.x;
                }
            });

            int a=0;
            int b=0;
            int c=0;
            int j1=0;
            int f=0;
             pair1 ans[]=new pair1[n];
            for(int j=0;j<n;j++){

                if(ar[j].x>=a) {
                    ans[j]=new pair1(ar[j].x,'C');
                    a=ar[j].y;
                    continue;
                }

                else if(ar[j].x>=b) {
                    ans[j]=new pair1(ar[j].x,'J');
                    b=ar[j].y;
continue;
                }
                else
                {
                    f=1;
                    break;
                }
            }
            String ans2="";

            if(f!=1) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (ar3[j].x == ans[k].x) {
                            ans2 = ans2 + ans[k].y;
                            ans[k].x = -1;
                            break;
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + ans2);
            }
            else
                System.out.println("Case #"+i+": IMPOSSIBLE");






        }
            }
    }






               


