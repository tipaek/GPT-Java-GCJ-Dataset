 
import java.util.Scanner;
import java.lang.StringBuilder;

public class Solution {
    
    public static final Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int numberOfTests = input.nextInt();
        for (int currentTest = 1; currentTest <=numberOfTests; currentTest++) {
            String S = input.next();
            for (char currentClassifer = '1'; currentClassifer <= '9'; currentClassifer++) {
            		StringBuilder output = new StringBuilder();
                for (int x = 0; x<S.length(); x++) {
                    if (S.charAt(x)>=currentClassifer) {
                        output.append('(');
                        output.append(S.charAt(x));
                        for (x = x+1; x<=S.length(); x++) {
                            if (x==S.length()) {
                                output.append(')');
                            } else if (S.charAt(x)<currentClassifer) {
                                output.append(')');
                                output.append(S.charAt(x));
                                break;
                            } else {
                                output.append(S.charAt(x));
                            }
                        }
                    } else {
                        output.append(S.charAt(x));
                    }   
                }
                S = output.toString();
            }
            System.out.println(String.format("Case #%d: %s", currentTest, S));
        }
    }
}