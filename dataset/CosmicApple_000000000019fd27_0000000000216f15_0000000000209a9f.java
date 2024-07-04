import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        int numOfTests = input.nextInt ();
        String openBracs = "(((((((((";
        String closeBracs = ")))))))))";
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            
            String raw = "" + input.next();
            String processed = "";
            for (int i = 0; i < raw.length(); i++) {
                int num = Integer.parseInt(raw.substring(i, i+1));
                processed += openBracs.substring(0, num) + raw.substring(i, i+1) 
                    + closeBracs.substring(0, num);
            }
            
            for (int i = 1; i < processed.length();i++) {
                if (processed.substring(i, i+1).equals("(") &&
                        processed.substring(i-1, i).equals(")")) {
                    processed = processed.substring(0, i-1) + 
                        processed.substring(i+1, processed.length());
                    i--;
                }
            }
            
            
            System.out.println("Case #" + currentTest + ": " + processed);
        }
    }
}