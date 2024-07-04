import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        int T = Integer.valueOf(inputs[0]);
        int B = Integer.valueOf(inputs[1]);
        for (int i = 0; i < T; i++) {

            int[] array = new int[B];
            for (int query = 1; query <= 10; query++) {
                System.out.println(query);
                String response = scanner.nextLine();
                array[query - 1] = Integer.valueOf(response);
            }

            String answer = Arrays.toString(array).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
            System.out.println(answer);
            String judge = scanner.nextLine();
            if (judge.equals("N")) {
                System.exit(0);
            }
        }
    }
}
