import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine().trim());
        
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(input.readLine().trim());
            boolean[] didVisit = new boolean[32];
            boolean onLeft = true;
            didVisit[0] = true;
            int maxBit = 0;

            for (int j = 30; j >= 0; j--) {
                if (n > ((1 << j) + j)) {
                    maxBit = j;
                    n -= ((1 << j) + j);
                    didVisit[j] = true;
                    break;
                }
            }

            for (int j = maxBit; j >= 0; j--) {
                if (n > (1 << j) - 1) {
                    n -= (1 << j) - 1;
                    didVisit[j] = true;
                }
            }

            System.out.println("1 1");
            for (int j = 1; j <= maxBit; j++) {
                System.out.println((j + 1) + " " + (onLeft ? 1 : (j + 1)));
                if (didVisit[j]) {
                    if (onLeft) {
                        for (int k = 2; k <= j + 1; k++) {
                            System.out.println((j + 1) + " " + k);
                        }
                    } else {
                        for (int k = j; k > 0; k--) {
                            System.out.println((j + 1) + " " + k);
                        }
                    }
                    onLeft = !onLeft;
                }
            }

            for (int j = 0; j < n; j++) {
                maxBit++;
                System.out.println((maxBit + 1) + " " + (onLeft ? 1 : (maxBit + 1)));
            }
        }
    }
}