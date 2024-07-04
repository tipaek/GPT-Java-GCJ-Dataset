import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args)  {
        
        int numCases;
        String inputString, primeString;

        primeString = "";
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        numCases = sc.nextInt();
        
        for(int i = 1; i <= numCases; i++) {
            inputString = sc.next();
            
            primeString = nestString(0, inputString.length(), inputString);

            System.out.println("Case #" + i + ": " + primeString);
        }

        sc.close();

    }

    private static String nestString(int depth, int length, String inputString) {

        String returnString = "";

        if(length > 0){
            int i = inputString.charAt(0) - '0';
            int i2 = -1;
            
            if( length > 1){
                i2 = inputString.charAt(1) - '0';
            }
            
            if(i == 0 && i == depth){
                returnString = "0" + nestString(depth, length-1, inputString.substring(1));
            }
            else if( i > depth){
                returnString = "(" + nestString(depth+1, length, inputString);
            }
            else if(i == depth){

                if( i == i2 && i > 0) {
                    returnString = i + nestString(depth, length-1, inputString.substring(1));
                }
                else {
                    returnString = i + nestString(depth, length-1, inputString.substring(1));
                }
            }
            else if( i < depth) {
                returnString = ")" + nestString(depth-1, length, inputString);
            }
        }
        if(length == 0 && depth > 0){
            for(int i = 0; i < depth; i++){
                returnString = returnString + ")";
            }
        }

        return returnString;
    }
}
