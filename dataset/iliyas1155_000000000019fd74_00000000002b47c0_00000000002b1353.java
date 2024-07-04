import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // javac Solution.java
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for(int testCase=1; testCase<=cases; testCase++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + testCase + ": ");
            process(n);
        }
    }

    static void process(int n) {
        int i=1;
        int sum = 0;
        int val = 1;
        while(sum+val <= n) {
            if(i<=2) {
                System.out.println(i + " " + 1);
            } else {
                System.out.println(i + " " + 2);
            }
            sum += val;
            if(i<=2) {
                val = 1;
            } else {
                val = val + 1;
            }
            i++;
        }
        while(sum < n) {
            System.out.println(i + " " + 1);
            sum += 1;
            i++;
        }
    }
}
