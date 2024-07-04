import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static int intValue(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    public static void main(String arg[]) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = scan.nextInt();
        scan.nextLine();
        boolean flag = false;
        for (int t = 1; t <= testCase; t++) {
            String input = scan.nextLine();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {

                if (i == 0) {
                    for (int j = 0; j < intValue(input.charAt(i)); j++) {
                        sb.append('(');
                    }
                    sb.append(input.charAt(i));
                }

                else {
                    if (input.charAt(i) < input.charAt(i - 1)) {
                        for (int j = 0; j < (intValue(input.charAt(i - 1)) - intValue(input.charAt(i))); j++) {
                            sb.append(')');
                        }
                        sb.append(input.charAt(i));
                    }
                    if (input.charAt(i) == input.charAt(i - 1)) {
                        sb.append(input.charAt(i));
                    }
                    if (input.charAt(i) > input.charAt(i - 1)) {
                        for (int j = 0; j < (intValue(input.charAt(i)) - intValue(input.charAt(i - 1))); j++) {
                            sb.append('(');
                        }
                        sb.append(input.charAt(i));
                    }


                }
            }

                for(int k=0;k< intValue(input.charAt(input.length()-1)) ; k++)
                {
                    sb.append(')');
                }
            System.out.println("Case #" + t + ": " + sb);

        }
    }
}