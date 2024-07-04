import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

//        System.setIn(new FileInputStream("./input.txt"));
        Scanner scanner = new Scanner(System.in);
        
        int problemCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < problemCount; i++) {
            StringBuffer output = new StringBuffer();

            String input = scanner.nextLine();
            int len = input.length();

            int lastNum = -1;
            for (int j = 0; j < len; j++) {
                int num = input.charAt(j) - 48;

                if(lastNum == -1) {
                    loop(output, '(', num);
                    output.append(input.charAt(j));
                    lastNum = num;

                } else if(lastNum != num) {

                    int diff = num - lastNum;
                    if(diff > 0) {
                        loop(output, '(', diff);
                    } else if(diff < 0) {
                        loop(output, ')', -diff);
                    }

                    output.append(input.charAt(j));
                    lastNum = num;
                } else {
                    output.append(input.charAt(j));
                }
            }

            loop(output, ')', lastNum);
            System.out.println("Case #" + (i+1) + ": " + output);
        }
    }

    private static void loop(StringBuffer buf, char c, int num) {
        for (int i = 0; i < num; i++) {
            buf.append(c);
        }
    }
}
