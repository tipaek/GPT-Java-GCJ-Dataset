import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            StringBuilder ans = new StringBuilder();
            
            // Initial position
            ans.append("1 1\n");
            
            if (n == 1) {
                System.out.print("Case #" + test + ": \n" + ans);
                continue;
            }
            
            // Second position
            ans.append("2 1\n");
            int sum = 2;
            int row = 3;
            
            if (sum < n) {
                // Third position
                ans.append("3 2\n");
                sum += 2;
                
                // Additional positions
                while (sum < n) {
                    ans.append(row).append(" 1\n");
                    row++;
                    sum++;
                }
            }
            
            System.out.print("Case #" + test + ": \n" + ans);
        }
    }
}