import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        scan.nextLine();
        for(int i = 1; i <= cases; ++i){
            String line = scan.nextLine();
            StringBuilder result = new StringBuilder();
            int[] digits = new int[line.length()];
            for (int j = 0; j < line.length(); ++j){
                digits[j] = line.charAt(j) - '0';
            }
            int current = digits[0];
            for(int j = 0; j < current; ++j){
                result.append("(");
            }
            result.append(current);
            for(int j = 1; j < digits.length; ++j){
                if(digits[j] != current){
                    for(int k = 0; k < current; ++k){
                        result.append(")");
                    }
                    for(int k = 0; k < digits[j]; ++k){
                        result.append("(");
                    }
                    current = digits[j];
                }
                result.append(digits[j]);
            }
            for(int j = 0; j < current; ++j){
                result.append(")");
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}