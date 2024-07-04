import java.util.Collections;
import java.util.Scanner;

public class Solution {
    
    public static void main(String [] argv){
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for(int i = 0; i< numberOfTestCases; i++){
            String input = scanner.next();
            String output = "";
            int k = 0;
            int n = input.length();
            for(int j=0; j<n; j++){
                char c = input.charAt(j);
                int m = Character.getNumericValue(c);
                if(m==k){
                    output += c;
                }
                else if(m>k){
                    int difference = m - k;
                    output += getParenthesis(difference,true) + c;
                    k = k + difference;
                }
                else{
                    int difference = k - m;
                    output += getParenthesis(difference,false) + c;
                    k = k - difference;                    
                }
            }
            if(k>0)
            {
                output += getParenthesis(k,false);
            }
            System.out.println("Case #"+(i+1)+": "+output);
        }
    }
    private static String getParenthesis(int n,boolean open){
        if(open)
            return String.join("", Collections.nCopies(n, "("));
        else
            return String.join("", Collections.nCopies(n, ")"));
    }
}
