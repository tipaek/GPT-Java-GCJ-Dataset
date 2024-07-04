import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int cases = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < cases; i++) {
            String str = scn.nextLine();

            System.out.print("Case #" + (i+1) + ": ");

            boolean hasStartedOne = false;
            for (int s = 0; s < str.length(); s++) {
                
                if (str.charAt(s) == '0') {
                    if (hasStartedOne) {
                        hasStartedOne = false;
                        System.out.print(")0");
                    } else {
                        System.out.print('0');
                    }
                } else if (str.charAt(s) == '1') {
                    if (hasStartedOne) {
                        System.out.print('1');
                    } else {
                        hasStartedOne = true;
                        System.out.print("(1");
                    }
                }

            }

            //end of string:
            if (hasStartedOne)
                System.out.print(")");

            System.out.println();
        }
    }
}