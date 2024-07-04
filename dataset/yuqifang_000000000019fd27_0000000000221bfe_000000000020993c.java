import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int casenum=1; casenum<=t; casenum++){
        int n = in.nextInt();
        int[][] m = new int[n][n];
        int k=0,r=0, c=0;
        for (int i = 0; i < n; ++i) {
            for(int j = 0; j<n ; j++) {
                m[i][j] = in.nextInt();
                if(i==j) k+=m[i][j];
            }
        }
        for(int j=0; j<n; j++) {
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<n;i++){
                if(!set.add(m[i][j] )) {
                    c++;
                    break;
                }
            }
        }
        for(int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<n;j++){
                if(!set.add(m[i][j] )) {
                    r++;
                    break;
                }
            }
        }

            System.out.println("Case #" + casenum + ": " + k + " " + r + " " + c);
        }
        }
    }