import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int test = 1; test <= t; ++test) {
            int n = sc.nextInt();
            int a[][] = new int[n][3];
            for(int i=0;i<n;i++) {
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
                a[i][2]=i;
            }
            Arrays.sort(a,(x,y)->(x[0]==y[0])?x[1]-y[1]:x[0]-y[0]);
            char[] l = new char[n];
            l[a[0][2]]='C';
            int oc[] = new int[n];
            oc[0]=1;
            int cntc=1,cntj=0;

            for(int i=1;i<n;i++) {
                boolean f=true;
                for(int j=0;j<i;j++) {
                    if(oc[j]==1) {
                        if (a[i][0] >= a[j][1]) {
                            continue;
                        } else {
                            f=false;
                        }
                    }
                }
                if(f) {
                    oc[i]=1;
                    l[a[i][2]]='C';
                    cntc++;
                }
            }

            for(int i=1;i<n;i++) {
                if(oc[i]==1) continue;
                boolean f=true;
                for(int j=0;j<i;j++) {
                    if(oc[j]==2) {
                        if (a[i][0] >= a[j][1]) {
                            continue;
                        } else {
                            f=false;
                        }
                    }
                }
                if(f) {
                    oc[i]=2;
                    l[a[i][2]]='J';
                    cntj++;
                }
            }

            System.out.print("Case #" + test + ": ");
            if(cntc+cntj==n) {
                for(char it:l)
                    System.out.print(it);
            }
            else {
                System.out.print("IMPOSSIBLE");
            }

            System.out.println();
        }
    }
}
