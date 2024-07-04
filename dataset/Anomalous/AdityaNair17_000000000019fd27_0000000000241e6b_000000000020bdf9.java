import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = input.nextInt();
        
        for (int t = 1; t <= testCaseCount; t++) {
            StringBuilder result = new StringBuilder();
            int[] J = {0, 0};
            int[] C = {0, 0};
            int N = input.nextInt();
            
            boolean possible = true;
            for (int n = 0; n < N; n++) {
                int start = input.nextInt();
                int end = input.nextInt();
                
                if (J[1] <= start || J[0] >= end) {
                    J[0] = start;
                    J[1] = end;
                    result.append("J");
                } else if (C[1] <= start || C[0] >= end) {
                    C[0] = start;
                    C[1] = end;
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
        
        input.close();
    }
}