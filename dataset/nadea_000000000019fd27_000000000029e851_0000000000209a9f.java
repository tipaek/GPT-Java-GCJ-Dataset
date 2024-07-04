import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int cases = Integer.parseInt(in.nextLine());
            for (int i = 0; i < cases; i++) {
                String line = in.nextLine();

                StringBuilder sb = new StringBuilder();
                int openCounter = 0;
                int closeCounter = 0;
                int lastNum = 0;

                for (int j = 0; j < line.length(); j++) {
                    int num = line.charAt(j) - '0';
                    if (num != lastNum) {
                        if (num > openCounter-closeCounter) {
                            int delta = num - (openCounter - closeCounter);
                            for (int k = 0; k < delta; k++) {
                                sb.append("(");
                                openCounter++;
                            }
                        }
                        if (num < openCounter-closeCounter){
                            int delta = (openCounter-closeCounter) - num ;
                            for (int k = 0; k < delta; k++) {
                                sb.append(")");
                                closeCounter++;
                            }
                        }
                    }
                    sb.append(num);
                    lastNum = num;
                }
                int delta = (openCounter-closeCounter);
                if (delta > 0) {
                    for (int j = 0; j < delta; j++) {
                        sb.append(")");
                    }
                }
                System.out.print("Case #" + (i + 1) + ": " + sb.toString());
                if (i < cases - 1) {
                    System.out.println();
                }
            }
        }
    }
}
