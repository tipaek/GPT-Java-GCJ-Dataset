import java.util.HashMap;
import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine();
        for(int i = 1; i <= numberOfTestCases; i++){
            String digits = scanner.nextLine();
            String nestedStrings = "";

            boolean open = false;

            int numOpen = 0;
            for(int j = 0; j < digits.length(); j++){
                int digit = Character.getNumericValue(digits.charAt(j));

                // for(int numOfBraces = 0; numOfBraces < digit; numOfBraces++){
                    // nestedStrings += 
                    if(digit > numOpen){
                        int x = digit - numOpen;
                        for(int numOfBraces = 0; numOfBraces < x; numOfBraces++){
                            nestedStrings += "(";
                            numOpen++;
                        }
                        
                    } else {
                        int y = numOpen - digit;
                        for(int numOfBraces = 0; numOfBraces < y; numOfBraces++){
                            nestedStrings += ")";
                            numOpen--;
                        }
                    
                    }
                nestedStrings += digits.charAt(j);
                
                

            }
            while(numOpen > 0){
                nestedStrings += ")";
                numOpen--;
            }

            System.out.println("Case #" + i + ": " + nestedStrings);
        }

    }


}