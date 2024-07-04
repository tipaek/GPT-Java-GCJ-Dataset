import  java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int c = 1;
        while (t-- > 0) {
            
            String s = sc.nextLine();
            StringBuilder result = new StringBuilder();
            
            int last = 0;
            int close = 0;
            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                int open = last - digit;
                if (open <= 0) {
                    int numOpenBrace = Math.abs(open);
                    while (numOpenBrace-- > 0)
                        result.append('(');
                    result.append(digit);
                } else {
                    int numCloseBrace = Math.abs(open);
                    while (numCloseBrace-- >0)
                        result.append(')');
                        
                    result.append(digit);
                }
                
                last = digit;
            }
            
            int lastDigit = s.charAt(s.length() - 1) - '0';
            while (lastDigit-- > 0) result.append(')');
            
            System.out.println("Case #" + c++ + ": " + result.toString());
        }
    }
}

