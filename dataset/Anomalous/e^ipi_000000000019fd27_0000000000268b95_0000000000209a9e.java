import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int B = sc.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int queries = 0;
            StringBuilder prefix = new StringBuilder();
            StringBuilder postfix = new StringBuilder();

            if (queries == 0) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + 1);
                    queries++;
                    prefix.append(sc.nextInt());
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println(B - i);
                    queries++;
                    postfix.insert(0, sc.nextInt());
                }
            }

            System.out.println(prefix.toString() + postfix.toString());
            sc.nextLine(); // Consume the newline
            sc.nextLine(); // Consume the extra newline
        }
    }
}