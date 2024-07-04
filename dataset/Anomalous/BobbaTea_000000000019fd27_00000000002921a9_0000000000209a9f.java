import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int i = 0; i < testCaseCount; i++) {
            String inputString = scanner.next();
            String spacedString = inputString.replaceAll("(?<=\\d)(?=\\d)", " ");
            String[] stringArray = spacedString.split(" ");
            int[] digitArray = parseStringArrayToIntArray(stringArray);
            List<Integer> digitList = Arrays.stream(digitArray).boxed().collect(Collectors.toList());
            
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int j = 0; j <= digitList.size(); j++) {
                if (j == digitList.size()) {
                    result.append(")".repeat(currentDepth));
                    break;
                }
                
                int digit = digitList.get(j);
                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                }
                
                currentDepth = digit;
                result.append(digit);
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int[] parseStringArrayToIntArray(String[] array) {
        return Stream.of(array).mapToInt(Integer::parseInt).toArray();
    }
}