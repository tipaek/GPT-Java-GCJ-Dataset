// import java.io.ByteArrayInputStream;
// import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String exampleString = "5\n" +
                "1\n" +
                "4\n" +
                "19\n" +
                "999\n" +
                "1024";
        // in = new Scanner(new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8)));

        int cases = in.nextInt();
        cases:
        for (int i = 1; i <= cases; i++) {
            int number = in.nextInt();


            if (number < 500) {
                System.out.printf("Case #%d:", i);
                System.out.println();
                printDirectPath(number);
                continue cases;
            } else {
                int summ = 0;
                number -= 32;
                String binaryString = new StringBuilder(Integer.toBinaryString(number)).reverse().toString();
                System.out.printf("Case #%d:", i);
                System.out.println();

                int rowsEmptyInPath = 0;
                boolean left = true;
                for (int j = 1; j <= binaryString.length(); j++) {
                    char c = binaryString.charAt(j-1);
                    if (c == '1') {
                        if(left){
                            for (int k = 1; k <= j; k++) {
                                System.out.println(j + " " + k);
                            }
                        }else{
                            for (int k = j; k > 0; k--) {
                                System.out.println(j + " " + k);
                            }
                        }
                        left = !left;
                        summ += Math.pow(2, j-1);

                    } else {
                        rowsEmptyInPath++;
                        summ++;
                        if (left) {
                            System.out.println(j + " " + 1);
                        } else {
                            System.out.println(j + " " + j);
                        }
                    }
                }

                int nextRow = binaryString.length() + 1;
                int row = nextRow;
                for ( ; row < nextRow + 32 - rowsEmptyInPath; row++) {
                    summ++;
                    if (left) {
                        System.out.println(row + " " + 1);
                    } else {
                        System.out.println(row + " " + row);
                    }
                }

//                System.out.println(binaryString);
//                System.out.println(summ);
            }


        }

    }

    private static void printDirectPath(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println(i + " " + 1);
        }
    }
}
