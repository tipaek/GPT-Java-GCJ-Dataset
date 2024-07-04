import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        
        for (int test = 1; test <= testcase; test++) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            
            System.out.println("Case #" + test + ": " + processStrings(arr));
        }
    }
    
    public static String processStrings(String[] arr) {
        String left = "";
        String right = "";
        
        for (String str : arr) {
            if (left.equals("*") || right.equals("*")) {
                return "*";
            }
            
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '*') {
                    String rightPart = str.substring(j + 1);
                    String leftPart = str.substring(0, j);
                    
                    if (right.length() < rightPart.length()) {
                        if (rightPart.contains(right)) {
                            right = rightPart;
                        } else {
                            right = "*";
                            break;
                        }
                    } else if (!right.contains(rightPart)) {
                        right = "*";
                        break;
                    }
                    
                    if (left.length() < leftPart.length()) {
                        if (leftPart.contains(left)) {
                            left = leftPart;
                        } else {
                            left = "*";
                            break;
                        }
                    } else if (!left.contains(leftPart)) {
                        left = "*";
                        break;
                    }
                }
            }
        }
        
        return left + right;
    }
}