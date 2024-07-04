import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        while (t-- > 0) {
            char judge = 'A';
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < b; i++) {
                System.out.println(i+1);
                ans.append(scanner.nextInt());
            }
            System.out.println(ans.toString());
            scanner.next();
        }
    }
}
