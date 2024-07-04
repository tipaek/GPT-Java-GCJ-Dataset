import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//public class GuessA {
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = in.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        //System.out.println("T: " + T);
        //System.out.println("B: " + B);

        for (int i = 1; i <= T; ++i) {

            StringBuffer buffer = new StringBuffer();
            for(int g = 1; g <= B; g++) {
                System.out.println(g);
                System.out.flush();

                String answer = in.nextLine();
                buffer.append(answer);
            }

            System.out.println(buffer.toString());
            System.out.flush();

            String result = in.nextLine();
            if ("N".equalsIgnoreCase(result)) {
                System.exit(0);
            }
        }
        System.exit(0);
    }
}
