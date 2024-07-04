
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String str;

        for (int i = 0; i < t; i++) {

            // int input = in.nextInt();
            str = in.next();
            StringBuilder sb = new StringBuilder();
            char[] charArray = str.toCharArray();
            int j = 0;

            if (charArray.length < 2) {
                if (charArray[0] == '0') {
                    sb.append("0");
                } else if (charArray[0] == '1') {
                    sb.append("(").append("1").append(")");
                }

                System.out.println("Case #" + (i+1) + ": " + sb.toString());

            } else if (charArray.length > 1) {

                while (j < charArray.length) {

                    // System.out.println("j:" + j);

                    if (charArray[j] == '1') {
                        sb.append("(");
                        for (int k = j + 1; k < charArray.length; k++) {
                            // System.out.println("k:" + k);
                            sb.append('1');
                            if (charArray[k] != '1') {
                                sb.append(")");
                                // System.out.println("k break:" + k);
                                j = k;
                                break;
                            }
                            j = k;
                        }

                       if (j > 0 && j == charArray.length - 1 && charArray[j] != '0') {
                            // System.out.println("j is in last char");
                            if (charArray[j - 1] == '1') {
                                sb.append("1").append(")");
                            } else {
                                sb.append("1").append(")");
                            }
                            j++;
                        }
                    }

                    else if (charArray[j] == '0') {
                        // System.out.println("equals 0");
                        sb.append("0");
                        j++;
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + sb.toString());
            }

        }
    }
}
