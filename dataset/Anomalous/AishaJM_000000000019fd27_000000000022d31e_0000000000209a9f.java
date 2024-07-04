import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine();
        
        String[] strArr = new String[N];
        
        for (int i = 0; i < N; i++) {
            String T = input.nextLine();
            StringBuilder sb = new StringBuilder();
            int prevDigit = 0;

            for (char ch : T.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                
                if (currentDigit > prevDigit) {
                    for (int j = 0; j < currentDigit - prevDigit; j++) {
                        sb.append("(");
                    }
                } else if (currentDigit < prevDigit) {
                    for (int j = 0; j < prevDigit - currentDigit; j++) {
                        sb.append(")");
                    }
                }
                
                sb.append(currentDigit);
                prevDigit = currentDigit;
            }
            
            for (int j = 0; j < prevDigit; j++) {
                sb.append(")");
            }
            
            strArr[i] = sb.toString();
        }
        
        for (int i = 0; i < strArr.length; i++) {
            System.out.printf("Case #%d: %s\n", i + 1, strArr[i]);
        }
    }
}