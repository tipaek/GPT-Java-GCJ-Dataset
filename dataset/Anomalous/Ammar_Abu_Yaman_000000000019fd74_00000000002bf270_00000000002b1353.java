import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tt = scanner.nextInt();
        int qv = 1;

        while (qv <= tt) {
            int num = scanner.nextInt();

            System.out.printf("Case #%d:%n", qv);

            if (num == 501) {
                for (int i = 1; i < 500; i++) {
                    if (i == 3) {
                        System.out.println(3 + " " + 2);
                        System.out.println(3 + " " + 1);
                    } else {
                        System.out.println(i + " " + 1);
                    }
                }
            } else {
                for (int i = 1; i <= num; i++) {
                    System.out.println(i + " " + 1);
                }
            }

            qv++;
        }
        scanner.close();
    }
}