import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = (int)in.nextLine().charAt(0);
        int c = 1;
        //for each case
        while(in.hasNextLine()) {

            int currentDepth = 0;
            String caseString = in.nextLine();

            int len = caseString.length();
            List<Character> outputList = new ArrayList<Character>();

            for (int i =0 ; i < len ; i++ ){

                //ASCII type chages
                int currentChar_intType = caseString.charAt(i) - '0';
                char currentChar_char = caseString.charAt(i);
                //System.out.println(current);

                if ( currentChar_intType == currentDepth ) {
                    outputList.add(currentChar_char);
                }
                else if (currentChar_intType > currentDepth) {
                    for (int idx = currentDepth; idx < currentChar_intType ; idx++ ){
                        outputList.add('(');
                        currentDepth++;
                    }
                    outputList.add(currentChar_char);
                }

                else if (currentChar_intType < currentDepth) {
                    for (int idx2 = currentDepth; idx2 > currentChar_intType; idx2-- ){
                        outputList.add(')');
                        currentDepth--;
                    }
                    outputList.add(currentChar_char);
                }


                if ( i == len-1 && currentDepth != 0) {
                    for (int k = 0; k <= currentDepth; k++) {
                        outputList.add(')');
                        //currentDepth--;
                    }
                }
            }

            StringBuilder builder = new StringBuilder();
            for (Character value : outputList) {
                builder.append(value);
            }
            String outputString = builder.toString();

            System.out.println("Case #" + c + ": " + outputString);
            //System.out.println(outputString.equals("((((((6(((9))))))3)2222((4(5(((8)))))))1(((((6)))))111((((5)))))0(((3333((((((9))))))))1)0((((44444)))1(2((((66666))))))0(((((((((9))))5(((88(9999)888)77777))))))1((((((7)))))))0(1111)"));
            //System.out.println("Case #2: " + "((((((6(((9))))))3)2222((4(5(((8)))))))1(((((6)))))111((((5)))))0(((3333((((((9))))))))1)0((((44444)))1(2((((66666))))))0(((((((((9))))5(((88(9999)888)77777))))))1((((((7)))))))0(1111)");
            c++;
        }
    }
}