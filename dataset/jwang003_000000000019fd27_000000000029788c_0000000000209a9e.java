import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] info = in.nextLine().split(" ");
        int cases = Integer.parseInt(info[0]);
        int size = Integer.parseInt(info[1]);
        for (int i = 0; i < cases; i++) {
            if (size == 10) {
                StringBuilder bitArray = new StringBuilder();
                for (int j = 1; j <= 10; j++) {
                    System.out.println(j);
                    bitArray.append(Integer.parseInt(in.nextLine()));
                }
                System.out.println(bitArray.toString());
                if (in.nextLine().equals("Y")) {
                    continue;
                } else {
                    System.out.println("Wrong Answer");
                }
            } else if (size == 20) {

            } else {

            }
        }
    }
}
