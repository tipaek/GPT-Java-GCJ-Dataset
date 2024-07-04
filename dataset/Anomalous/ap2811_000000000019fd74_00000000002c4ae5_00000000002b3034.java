import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class cj12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next().replace("*", "");
            }
            
            int maxLength = 0;
            int maxIndex = 0;
            
            for (int i = 0; i < n; i++) {
                if (patterns[i].length() >= maxLength) {
                    maxLength = patterns[i].length();
                    maxIndex = i;
                }
            }
            
            boolean isValid = true;
            
            for (int i = 0; i < n; i++) {
                if (i != maxIndex && !patterns[maxIndex].contains(patterns[i])) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + patterns[maxIndex]);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
    }
}