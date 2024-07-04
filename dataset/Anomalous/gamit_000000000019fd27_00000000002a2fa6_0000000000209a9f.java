import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EN2018Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(scanner.nextLine());
        long caseIndex = 1;

        for (int t = 0; t < T; t++) {
            String S = scanner.nextLine();
            StringBuilder caseAnswer = new StringBuilder();
            int counter = 0;

            for (char ch : S.toCharArray()) {
                int n = ch - '0';

                while (counter < n) {
                    caseAnswer.append('(');
                    counter++;
                }
                while (counter > n) {
                    caseAnswer.append(')');
                    counter--;
                }
                caseAnswer.append(n);
            }

            while (counter > 0) {
                caseAnswer.append(')');
                counter--;
            }

            System.out.println("Case #" + caseIndex + ": " + caseAnswer);
            caseIndex++;
        }
    }
}