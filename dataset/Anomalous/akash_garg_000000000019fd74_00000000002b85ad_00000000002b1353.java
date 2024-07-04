import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int q = 1; q <= testCases; q++) {
            System.out.println("Case #" + q + ":");
            int n = in.nextInt();
            int currSum = 1, val = 1;
            System.out.println(1 + " " + 1);
            int i = 2, j = 1;
            
            while (val + currSum <= n) {
                currSum += val;
                System.out.println(i + " " + j);
                j++;
                val++;
            }
            
            int left = n - currSum;
            i--;
            
            for (int x = 0; x < left; x++) {
                System.out.println(i + " " + (j + x));
            }
        }
        
        in.close();
    }
}