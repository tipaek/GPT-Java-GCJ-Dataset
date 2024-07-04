import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(sc.nextLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            char[] line = sc.nextLine().toCharArray();
            int rem = 0;

            System.out.print("Case #" + (testCase) + ": ");

            for (int c = 0; c < line.length; c++) {
                int num = Character.getNumericValue(line[c]);
                int d = rem - num;
                if (d < 0) {
                    for (int i = 0; i < d * -1; i++) {
                        System.out.print('(');
                    }
                }
                else {
                    for (int i = 0; i < d; i++) {
                        System.out.print(')');
                    }
                }               
                System.out.print(num);
                rem -= d;
            }
            
            for (int i = 0; i < rem; i++) {
                System.out.print(')');
            }
            System.out.print('\n');
        }
    }
}
