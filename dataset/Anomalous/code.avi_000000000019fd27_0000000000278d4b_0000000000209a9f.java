import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            int len = s.length();
            boolean isOneOpen = false;
            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < len; j++) {
                char currentChar = s.charAt(j);
                if (currentChar == '1') {
                    if (!isOneOpen) {
                        System.out.print("(");
                        isOneOpen = true;
                    }
                } else {
                    if (isOneOpen) {
                        System.out.print(")");
                        isOneOpen = false;
                    }
                }
                System.out.print(currentChar);
            }

            if (isOneOpen) {
                System.out.print(")");
            }
            System.out.println();
        }
        sc.close();
    }
}