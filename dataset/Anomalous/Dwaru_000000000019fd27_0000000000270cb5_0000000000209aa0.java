import java.util.Scanner;

public class Indicium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int cas = 1; cas <= t; cas++) {
            String s = scanner.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int rtrace = Integer.parseInt(s.split(" ")[1]);
            boolean possible = false;

            switch (n) {
                case 2:
                    if (rtrace == 2 || rtrace == 4) possible = true;
                    break;
                case 3:
                    if (rtrace == 3 || rtrace == 6 || rtrace == 9) possible = true;
                    break;
                case 4:
                    if (rtrace == 4 || rtrace == 8 || rtrace == 12 || rtrace == 16) possible = true;
                    break;
                case 5:
                    if (rtrace == 5 || rtrace == 10 || rtrace == 15 || rtrace == 20 || rtrace == 25) possible = true;
                    break;
            }

            if (possible)
                System.out.println("Case #" + cas + ": POSSIBLE");
            else
                System.out.println("Case #" + cas + ": IMPOSSIBLE");
        }

        scanner.close();
    }
}