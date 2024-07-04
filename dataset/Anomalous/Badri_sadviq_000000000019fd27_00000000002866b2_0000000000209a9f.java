import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // Consume the newline

        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            int len = str.length();
            char[] ch = new char[len];
            str.getChars(0, len, ch, 0);

            for (int j = 0; j < len; j++) {
                if (ch[j] == 0) {
                    System.out.println("(" + ch[j] + ")");
                    j++;
                }
                if (j < len) {
                    System.out.print(ch[j]);
                }
            }
            System.out.println();  // Print a newline after each string
        }
        sc.close();
    }
}