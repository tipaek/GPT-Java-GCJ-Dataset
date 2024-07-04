import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for (int tt = 1; tt <= T; tt++) {
            int N = in.nextInt();
            String prefix = "";
            String suffix = "";
            ArrayList<String> middleParts = new ArrayList<>();
            boolean isValid = true;
            String result = "";
            
            for (int x = 0; x < N; x++) {
                String pattern = in.next();
                int firstStarIndex = pattern.indexOf("*");
                int lastStarIndex = pattern.lastIndexOf("*");
                
                String temp = "";
                boolean isMiddle = false;
                
                for (int y = 0; y <= lastStarIndex; y++) {
                    String currentChar = pattern.substring(y, y + 1);
                    if (currentChar.equals("*")) {
                        if (!temp.isEmpty()) {
                            middleParts.add(temp);
                        }
                        temp = "";
                        isMiddle = true;
                    } else {
                        if (isMiddle) {
                            temp += currentChar;
                        } else {
                            if (prefix.length() < y + 1) {
                                prefix += currentChar;
                            } else if (!prefix.substring(y, y + 1).equals(currentChar)) {
                                result = "*";
                                isValid = false;
                                break;
                            }
                        }
                    }
                }
                
                for (int y = pattern.length() - 1; y >= lastStarIndex; y--) {
                    String currentChar = pattern.substring(y, y + 1);
                    if (currentChar.equals("*")) {
                        break;
                    } else {
                        if (suffix.length() < pattern.length() - y) {
                            suffix = currentChar + suffix;
                        } else if (!suffix.substring(suffix.length() - (pattern.length() - y), suffix.length() - (pattern.length() - y) + 1).equals(currentChar)) {
                            result = "*";
                            isValid = false;
                            break;
                        }
                    }
                }
            }
            
            if (isValid) {
                result = prefix;
                for (String part : middleParts) {
                    result += part;
                }
                result += suffix;
            }
            
            System.out.println("Case #" + tt + ": " + result);
        }
    }
}