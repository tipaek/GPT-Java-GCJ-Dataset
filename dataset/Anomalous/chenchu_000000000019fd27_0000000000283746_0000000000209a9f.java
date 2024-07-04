import java.util.Scanner;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int[] num = s.chars().map(Character::getNumericValue).toArray();
            StringBuilder result = new StringBuilder();
            
            int currentDepth = 0;
            
            for (int j = 0; j < num.length; j++) {
                int digit = num[j];
                
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(digit);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println(result);
        }
        
        sc.close();
    }
}