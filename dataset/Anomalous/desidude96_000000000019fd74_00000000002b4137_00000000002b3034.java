import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfStrings = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            
            for (int stringIndex = 0; stringIndex < numberOfStrings; stringIndex++) {
                patterns.add(scanner.next());
            }
            
            String result = constructString(patterns);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static String constructString(List<String> patterns) {
        String result = patterns.get(0).substring(1);
        
        for (int i = 1; i < patterns.size(); i++) {
            String currentPattern = patterns.get(i).substring(1);
            
            if (currentPattern.contains(result)) {
                result = currentPattern;
            } else if (!result.contains(currentPattern)) {
                result = "*";
                break;
            }
        }
        
        return result;
    }
}