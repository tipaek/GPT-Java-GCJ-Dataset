import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //Set up input scanner
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        //Receive first line (How many cases?)
        int caseCount = in.nextInt();

        for(int i = 1; i <= caseCount; i++){
            //Pass input to question method
            Q_Three(i, in);
        }
    }

    public static void Q_Three(int ident, Scanner in){
        String input = in.next();
        String output = "";
        int pLevel = 0;

        for(int i = 0; i < input.length(); i++){
            char curChar = input.charAt(i);
            int levelRequired = Character.getNumericValue(curChar);

            if(levelRequired > pLevel){
                while(levelRequired > pLevel){
                    output += "(";
                    pLevel++;
                }
            }
            else if(levelRequired < pLevel){
                while(levelRequired < pLevel){
                    output += ")";
                    pLevel--;
                }
            }

            output += levelRequired;
        }

        while(pLevel > 0){
            output += ")";
            pLevel--;
        }

        Print_Result(ident, output);
    }

    public static void Print_Result(int ident, String output){
        //Print result
        System.out.println("Case #" + ident + ": " + output);
    }
}