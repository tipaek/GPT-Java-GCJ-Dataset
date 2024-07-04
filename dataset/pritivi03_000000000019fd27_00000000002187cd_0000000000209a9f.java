import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for (int i = 0; i < tc; i++) { //each test case
            String line = in.nextLine();
            int depth = 0;
            StringBuilder finalString = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {//loop through each digit
                int digit = Character.getNumericValue(line.charAt(j));
                if (depth < digit) {
                    //we need to add more
                    int times = digit - depth;
                    for (int k = 0; k < times; k++) {
                        finalString.append("(");
                        depth++;
                    }
                } else {
                    //close parens until we get to wanted depth
                    int times = depth - digit;
                    for (int k = 0; k < times; k++) {
                        finalString.append(")");
                        depth--;
                    }
                }

                finalString.append(digit);
                //handle edge case - last one do closing for depth
                if (j == line.length() - 1) {
                    for (int k = 0; k < depth; k++) {
                        finalString.append(")");
                    }
                }
            }
            System.out.println(finalString.toString());
        }

    }
}
