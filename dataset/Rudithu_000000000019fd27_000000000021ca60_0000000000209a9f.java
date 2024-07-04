import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            String currentRow = in.next();
            System.out.print("Case #" + i + ":");
            int latestNumb = 0;
            for (char c : currentRow.toCharArray()) {
                int currentNumb = c - '0';

                int diff = currentNumb - latestNumb;
                if (diff > 0) {
                    for (int j=0; j<diff; j++) {
                        System.out.print("(");
                    }
                } if (diff < 0) {
                    for (int j=diff; j < 0 ; j++) {
                        System.out.print(")");
                    }
                }
                latestNumb = currentNumb;
                System.out.print(currentNumb);
            }

            for (int k = 0; k < latestNumb; k++) {
                System.out.print(")");
            }
            System.out.println();
        }
    }

}
