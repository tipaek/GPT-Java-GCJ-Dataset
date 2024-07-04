import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        for (int i = 0; i < testCases; i++) {
            int R = sc.nextInt();
            int S = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            int moveCount = 0;
            List<String> output = new ArrayList<>();

            for (int j = 1; j < S; j++) {
                int a = R * j;
                output.add(a + " " + (R - 1));
                moveCount++;
                
                for (int k = R; k > 2; k--) {
                    int e = k - 1;
                    int m = (j == 1) ? (k - 2) : (j * (R - 1)) - (R - k);
                    output.add(e + " " + m);
                    moveCount++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + moveCount);
            for (String line : output) {
                System.out.println(line);
            }
        }
    }
}