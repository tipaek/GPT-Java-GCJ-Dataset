import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = 10000;

        for (int x = 1; x <= T; x++) {
            int U = sc.nextInt();
            String[] R = new String[N];
            int[] frequency = new int[10];
            char[] characters = new char[10];
            boolean[] isZero = new boolean[10];
            Arrays.fill(isZero, true);
            int uniqueCharCount = 0;

            for (int i = 0; i < N; i++) {
                sc.next();  // Skip the first input
                R[i] = sc.next();
                for (int m = 0; m < R[i].length(); m++) {
                    char currentChar = R[i].charAt(m);
                    boolean found = false;

                    for (int j = 0; j < uniqueCharCount; j++) {
                        if (currentChar == characters[j]) {
                            if (m == 0) {
                                frequency[j]++;
                                isZero[j] = false;
                            }
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        characters[uniqueCharCount] = currentChar;
                        if (m == 0) {
                            frequency[uniqueCharCount]++;
                            isZero[uniqueCharCount] = false;
                        }
                        uniqueCharCount++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                if (isZero[i]) {
                    result.append(characters[i]);
                    frequency[i] = -1;
                }
            }

            for (int i = 1; i < 10; i++) {
                int maxFrequency = -1;
                int index = -1;
                for (int j = 0; j < 10; j++) {
                    if (frequency[j] > maxFrequency) {
                        maxFrequency = frequency[j];
                        index = j;
                    }
                }
                if (index != -1) {
                    result.append(characters[index]);
                    frequency[index] = -1;
                }
            }

            System.out.println("Case #" + x + ": " + result.toString());
        }
        sc.close();
    }
}