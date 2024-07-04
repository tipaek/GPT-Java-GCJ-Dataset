import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for(int caseno = 1; caseno<=testcase;caseno++) {
            String inputString = sc.next();
            StringBuilder outputString = new StringBuilder();
            int openedBraces = 0;

            for (int i=0;i<inputString.length();i++) {
                char ch = inputString.charAt(i);

                int num = Integer.parseInt(ch+"");
                if (openedBraces < num) {
                    int times = num-openedBraces;
                    for (int j=0;j<times ;j++) {
                        outputString.append("(");
                        openedBraces++;
                    }
                } else if (openedBraces > num) {
                    int times = openedBraces-num;
                    for (int j=0;j<times ;j++) {
                        outputString.append(")");
                        openedBraces--;
                    }
                }
                outputString.append(ch);
            }

            for (int j=0;j<openedBraces ;j++) {
                outputString.append(")");
            }

            System.out.println("Case #" + caseno +": " + outputString.toString());
        }
    }
}
