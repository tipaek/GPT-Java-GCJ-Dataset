

import java.util.Scanner;

public class Solution {


    public static void main(String args[]) {

        try (Scanner scanner = new Scanner(System.in);) {
            int testCount = Integer.parseInt(scanner.nextLine());
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String input = scanner.nextLine();
                int openCount = 0;
                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < input.length(); i++) {
                    int currNum = Integer.parseInt(input.charAt(i)+"");
                    if (currNum == openCount) {
                        sb.append(input.charAt(i));
                        continue;
                    }
                    if (currNum < openCount) {
                        int closeNow = openCount - currNum;
                        while (closeNow > 0) {
                            sb.append(')');
                            closeNow--;
                            openCount--;
                        }
                        sb.append(input.charAt(i));
                    }
                    if (currNum > openCount) {
                        int openNow =  currNum - openCount;
                        while (openNow > 0) {
                            sb.append('(');
                            openNow--;
                            openCount++;
                        }
                        sb.append(input.charAt(i));
                    }
                }
                while (openCount > 0)
                {
                    sb.append(')');
                    openCount--;
                }
                System.out.println("Case #"+testNumber+": "+  sb);
            }
        }
    }


}
