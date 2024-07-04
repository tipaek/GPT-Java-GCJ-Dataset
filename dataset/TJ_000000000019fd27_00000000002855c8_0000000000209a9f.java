import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new BufferedReader(new FileReader("/home/dev/projects/codejam20/src/input2.txt")));

        //# of test cases
        int T = in.nextInt();

        //iterate test cases
        for (int t=1; t<=T; t++){
            String line = in.next();
            int [] digits = convertToIntArr(line);
            solveArray(t, digits);
        }
    }

    private static void solveArray(int testCase, int[] digits) {
        System.out.print(" Case #" + testCase + ": ");
        String output = "";
        Stack openPars = new Stack();
        for (int i : digits) {
            if (i == 0 && openPars.isEmpty()) {
                output = output + i;
            } else {

                if (openPars.isEmpty()) {
                    for (int b = 0; b<i ; b++) {
                        openPars.push('(');
                        output = output + '(';
                    }
                    output = output + i;
                } else {
                    if (openPars.size() == i) {
                        output = output + i;
                    } else if (openPars.size() < i) {
                        for (int b = openPars.size(); b < i; b ++) {
                            openPars.push('(');
                            output = output + '(';
                        }
                        output = output + i;
                    } else if (openPars.size() > i) {
                        int toClose = openPars.size();
                        for (int b = i; b < toClose; b ++) {
                            openPars.pop();
                            output = output + ')';
                        }
                        output = output + i;
                    }


                }

            }

        }

        while (!openPars.isEmpty()) {
            openPars.pop();
            output = output + ')';
        }

        System.out.println(output);
    }

    private static int[] convertToIntArr(String line) {
        int[] nums = new int[line.length()];
        for (int i = 0; i < line.length(); i++){
            nums[i] = line.charAt(i) - '0';
        }
        return nums;
    }


}
