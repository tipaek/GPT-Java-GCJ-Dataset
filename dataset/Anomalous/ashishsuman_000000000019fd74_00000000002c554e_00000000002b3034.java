import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for (int k = 1; k <= tc; k++) {
            String result = "";
            int patternCount = sc.nextInt();
            List<String> patterns = new ArrayList<>();
            
            sc.nextLine(); // Consume the newline character
            for (int i = 0; i <= patternCount; i++) {
                patterns.add(sc.nextLine());
            }
            
            String initialSegment = "";
            String finalSegment = "";
            
            for (String pattern : patterns) {
                if (pattern.length() > 0) {
                    if (pattern.charAt(2) != '*') {
                        if (initialSegment.isEmpty()) {
                            initialSegment = String.valueOf(pattern.charAt(2));
                        } else {
                            result = "*";
                            break;
                        }
                    }
                    
                    if (pattern.charAt(pattern.length() - 1) != '*') {
                        if (finalSegment.isEmpty()) {
                            finalSegment = String.valueOf(pattern.charAt(pattern.length() - 1));
                        } else {
                            result = "*";
                            break;
                        }
                    }
                }
            }
            
            if (result.isEmpty()) {
                if (initialSegment.isEmpty() && finalSegment.isEmpty()) {
                    for (String pattern : patterns) {
                        for (int h = 2; h < pattern.length(); h++) {
                            if (pattern.charAt(h) != '*') {
                                result += pattern.charAt(h);
                            }
                        }
                    }
                } else {
                    result += initialSegment;
                    for (String pattern : patterns) {
                        for (int h = 2; h < pattern.length(); h++) {
                            if (pattern.charAt(h) != '*') {
                                result += pattern.charAt(h);
                            }
                        }
                    }
                    result += finalSegment;
                }
                
                List<String> segment1 = new ArrayList<>();
                List<String> segment2 = new ArrayList<>();
                List<String> segment3 = new ArrayList<>();
                
                for (String pattern : patterns) {
                    if (pattern.length() > 0) {
                        List<String> components = new ArrayList<>();
                        StringBuilder component = new StringBuilder();
                        for (int l = 0; l < pattern.length(); l++) {
                            if (pattern.charAt(l) != '*') {
                                component.append(pattern.charAt(l));
                            } else {
                                components.add(component.toString());
                                component.setLength(0);
                            }
                        }
                        if (component.length() != 0) {
                            components.add(component.toString());
                        }
                        
                        if (components.size() == 1) {
                            segment1.add(components.get(0));
                        } else if (components.size() == 2) {
                            segment1.add(components.get(0));
                            segment2.add(components.get(1));
                        } else if (components.size() == 3) {
                            segment1.add(components.get(0));
                            segment2.add(components.get(1));
                            segment3.add(components.get(2));
                        }
                    }
                }
                
                result = validateAndCombineSegments(segment1, segment2, segment3, result);
            }
            
            System.out.println("Case #" + k + ": " + result);
        }
    }
    
    private static String validateAndCombineSegments(List<String> segment1, List<String> segment2, List<String> segment3, String result) {
        String longestSegment1 = findLongestSegment(segment1);
        String longestSegment2 = findLongestSegment(segment2);
        String longestSegment3 = findLongestSegment(segment3);
        
        if (!containsAllSegments(longestSegment1, segment1) || 
            !containsAllSegments(longestSegment2, segment2) || 
            !containsAllSegments(longestSegment3, segment3)) {
            return "*";
        }
        
        return longestSegment1 + longestSegment2 + longestSegment3;
    }
    
    private static String findLongestSegment(List<String> segments) {
        String longest = "";
        for (String segment : segments) {
            if (segment.length() > longest.length()) {
                longest = segment;
            }
        }
        return longest;
    }
    
    private static boolean containsAllSegments(String longest, List<String> segments) {
        for (String segment : segments) {
            if (!longest.contains(segment)) {
                return false;
            }
        }
        return true;
    }
}