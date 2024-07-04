import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        for (int c = 1; c <= cases; c++) {


            int r = scanner.nextInt();
            int s = scanner.nextInt();


            List<int[]> result = new ArrayList<>();


            for (int i = r; i > 1; i--) {
                for (int j = 1; j < s; j++) {
                    int b = s * i - j - i;
                    result.add(new int[]{i, b});
                }
            }

            System.out.println("Case #" + c + ": " + result.size());
            for (int i = 0; i < result.size(); i++) {
                int[] el = result.get(i);
                System.out.print(el[0] + " " + el[1]);
                if (i < result.size() - 1) {
                    System.out.println();
                }
            }
            if (c < cases) {
                System.out.println();
            }
        }

    }
}