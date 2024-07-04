/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {

        // Write code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int ii = 1; ii <= t; ++ii) {
            int ans = 0, row = 0, col = 0;
            int n = Integer.parseInt(br.readLine());
            int data[][] = new int[n][n];
            for (int i = 0; i < n; ++i) {
                StringTokenizer token = new StringTokenizer(br.readLine());
         
                for (int j = 0; j < n; ++j) {
                    data[i][j] = Integer.parseInt(token.nextToken());
                    if(i==j)ans+=data[i][j];
                }
            }
            for (int i = 0; i < n; ++i) {
                HashSet<Integer> hs = new HashSet();
                HashSet<Integer> hc = new HashSet();
                for (int j = 0; j < n; ++j) {
                    hs.add(data[i][j]);
                    hc.add(data[j][i]);
                }
                if(hs.size() != n) ++row;
                if(hc.size() != n) ++col;
            }
            System.out.print("Case #"+ii+": "+ans+" "+row+" "+col+"\n");
        }

    }
}
