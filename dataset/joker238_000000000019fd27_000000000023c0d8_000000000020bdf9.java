import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int test = 1; test <= t; ++test) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for(int i=0;i<n;i++) {
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
            }
            boolean f=false;
            ArrayList<Character> ans = new ArrayList<>();
            for(int i=0;i<1<<n;i++) {
                ArrayList<Character> l = new ArrayList<>();
                for(int j=0;j<n;j++) {
                    if((i>>j&1)==1) {
                        l.add('C');
                    }
                    else {
                        l.add('J');
                    }
                }
                boolean f1=true,f2=true;
                for(int j=0;j<n;j++) {
                    for(int k=0;k<n;k++) {
                        if(j==k) continue;
                        if(l.get(j)=='J' && l.get(k)=='J') {
                            if (a[j][0] >= a[k][1] || a[j][1] <= a[k][0]) {
                                continue;
                            }
                            else {
                                f1=false;
                            }
                        }
                    }
                }
                for(int j=0;j<n;j++) {
                    for(int k=0;k<n;k++) {
                        if(j==k) continue;
                        if(l.get(j)=='C' && l.get(k)=='C') {
                            if (a[j][0] >= a[k][1] || a[j][1] <= a[k][0]) {
                                continue;
                            }
                            else {
                                f2=false;
                            }
                        }
                    }
                }
                if(f1&&f2) {
                    f=true;
                    for(int j=0;j<n;j++) {
                        ans.add(l.get(j));
                    }
                    break;
                }
            }

            System.out.print("Case #" + test + ": ");
            if(f) {
                for(char it:ans)
                    System.out.print(it);
            }
            else {
                System.out.print("IMPOSSIBLE");
            }

            System.out.println();
        }
    }
}
