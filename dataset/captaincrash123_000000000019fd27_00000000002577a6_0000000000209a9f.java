import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            StringBuffer input = new StringBuffer(in.next());
            boolean stillDigits = true;
            for (int j = 1; stillDigits && j < 10; j++) {
                int counter = 0;
                for (int k = 0; k < input.length(); k++) {
                    if (input.charAt(k) == ')' || input.charAt(k) == '(') {

                    } else if (Integer.parseInt(String.valueOf(input.charAt(k))) == j) {
                        input.insert(k, '(');
                        counter = counter + 1;
                        boolean parenthesesClosed = false;
                        for (int l = k + 1; l < input.length() && !parenthesesClosed; l++) {
                            if (input.charAt(l) == ')') {
                                input.insert(l, ')');
                                parenthesesClosed = true;
                                k = l + 1;
                            } else if (Integer.parseInt(String.valueOf(input.charAt(l))) < j) {
                                input.insert(l, ')');
                                parenthesesClosed = true;
                                k = l + 1;
                            } else if (l == input.length() - 1) {
                                input.insert(l + 1, ')');
                                parenthesesClosed = true;
                                k = l;
                            }
                        }
                    }
                }
                if (counter == 0) {
                    stillDigits = false;
                }
            }
            System.out.print("Case #");
            System.out.print(i + 1);
            System.out.print(": ");
            System.out.println(input.toString());
        }
        in.close();
        
    }
}