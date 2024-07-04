
import java.util.Scanner;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < B; j++) {
                System.out.println(j + 1);
                System.out.flush();
                sb.append(input.nextInt());

            }

            System.out.println(sb.toString());
            System.out.flush();
            input.next();

        }
    }
}
