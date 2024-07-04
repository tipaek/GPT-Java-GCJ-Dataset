import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        int i,j,k;
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(i = 1; i<=testCases; i++) {
            String number = scanner.next();
            String result = "";
            for(j=0; j<number.length(); j++) {
                if(number.charAt(j) == '0') result += '0';
                else {
                    int n = number.charAt(j) - '0';
                    for(k=0; k<n; k++) {
                        result += '(';
                    }
                    result += number.charAt(j);
                    for(k=0; k<n; k++) {
                        result += ')';
                    }
                }
            }

            char prevChar='!';
            String finalResult = "";
            for(k=0; k< result.length(); k++) {
                if(prevChar == ')' && result.charAt(k) == '(') {
                    finalResult = finalResult.substring(0, finalResult.length()-1);
                    prevChar = finalResult.charAt(finalResult.length()-1);
                }
                else {
                    finalResult += result.charAt(k);
                    prevChar = result.charAt(k);
                }
            }

            System.out.println("Case #" + i + ": " + finalResult);
        }
    }
}
