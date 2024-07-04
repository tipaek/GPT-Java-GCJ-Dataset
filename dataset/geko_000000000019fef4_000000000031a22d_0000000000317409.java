import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int xCat, yCat;
        int xMe, yMe;
        int nTests;
        String moves;

        Scanner scan = new Scanner(System.in);

        nTests = scan.nextInt();

        for (int i = 0; i < nTests; i++) {
            xCat = scan.nextInt();
            yCat = scan.nextInt();
            moves = scan.next();

            if (moves.contains("N") || moves.contains("E")) {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
        }

    }
}