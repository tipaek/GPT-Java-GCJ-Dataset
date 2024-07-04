import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            StringBuffer input = new StringBuffer(in.next());
            int counter = input.length();
            for (int j = 0; counter > - 1; j++) {
                if (j == 0) {
                    for (int k = 0; k < Integer.parseInt(String.valueOf(input.charAt(j))); k++) {
                        input.insert(j, '(');
                        j = j + 1;
                    }
                    counter = counter - 1;
                } else if (counter == 0) {
                    for (int k = 0; k < Integer.parseInt(String.valueOf(input.charAt(j - 1))); k++) {
                        input.insert(j, ')');
                    }
                    counter = counter - 1;
                } else {
                    int difference = Integer.parseInt(String.valueOf(input.charAt(j))) - Integer.parseInt(String.valueOf(input.charAt(j - 1)));
                    if (difference >= 0) {
                        for (int k = 0; k < difference; k++) {
                            input.insert(j, '(');
                            j = j + 1;
                        }
                    } else {
                        for (int k = 0; k < - 1 * difference; k++) {
                            input.insert(j, ')');
                            j = j + 1;
                        }
                    }
                    counter = counter - 1;
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