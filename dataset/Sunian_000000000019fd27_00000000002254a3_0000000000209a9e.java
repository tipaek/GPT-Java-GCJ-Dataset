import java.util.Scanner;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        for (int i = 0; i < T; i++) {
            String result = probe(scan, B);
            if (result.equals("N")) {
                return;
            }
        }
    }

    private static String probe(Scanner scan, int B) {
        StringBuilder output = new StringBuilder(B);
        for (int i = 0; i < B; i++) {
            System.out.println(i + 1);
            int answer = Integer.parseInt(scan.nextLine());
            output.append(answer);
        }
        System.out.println(output.toString());
        return scan.nextLine();
    }
}
