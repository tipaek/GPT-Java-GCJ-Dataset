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
            boolean flag=false;
            boolean f2 = false;
            ArrayList<Character> dpc[] = new ArrayList[n];
            ArrayList<Character> dpj[] = new ArrayList[n];
            dpc[0]=new ArrayList<>();
            dpj[0]=new ArrayList<>();
            dpc[0].add('C');
            dpj[0].add('J');
            if(a[1][0]>=a[0][1]||a[1][1]<=a[0][0]) {
                if (dpc[0].get(0) == 'C') {
                    flag = true;
                }
            }
            dpc[1] = new ArrayList<>(dpc[0]);
            if(flag) {
                dpc[1].add('C');
            }
            else
                dpc[1].add('J');
            flag=true;
            if(a[1][0]>=a[0][1]||a[1][1]<=a[0][0]) {
                if (dpj[0].get(0) == 'J') {
                    flag = true;
                }
            }
            dpj[1] = new ArrayList<>(dpj[0]);
            if(flag) {
                dpj[1].add('J');
            }
            else
                dpj[1].add('C');


            for(int i=2;i<n;i++) {
                flag=false;
                f2 = false;
                for(int j=0;j<dpc[i-1].size();j++) {
                    if(a[i][0]>=a[j][1]||a[i][1]<=a[j][0]) {
                        if(dpc[i-1].get(j)=='C') {
                            flag=true;
                            break;
                        }
                        else {
                            f2=true;
                        }
                    }
                }
                dpc[i] = new ArrayList<>(dpc[i-1]);
                if(flag) {
                    dpc[i].add('C');
                }
                if(f2) {
                    dpc[i].add('J');
                }
                flag=false;
                f2 = false;
                for(int j=0;j<dpj[i-1].size();j++) {
                    if(a[i][0]>=a[j][1]||a[i][1]<=a[j][0]) {
                        if(dpj[i-1].get(j)=='J') {
                            flag=true;
                            break;
                        }
                        else
                            f2=true;
                    }
                }
                dpj[i] = new ArrayList<>(dpj[i-1]);
                if(flag) {
                    dpj[i].add('J');
                }
                if(f2) {
                    dpj[i].add('C');
                }

                if(dpj[i].size()>dpc[i].size()) {
                    for(int j=0;j<i+1;j++) {
                        dpc[i].add(j,dpj[i].get(j));
                    }
                }
                else if(dpj[i].size()<dpc[i].size()) {
                    for(int j=0;j<i+1;j++) {
                        dpj[i].add(j,dpc[i].get(j));
                    }
                }

            }
            System.out.print("Case #" + test + ": ");
            if (dpc[n-1].size()==n) {
                for (char it : dpc[n - 1]) {
                    System.out.print(it);
                }
            }
            else System.out.print("IMPOSSIBLE");
            System.out.println();
        }
    }
}