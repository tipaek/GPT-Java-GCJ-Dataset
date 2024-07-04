import java.util.Scanner;

public class CodeJam2020_NestingDepth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String k = sc.next();
            StringBuilder str = new StringBuilder();
            boolean opened = false;

            for (int j = 0; j < k.length(); j++) {
                char currentChar = k.charAt(j);

                if (currentChar == '1') {
                    if (!opened) {
                        str.append('(');
                        opened = true;
                    }
                    str.append(currentChar);
                } else if (currentChar == '0') {
                    if (opened) {
                        str.append(')');
                        opened = false;
                    }
                    str.append(currentChar);
                }
            }
            if (opened) {
                str.append(')');
            }
            System.out.println(str.toString());
        }
    }
}