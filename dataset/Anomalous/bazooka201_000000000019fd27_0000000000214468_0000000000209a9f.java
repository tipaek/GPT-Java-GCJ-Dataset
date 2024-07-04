import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            List<String> segments = new ArrayList<>();
            
            StringBuilder currentSegment = new StringBuilder();
            currentSegment.append(input.charAt(0));
            
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt(i - 1)) {
                    currentSegment.append(input.charAt(i));
                } else {
                    segments.add(currentSegment.toString());
                    currentSegment = new StringBuilder();
                    currentSegment.append(input.charAt(i));
                }
            }
            segments.add(currentSegment.toString());
            
            System.out.print("Case #" + t + ": ");
            for (String segment : segments) {
                int digit = Character.getNumericValue(segment.charAt(0));
                for (int j = 0; j < digit; j++) {
                    System.out.print("(");
                }
                System.out.print(segment);
                for (int j = 0; j < digit; j++) {
                    System.out.print(")");
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
}