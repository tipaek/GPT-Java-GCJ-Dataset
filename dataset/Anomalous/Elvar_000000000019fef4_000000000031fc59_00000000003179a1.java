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
            char[] letters = new char[10];
            boolean[] canBeZero = new boolean[10];
            Arrays.fill(canBeZero, true);
            int uniqueLetters = 0;

            for (int i = 0; i < N; i++) {
                sc.next(); // Consume the Q value
                R[i] = sc.next();
                
                for (int m = 0; m < R[i].length(); m++) {
                    char currentChar = R[i].charAt(m);
                    boolean seenBefore = false;

                    for (int j = 0; j < uniqueLetters; j++) {
                        if (currentChar == letters[j]) {
                            frequency[j]++;
                            seenBefore = true;
                            if (m == 0) canBeZero[j] = false;
                        }
                    }

                    if (!seenBefore) {
                        letters[uniqueLetters] = currentChar;
                        frequency[uniqueLetters] = 1;
                        if (m == 0) canBeZero[uniqueLetters] = false;
                        uniqueLetters++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < uniqueLetters; i++) {
                if (canBeZero[i]) {
                    result.append(letters[i]);
                    frequency[i] = 0;
                }
            }

            for (int i = 0; i < 9; i++) {
                int maxFrequency = 0;
                int maxIndex = -1;

                for (int j = 0; j < uniqueLetters; j++) {
                    if (frequency[j] > maxFrequency) {
                        maxFrequency = frequency[j];
                        maxIndex = j;
                    }
                }

                if (maxIndex != -1) {
                    result.append(letters[maxIndex]);
                    frequency[maxIndex] = 0;
                }
            }

            System.out.println("Case #" + x + ": " + result.toString());
        }
    }
}