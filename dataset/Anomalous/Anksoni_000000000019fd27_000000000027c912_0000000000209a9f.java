import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 1; i <= t; i++) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            int previousDigit = 0;
            
            for (int j = 0; j < s.length(); j++) {
                int currentDigit = Character.getNumericValue(s.charAt(j));
                
                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        sb.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        sb.append(')');
                    }
                }
                
                sb.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            for (int k = 0; k < previousDigit; k++) {
                sb.append(')');
            }
            
            System.out.println("Case #" + i + ": " + sb.toString());
        }
        
        in.close();
    }
}