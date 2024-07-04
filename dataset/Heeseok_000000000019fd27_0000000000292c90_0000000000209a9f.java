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

            StringBuffer closeBuf = new StringBuffer();

            int lastNum = -1;
            for (int j = 0; j < len; j++) {
                int num = input.charAt(j) - 48;

                if(lastNum == -1 || lastNum != num) {

                    if(closeBuf.length() > 0) {
                        output.append( closeBuf.toString() );
                        closeBuf = new StringBuffer();
                    }

                    loop(output, '(', num);
                    loop(closeBuf, ')', num);

                    output.append(input.charAt(j));
                    lastNum = num;
                } else {
                    output.append(input.charAt(j));
                }
            }

            if(closeBuf.length() > 0) {
                output.append( closeBuf.toString() );
            }
            System.out.println("Case #" + (i+1) + ": " + output);
        }
    }

    private static void loop(StringBuffer buf, char c, int num) {
        for (int i = 0; i < num; i++) {
            buf.append(c);
        }
    }
}
