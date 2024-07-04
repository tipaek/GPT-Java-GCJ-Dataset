
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static String find(int b, Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        if (b == 10) {
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                String res = scanner.next();
                if (res.equals("N")) {
                    System.exit(-1);
                }
                sb.append(res);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nRound = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 0; i < nRound; i++) {
            System.out.println(find(b, scanner));
            String result = scanner.next();
            if (result.equals("N")) {
                break;
            }
        }
    }
}
