import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int xCat, yCat;
        int xMe = 0, yMe = 0;
        int nTests;
        int movesLimit;
        int counter = 0;
        String moves;

        Scanner scan = new Scanner(System.in);

        nTests = scan.nextInt();

        for (int i = 0; i < nTests; i++) {
            xCat = scan.nextInt();
            yCat = scan.nextInt();
            moves = scan.next();

            movesLimit = moves.length();

            if (moves.contains("N") || moves.contains("E")) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }

            
        }
    }
}