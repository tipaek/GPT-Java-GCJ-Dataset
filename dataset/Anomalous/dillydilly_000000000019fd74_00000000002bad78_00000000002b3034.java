import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for (int i = 1; i <= cases; i++) {
            String result = processInput(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processInput(Scanner input) {
        String error = "";
        List<String> segments = new ArrayList<>();
        int patternCount = input.nextInt();
        
        for (int i = 0; i < patternCount; i++) {
            String pattern = input.next();
            int asteriskIndex = pattern.indexOf("*");
            segments.add("");
            int segmentIndex = 0;
            
            while (asteriskIndex != -1) {
                String currentSegment = pattern.substring(0, asteriskIndex);
                
                while (segments.size() <= segmentIndex + 2) {
                    segments.add("");
                }
                
                if (asteriskIndex == 0) {
                    segmentIndex++;
                    pattern = pattern.substring(1);
                    asteriskIndex = pattern.indexOf("*");
                } else {
                    String existingSegment = segments.get(segmentIndex);
                    
                    if (existingSegment.isEmpty()) {
                        segments.set(segmentIndex, currentSegment);
                    } else {
                        if (!currentSegment.contains(existingSegment) && !existingSegment.contains(currentSegment)) {
                            error = "*";
                        }
                        if (currentSegment.length() > existingSegment.length()) {
                            segments.set(segmentIndex, currentSegment);
                        }
                    }
                    
                    pattern = pattern.substring(asteriskIndex + 1);
                    asteriskIndex = pattern.indexOf("*");
                    segmentIndex += 2;
                }
            }
            
            String lastSegment = segments.get(segmentIndex);
            if (!pattern.contains(lastSegment) && !lastSegment.contains(pattern)) {
                error = "*";
            }
            if (pattern.length() > lastSegment.length()) {
                segments.set(segmentIndex, pattern);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            result.append(segment);
        }
        
        return error.isEmpty() ? result.toString() : error;
    }
}