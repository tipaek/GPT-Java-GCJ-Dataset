import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            input.nextLine();
            
            List<Character> beginning = new ArrayList<>();
            List<Character> end = new ArrayList<>();
            List<Character> any = new ArrayList<>();
            boolean works = true;
            
            for (int k = 0; k < n; k++) {
                String temp = input.nextLine();
                int starCount = (int) temp.chars().filter(ch -> ch == '*').count();
                
                if (temp.charAt(0) != '*') {
                    StringBuilder begintest = new StringBuilder();
                    for (char ch : temp.toCharArray()) {
                        if (ch == '*') break;
                        begintest.append(ch);
                    }
                    
                    if (!isPrefixMatching(beginning, begintest.toString())) {
                        works = false;
                        System.out.println("Case #" + (i + 1) + ": *");
                        break;
                    }
                    
                    if (begintest.length() > beginning.size()) {
                        beginning.clear();
                        for (char ch : begintest.toString().toCharArray()) {
                            beginning.add(ch);
                        }
                    }
                }
                
                if (temp.charAt(temp.length() - 1) != '*') {
                    String endtest = extractSuffix(temp);
                    
                    if (!isSuffixMatching(end, endtest)) {
                        works = false;
                        System.out.println("Case #" + (i + 1) + ": *");
                        break;
                    }
                    
                    if (endtest.length() > end.size()) {
                        end.clear();
                        for (char ch : endtest.toCharArray()) {
                            end.add(ch);
                        }
                    }
                }
                
                if (starCount >= 2) {
                    int firstStarPos = temp.indexOf('*');
                    int lastStarPos = temp.lastIndexOf('*');
                    for (int h = firstStarPos + 1; h < lastStarPos; h++) {
                        if (temp.charAt(h) != '*') {
                            any.add(temp.charAt(h));
                        }
                    }
                }
            }
            
            if (works) {
                StringBuilder result = new StringBuilder();
                beginning.forEach(result::append);
                any.forEach(result::append);
                end.forEach(result::append);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
    
    private static boolean isPrefixMatching(List<Character> beginning, String begintest) {
        for (int i = 0; i < beginning.size() && i < begintest.length(); i++) {
            if (beginning.get(i) != begintest.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSuffixMatching(List<Character> end, String endtest) {
        for (int i = 0; i < end.size() && i < endtest.length(); i++) {
            if (end.get(end.size() - 1 - i) != endtest.charAt(endtest.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
    private static String extractSuffix(String temp) {
        StringBuilder endtest = new StringBuilder();
        for (int h = temp.length() - 1; h >= 0; h--) {
            if (temp.charAt(h) == '*') break;
            endtest.insert(0, temp.charAt(h));
        }
        return endtest.toString();
    }
}