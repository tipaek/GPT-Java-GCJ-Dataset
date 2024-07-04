import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[])throws Exception {
        InputStreamReader ab = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ab);

        int t = Integer.parseInt(in.readLine().trim());

        for(int tc =1;tc<=t;tc++) {
            int n = Integer.parseInt(in.readLine().trim());
            int arr[][] = new int[n][n];

            HashSet<Integer> rows[] = new HashSet[n];
            HashSet<Integer> cols[] = new HashSet[n];

            for(int i=0;i<n;i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
            }

            int rCount = 0;
            int cCount = 0;
            int trace = 0;
            for (int i=0;i<n;i++) {
                String s[] = in.readLine().trim().split(" ");
                for (int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(s[j].trim());
                    if (i==j) {
                        trace+=arr[i][j];
                    }
                }
            }

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if (rows[i].contains(arr[i][j])) {
                        rCount+=1;
                        break;
                    } else {
                        rows[i].add(arr[i][j]);
                    }
                }
            }

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if (cols[i].contains(arr[j][i])) {
                        cCount+=1;
                        break;
                    } else {
                        cols[i].add(arr[j][i]);
                    }
                }
            }

            System.out.println("Case #" + tc + ": " + trace + " " + rCount + " " +cCount );
        }
    }
}
