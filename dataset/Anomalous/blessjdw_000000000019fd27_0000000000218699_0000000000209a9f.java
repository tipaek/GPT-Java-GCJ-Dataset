import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            char[] inputWord = scanner.next().toCharArray();
            List<Character> result = new ArrayList<>();
            char previousChar = ' ';
            int openParensCount = 0;
            
            for (char currentChar : inputWord) {
                if (currentChar != previousChar) {
                    for (int j = 0; j < openParensCount; j++) {
                        result.add(')');
                    }
                    openParensCount = currentChar - '0';
                    for (int j = 0; j < openParensCount; j++) {
                        result.add('(');
                    }
                    previousChar = currentChar;
                }
                result.add(currentChar);
            }
            
            for (int j = 0; j < openParensCount; j++) {
                result.add(')');
            }
            
            StringBuilder output = new StringBuilder();
            for (char c : result) {
                output.append(c);
            }
            System.out.println("Case #" + t + ": " + output.toString());
        }
    }
}