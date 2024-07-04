import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            StringBuilder sa = new StringBuilder();
            int openParenCount = 0, closeParenCount = 0;
            int previous = 0, current = 0;
            
            for (int j = 0; j < s.length(); j++) {
                current = s.charAt(j) - '0';
                
                if (j == 0) {
                    openParenCount = current;
                    closeParenCount = current;
                    sa.append("(".repeat(openParenCount)).append(current);
                    previous = current;
                } else {
                    if (current > previous) {
                        int diff = current - previous;
                        openParenCount += diff;
                        sa.append("(".repeat(diff)).append(current);
                    } else if (current < previous) {
                        int diff = previous - current;
                        closeParenCount -= diff;
                        sa.append(")".repeat(diff)).append(current);
                    } else {
                        sa.append(current);
                    }
                    previous = current;
                }
                
                if (j == s.length() - 1) {
                    sa.append(")".repeat(closeParenCount));
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + sa);
        }
        
        sc.close();
    }
}