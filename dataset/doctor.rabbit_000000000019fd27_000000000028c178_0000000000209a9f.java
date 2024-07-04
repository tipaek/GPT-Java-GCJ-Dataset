import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = (int)in.nextLine().charAt(0);

        //for each case
        while(in.hasNextLine()) {
            int c = 1;
            int currentDepth = 0;
            String caseString = in.nextLine();

            int len = caseString.length();
            List<Character> outputList = new ArrayList<Character>();

            for (int i =0 ; i < len ; i++ ){

                if ( caseString.charAt(i) == '0' && currentDepth == 0 )
                    outputList.add(caseString.charAt(i));

                else if (caseString.charAt(i) == '0' && currentDepth == 1) {
                    outputList.add(')');
                    currentDepth--;
                    outputList.add(caseString.charAt(i));
                }

                else if ( caseString.charAt(i) == '1' && currentDepth == 0) {
                    outputList.add('(');
                    currentDepth++;
                    outputList.add(caseString.charAt(i));
                }

                else if (caseString.charAt(i) == '1' && currentDepth == 1 ) {
                    outputList.add(caseString.charAt(i));
                }

                if ( i == len-1 && currentDepth != 0) {
                    for (int k = 0; k < currentDepth; k++) {
                        outputList.add(')');
                        currentDepth--;
                    }
                }
            }

            StringBuilder builder = new StringBuilder();
            for (Character value : outputList) {
                builder.append(value);
            }
            String outputString = builder.toString();
            //System.out.println(outputString);

            System.out.println("Case #" + c + ": " + outputString);
        }
    }
}