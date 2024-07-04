import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        String[] results = new String[cases];
        sc.nextLine();
        for (int i = 0; i < cases; i++){
            String digits = sc.nextLine();
            results[i] = "Case #" + (i+1) + ": " + findMin(digits);
        }
        sc.close();
        for (String str : results){
            System.out.println(str);
        }
    }
    public static String findMin(String digits){
        String result = "";
        String open = "";
        String close = "";
        int prev = Integer.parseInt(digits.substring(0,1));
        for (int j = 0; j < prev; j++){
            open += "(";
            close += ")";
        }
        result = open + prev + close;
        for (int i = 1; i < digits.length(); i++){
            int curr = Integer.parseInt(digits.substring(i,i+1));
            int diff = curr - prev;
            if (diff > 0){
                String right = "";
                String left = "";
                for (int j = 0; j < diff; j++){
                    right += ")";
                    left += "(";
                }
                int index = result.length() - prev;
                result = result.substring(0, index) + left + curr + right + result.substring(index);
            }
            else {
                int index = result.length() - curr;
                result = result.substring(0,index) + curr + result.substring(index);
            }
            prev = curr;
        }
        return result;
    }
}