import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int n = input.nextInt();

//            System.out.println(n);


            System.out.printf("Case #%d:\n", caseNum);

            int count = 1;
            System.out.println("1 1");
            int line = 1;
            boolean countingLines = true;
            while(count < n) {
                if (countingLines && (count + line) > n) {
                    countingLines = false;
                    count += 1;
                    System.out.printf("%d 1\n", line);
                    if (count == n) {
                        break;
                    }
                }
                line += 1;
                if (countingLines) {
                    count += line - 1;
                    System.out.printf("%d 2\n", line);
                } else {
                    count += 1;
                    System.out.printf("%d 1\n", line);
                }
            }
        }
    }


    static long binomi(int n, int k) {
        if ((n == k) || (k == 0))
            return 1;
        else
            return binomi(n - 1, k) + binomi(n - 1, k - 1);
    }
}
