import java.util.*;
import java.io.*;


public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = scan.nextInt();
        for (int test_no = 0; test_no < numberOfTestCase; test_no++) {
            String line = scan.next();
            String result = "Case #" + (test_no + 1) + ": " + processBrakets(line);
            System.out.println(result);
        }
    }

    static String processBrakets(String line) {
        char[] digits = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        int previous = -1;
        int diff = 0;
        for (int i = 0; i < line.length(); i++) {
            int digit = Integer.parseInt(digits[i] + "");
            if (digit == 0) {
                if (previous == -1) {
                    sb.append(digit);
                } else if (previous == digit) {
                    sb.append(digit);
                } else if (previous != digit) {

                    if (previous > digit) {
                        diff = previous - digit;
                        for (int k = 0; k < (previous - digit); k++) {
                            sb.append(")");
                        }
                        sb.append(digit);
                    } else {
                        diff = digit - previous;
                        for (int k = 0; k < (digit - previous); k++) {
                            sb.append("(");
                        }
                        sb.append(digit);
                    }
                }
                previous = digit;
            } else if (digit != 0) {
                if (previous == -1) {
                    for (int k = 0; k < digit; k++) {
                        sb.append("(");
                    }
                    sb.append(digit);
                } else if (previous == digit) {
                    sb.append(digit);
                } else if (previous != digit) {
                    if (previous > digit) {
                        diff = previous - digit;
                        for (int k = 0; k < (previous - digit); k++) {
                            sb.append(")");
                        }
                        sb.append(digit);
                    } else {
                        diff = digit - previous;
                        for (int k = 0; k < (digit - previous); k++) {
                            sb.append("(");
                        }
                        sb.append(digit);
                    }
                }
                if (previous == -1) diff = digit;
                else {
                    diff = Math.abs(previous - digit);
                }
                previous = digit;

            }
        }
        if (previous != 0) {
            for (int i = 0; i < diff; i++) {
                sb.append(")");
            }
        }


        return sb.toString();
    }
    
}