import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        //File f = new File("C:\\GoogleCodeJam\\Test.txt");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(f);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int a[][]=new int[n][n];
            int sum=0;
            for(int j=0;j<n;j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = in.nextInt();
                    if (j == k)
                        sum = sum + a[j][k];
                }
            }
            int r=0;
            boolean loopbreak=false;
            for(int j=0;j<n;j++) {
                loopbreak=true;
                for (int k = 0; k < n && loopbreak; k++) {
                    for(int l=k+1;l < n && loopbreak;l++) {
                        if (a[j][k] == a[j][l]) {
                            r++;
                            loopbreak=false;
                        }
                    }
                }
            }
            loopbreak=false;
            int c = 0;
            for(int j=0;j<n;j++) {
                loopbreak=true;
                for (int k = 0; k < n && loopbreak; k++) {
                    for(int l=k+1;l < n && loopbreak;l++) {
                        if (a[k][j] == a[l][j]) {
                            c++;
                            loopbreak=false;
                        }
                    }
                }
            }
            System.out.println("Case #" + i+": "+sum+" "+r+" "+c);
            }
        in.close();
        }
}
