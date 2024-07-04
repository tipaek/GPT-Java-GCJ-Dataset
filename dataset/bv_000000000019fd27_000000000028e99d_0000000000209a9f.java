import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class VParanthesis{
    public String validateParenthesis(String s){
        StringBuilder builder = new StringBuilder(s);
        int i=0;

        while(i<builder.length()-1){
            if(builder.charAt(i) == ')' && builder.charAt(i+1) == '('){
                builder.deleteCharAt(i+1);
                builder.deleteCharAt(i);
                i--;
                continue;
            }
            i++;
        }
        return builder.toString();
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        VParanthesis obj = new VParanthesis();
        String inputStr = "";
        String ext = in.nextLine();
        for(int i=1;i <= t; i++)
        {	String s = in.nextLine();
            String input = "";
            //System.out.println("first input " + s);
            for(char c : s.toCharArray()){
                int n = (int) c - '0';
                int itr = n;
                String oP = "";
                String cP = "";
                while(itr>0){
                    oP += "(";
                    cP += ")";
                    itr--;
                }
                input += oP + n + cP;
                //System.out.println("input - " + input);
            }
            String output = obj.validateParenthesis(input);
            System.out.println("Case #" + i + ": " + output);

        }
    }
}