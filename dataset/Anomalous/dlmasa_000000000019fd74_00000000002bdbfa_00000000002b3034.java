import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numStrings = scanner.nextInt();
            List<String> strings = new ArrayList<>();
            
            for (int i = 0; i < numStrings; i++) {
                strings.add(scanner.next());
            }
            
            int maxLength = strings.stream().mapToInt(String::length).max().orElse(0);
            char[] result = new char[maxLength];
            Arrays.fill(result, '*');
            boolean isImpossible = false;
            
            for (int i = 0; i < numStrings && !isImpossible; i++) {
                String currentString = strings.get(i);
                char[] currentChars = currentString.toCharArray();
                int lengthDifference = maxLength - currentChars.length;
                
                for (int j = 0; j < currentChars.length; j++) {
                    if (currentChars[j] == '*') continue;
                    
                    if (result[j + lengthDifference] == '*') {
                        result[j + lengthDifference] = currentChars[j];
                    } else if (currentChars[j] != result[j + lengthDifference]) {
                        isImpossible = true;
                        break;
                    }
                }
            }
            
            if (isImpossible) {
                System.out.printf("Case #%d: *\n", t);
            } else {
                System.out.printf("Case #%d: %s\n", t, new String(result).substring(1));
            }
        }
    }
}