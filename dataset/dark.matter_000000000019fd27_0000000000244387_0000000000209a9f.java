import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int i = 0;

        while(i < n) {

            String input = in.next();

            StringBuilder output = new StringBuilder(input);

            int prevNum = -1;

            for(int j = 0 ; j < input.length() ; ++j) {

                int num = (input.charAt(j) - '0');

                if(prevNum == -1) {
                    addBrackets(num,0,output,true);
                    prevNum = num;
                }
                else {
                    if(prevNum > num) {
                        addBrackets((prevNum-num),j, output,false);
                    }
                    else if(prevNum < num) {
                        addBrackets((num-prevNum),j,output,true);
                    }
                    prevNum=num;
                }

            }

            evaluateAndAddClosingBracketsAtEnd(output);

            System.out.println("Case #" + (i+1) + ": "+output);

            ++i;
        }
    }

    /*
            string - input string which will be returned back
            number - number of brackets
            open - (true - open bracket/ false - closed bracket)
            index - index of the original string
                    this will add brackets before the index specified
     */

    public static StringBuilder addBrackets(int number, int index, StringBuilder string, boolean open) {

        //System.out.println(" Entering the function with number : "+number + " index : " + index + " string : " + string.toString() + " open : "+ open);

        if(number == 0) {
            return string;
        }
        else {
            int runningIndex = 0;
            int indexCount = 0;
            while(indexCount < index) {
                if((string.charAt(runningIndex) != '(') && (string.charAt(runningIndex) != ')' ))
                    ++indexCount;
                ++runningIndex;
            }

            for(int currIndex = 0; currIndex < number ; ++currIndex) {
                if(open)
                    string.insert(runningIndex,'(');
                else
                    string.insert(runningIndex,')');
            }
           // System.out.println(" Ending the function with number : "+number + " index : " + index + " string" + string.toString() + " open : "+ open);

            return string;
        }
    }

    private static void evaluateAndAddClosingBracketsAtEnd(StringBuilder output) {
        int openCount = 0;
        int closeCount = 0;

        int index = 0;
        while(index < output.length()) {

            if(output.charAt(index) == '(')
                ++openCount;
            else if(output.charAt(index) == ')')
                ++closeCount;

            ++index;
        }

        while(openCount > closeCount) {
            output.append(')');
            ++closeCount;
        }
    }


}
