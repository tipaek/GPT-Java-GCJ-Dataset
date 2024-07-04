import java.util.*;

public class Solution {

    // B = 10
    public static void solveTS1(Scanner sc) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            // 1-indexed
            System.out.println(i + 1);
            sb.append(sc.nextInt());
        }

        System.out.println(sb.toString());
        if (sc.next().equals("N")) {
            System.exit(0);
        }
     }

    // B = 20
    public static void solveTS2(Scanner sc) {
        // classes[0] is ignored
        Boolean[] classes = new Boolean[21];

        for (int i = 1; i <= 10; i++) {
            // 1-indexed
            int b = read(sc, i);
            classes[i] = b == 1;
        }

        int ref = read(sc, 10);
        for (int i = 11; i <= 19; i++) {
            int b = read(sc, i);
            classes[i] = ref == b ? classes[10] : !classes[10];
        }

        ref = read(sc, 19);
        int b = read(sc, 20);
        classes[20] = ref == b ? classes[19] : !classes[19];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < classes.length; i++) {
            sb.append(classes[20] == classes[i] ? b : 1 - b);
        }

        System.out.println(sb.toString());
        if (sc.next().equals("N")) {
            System.exit(0);
        }
    }

    // B = 100
    public static void solveTS3(Scanner sc) {
        System.exit(0);
    }

    public static int read(Scanner sc, int i) {
        System.out.println(i);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            int B = sc.nextInt();
            for (int t = 0; t < T; t++) {
                if (B == 10) {
                    solveTS1(sc);
                } else if (B == 20) {
                    solveTS2(sc);
                } else {
                    solveTS3(sc);
                }
            }
        }
    }
}
