import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] results = new String[scanner.nextInt()];
        scanner.nextLine();

        for(int idx = 0; idx < results.length; idx++){
            results[idx] = nestParentheses(scanner.nextLine(), idx + 1);
        }
        scanner.close();

        for(String res : results){
            System.out.println(res);
        }
    }

    public static void appendToBuilder(StringBuilder builder, char c, int num){
        int count = 0;
        while(count < num){
            builder.append(c);
            count++;
        }
    }

    public static String nestParentheses(String digits, int no){
        StringBuilder builder = new StringBuilder();

        for(int idx = 0; idx < digits.length() + 1; idx++){
            int prev = idx > 0 ? Integer.parseInt(digits.charAt(idx - 1) + ""): 0;
            int num = idx < digits.length() ? Integer.parseInt(digits.charAt(idx) + ""): 0;

            if(prev < num){
                appendToBuilder(builder, '(', num - prev);
            }else if(prev > num){
                appendToBuilder(builder, ')', prev - num);
            }

            if(idx < digits.length()){
                builder.append(num);
            }
        }

        return "Case #" + no + ": " + builder.toString();
    }
}