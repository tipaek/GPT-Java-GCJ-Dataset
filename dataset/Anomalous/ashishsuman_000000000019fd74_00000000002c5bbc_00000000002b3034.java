import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            String result = "";
            int patternCount = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            List<String> patterns = new ArrayList<>();
            
            for (int i = 0; i < patternCount; i++) {
                patterns.add(sc.nextLine());
            }
            
            String startPattern = "";
            String endPattern = "";
            
            for (String pattern : patterns) {
                if (pattern.length() > 0) {
                    if (pattern.charAt(2) != '*') {
                        if (startPattern.isEmpty()) {
                            startPattern = String.valueOf(pattern.charAt(2));
                        } else {
                            result = "*";
                            break;
                        }
                    }

                    if (pattern.charAt(pattern.length() - 1) != '*') {
                        if (endPattern.isEmpty()) {
                            endPattern = String.valueOf(pattern.charAt(pattern.length() - 1));
                        } else {
                            result = "*";
                            break;
                        }
                    }
                }
            }

            if (result.isEmpty()) {
                if (startPattern.isEmpty() && endPattern.isEmpty()) {
                    for (String pattern : patterns) {
                        for (int j = 2; j < pattern.length(); j++) {
                            if (pattern.charAt(j) != '*') {
                                result += pattern.charAt(j);
                            }
                        }
                    }
                } else {
                    result += startPattern;
                    for (String pattern : patterns) {
                        for (int j = 2; j < pattern.length(); j++) {
                            if (pattern.charAt(j) != '*') {
                                result += pattern.charAt(j);
                            }
                        }
                    }
                    result += endPattern;
                }

                List<String> part1 = new ArrayList<>();
                List<String> part2 = new ArrayList<>();
                List<String> part3 = new ArrayList<>();
                
                for (String pattern : patterns) {
                    if (pattern.length() > 0) {
                        List<String> components = new ArrayList<>();
                        StringBuilder component = new StringBuilder();
                        
                        for (int j = 0; j < pattern.length(); j++) {
                            if (pattern.charAt(j) != '*') {
                                component.append(pattern.charAt(j));
                            } else {
                                components.add(component.toString());
                                component.setLength(0);
                            }
                        }
                        
                        if (component.length() > 0) {
                            components.add(component.toString());
                        }

                        if (components.size() == 1) {
                            part1.add(components.get(0));
                        } else if (components.size() == 2) {
                            part1.add(components.get(0));
                            part2.add(components.get(1));
                        } else if (components.size() == 3) {
                            part1.add(components.get(0));
                            part2.add(components.get(1));
                            part3.add(components.get(2));
                        }
                    }
                }

                String longestPart1 = findLongest(part1);
                String longestPart2 = findLongest(part2);
                String longestPart3 = findLongest(part3);

                if (!isContainedInAll(longestPart1, part1) || 
                    (part2.size() > 0 && !isContainedInAll(longestPart2, part2)) || 
                    (part3.size() > 0 && !isContainedInAll(longestPart3, part3))) {
                    result = "*";
                } else if (result.isEmpty()) {
                    result = longestPart1 + longestPart2 + longestPart3;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String findLongest(List<String> parts) {
        String longest = "";
        for (String part : parts) {
            if (part.length() > longest.length()) {
                longest = part;
            }
        }
        return longest;
    }

    private static boolean isContainedInAll(String longestPart, List<String> parts) {
        for (String part : parts) {
            if (!longestPart.contains(part)) {
                return false;
            }
        }
        return true;
    }
}