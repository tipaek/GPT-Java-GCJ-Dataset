import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            int N = sc.nextInt();
            String[] patterns = new String[N];
            String left = "";
            String right = "";
            boolean isValid = true;
            
            for (int i = 0; i < N; i++) {
                patterns[i] = sc.next();
                int starIndex = patterns[i].indexOf('*');
                
                String leftPart = patterns[i].substring(0, starIndex);
                String rightPart = patterns[i].substring(starIndex + 1);
                
                if (isValid) {
                    int minLeftLen = Math.min(leftPart.length(), left.length());
                    if (leftPart.substring(0, minLeftLen).equals(left.substring(0, minLeftLen))) {
                        if (leftPart.length() > left.length()) {
                            left = leftPart;
                        }
                    } else {
                        isValid = false;
                    }
                }
                
                if (isValid) {
                    int minRightLen = Math.min(rightPart.length(), right.length());
                    if (rightPart.substring(rightPart.length() - minRightLen).equals(right.substring(right.length() - minRightLen))) {
                        if (rightPart.length() > right.length()) {
                            right = rightPart;
                        }
                    } else {
                        isValid = false;
                    }
                }
            }
            
            if (isValid) {
                System.out.println(left + right);
            } else {
                System.out.println("*");
            }
        }
        
        sc.close();
    }
}