import java.util.Scanner;

public class Indicium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- != 0) {
            String s = scanner.nextLine();
            int cas = 1;
            String[] parts = s.split(" ");
            int n = Integer.parseInt(parts[0]);
            int rtrace = Integer.parseInt(parts[1]);
            int f = 1;

            switch (n) {
                case 2:
                    if (rtrace == 2 || rtrace == 4)
                        f = 0;
                    break;
                case 3:
                    if (rtrace == 3 || rtrace == 6 || rtrace == 9)
                        f = 0;
                    break;
                case 4:
                    if (rtrace == 4 || rtrace == 8 || rtrace == 12 || rtrace == 16)
                        f = 0;
                    break;
                case 5:
                    if (rtrace == 5 || rtrace == 10 || rtrace == 15 || rtrace == 20 || rtrace == 25)
                        f = 0;
                    break;
            }

            if (f == 0)
                System.out.println("Case #" + cas + ": POSSIBLE");
            else
                System.out.println("Case #" + cas + ": IMPOSSIBLE");

            cas++;
        }
        scanner.close();
    }
}