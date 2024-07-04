import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        scan.nextLine();
        for(int i = 1; i <= cases; ++i){
            String line = scan.nextLine();
            int[] digits = new int[line.length()];
            for (int j = 0; j < line.length(); ++j){
                digits[j] = line.charAt(j) - '0';
            }
            StringBuilder result = new StringBuilder();
            int parentheses = 0;
            for(int j = 0; j < digits.length; ++j){
                if(parentheses < digits[j]){
                    for(int k = 0; k < digits[j]-parentheses; ++k){
                        result.append("(");
                        ++parentheses;
                    }
                }else{
                    for(int k = 0; k < parentheses - digits[j]; ++k){
                        result.append(")");
                        --parentheses;
                    }
                }
                result.append(digits[j]);
            }
            for(int j = 0; j < parentheses; ++j){
                result.append(")");
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}