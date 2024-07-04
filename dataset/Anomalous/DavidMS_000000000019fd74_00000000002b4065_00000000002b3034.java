import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static String findMatchingString(String current, String newString) {
        if (current.isEmpty()) {
            return newString;
        }
        if (newString.isEmpty()) {
            return current;
        }
        if (current.contains(newString)) {
            return current;
        }
        if (newString.contains(current)) {
            return newString;
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            String leftPart = "", rightPart = "";
            
            for (int i = 0; i < n; i++) {
                String[] parts = reader.readLine().split("\\*");
                rightPart = findMatchingString(rightPart, parts[0]);
                leftPart = findMatchingString(leftPart, parts[1]);
            }
            
            String result = rightPart + leftPart;
            if (result.isEmpty()) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}