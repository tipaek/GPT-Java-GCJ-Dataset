import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        @SuppressWarnings("resource") 
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = in.nextInt();
            int desiredTrace = in.nextInt();
            int val = 0;
            String str="IMPOSSIBLE";
            for (int i = 1; i <= matrixSize; i++) {
                if (i * matrixSize % desiredTrace == 0 && i * matrixSize / desiredTrace == 1) {
                    str = "POSSIBLE";
                }
                if (i % 2 == 1) {
                    val += i;
                }
                if (i == matrixSize) {
                    if (val % desiredTrace == 0 && val / desiredTrace == 1) {
                        str = "POSSIBLE";
                    }
                }
            }
            System.out.println("Case #" + t + ": " + str);
        }
    }    
    
}