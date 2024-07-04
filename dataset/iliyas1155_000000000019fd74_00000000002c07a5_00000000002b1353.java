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
        int i=1, j=1;
        while(n >= Math.round(Math.pow(2, i)) + i) {
            System.out.println(i + " " + 1);
            i++;
        }
        n -= (Math.round(Math.pow(2, i-1)) + (i-1));
        for(j=1; j<=i; j++){
            System.out.println(i + " " + j);
        }
        while(n>0) {
            i++;
            System.out.println(i + " " + i);
            n--;
        }
    }
}
