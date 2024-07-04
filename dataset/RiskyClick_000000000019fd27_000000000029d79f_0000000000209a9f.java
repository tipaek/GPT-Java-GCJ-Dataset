import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int theCount = 1;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int repsBrah = in.nextInt();
        String toss = in.nextLine();

        while (theCount < repsBrah + 1) {
            String theString = in.nextLine();
            String theNewString = "";
            int keepThatShitEven = 0;

            for (int i = 0; i < theString.length(); i++) {
                //if its the first char in the string populate that many ( followed by the i
                if (i == 0) {
                    int adder = 0;
                    int current = Character.getNumericValue(theString.charAt(i));
                    while (adder != current) {
                        theNewString += '(';
                        adder++;
                        keepThatShitEven++;
                    }
                    theNewString += theString.charAt(i);
                } else {
                    //if last value if > current, add ) the diffrence amount of time folloed by the currenct
                    int pre = Character.getNumericValue(theString.charAt(i - 1));
                    int current = Character.getNumericValue(theString.charAt(i));
                    if (pre > current) {
                        int diff = pre - current;
                        int adder = 0;
                        while (adder != diff) {
                            theNewString += ')';
                            keepThatShitEven--;
                            adder++;
                        }
                        theNewString += current;
                    } else if (pre < current) {
                        //ifthe previous value is less the the current the add that the diff in ( followed by the currenct
                        int diff = current - pre;
                        int adder = 0;
                        while (adder != diff) {
                            theNewString += '(';
                            adder++;
                            keepThatShitEven++;
                        }
                        theNewString += current;
                    } else {
                        //if they are both the same number then add the current and carry on
                        theNewString += current;
                    }

                }
            }


                while (keepThatShitEven != 0) {
                    theNewString += ')';
                    keepThatShitEven--;
                }
                System.out.println("Case #" + theCount + ": " + theNewString);
                theCount++;
            }
        }
    }
