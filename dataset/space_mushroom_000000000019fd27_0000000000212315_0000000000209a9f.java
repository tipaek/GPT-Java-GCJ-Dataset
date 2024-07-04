import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));

    private static String helper(List<Integer> digits, int previous, String currentString){
        if(digits.size()==0) {
            for(int i=0; i<previous; i++){
                currentString += ')';
            }
            return currentString;
        }
        int current = digits.remove(0);
        int parenthesisNumber = current - previous;

        for(int i=0; i<parenthesisNumber; i++){
            currentString += '(';
        }
        for(int i=0; i>parenthesisNumber; i--){
            currentString += ')';
        }
        currentString += current;

        return helper(digits, current, currentString);
    }

    private static String solve(String str){
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            nums.add(str.charAt(i) - '0');
        }

        return helper(nums, 0, "");
    }

    public static void main(String[] args){
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++){
            String s = input.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + solve(s));
        }
    }
}