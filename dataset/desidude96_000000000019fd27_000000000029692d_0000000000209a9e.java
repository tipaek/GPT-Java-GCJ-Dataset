import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while (true) { 
            int numCases = in.nextInt();
            int[] B = new int[in.nextInt()];
            for (int i = 0; i < numCases; i++) {
                buildArray(B, in);
                String res = "";
                for (int j = 0; j < B.length; j++) res += B[i];
                System.out.println(res);
                if (in.next().equals("N")) break;
            }  
        }
    }

    private static void buildArray(int[] B, Scanner in) {
        for (int i = 1; i <= B.length; i++) {
            System.out.println(i);
            B[i-1] = in.nextInt();
        }
    }
}