import java.util.Scanner;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            System.out.println("Case #" + i +  ": " + ( (R-1) * (S-1) ));
            int N = R*S;
            int trie = 1;
            for (int j = 1; j < R; j++) {
                for (int k = 1; k < S; k++) {
                    int b = R - j;
                    int a = N - b - trie;
                    System.out.println(a + " " + b);
                    trie ++;
                }
                trie ++;
            }
        }
    }
}
