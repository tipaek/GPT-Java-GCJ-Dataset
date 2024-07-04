import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static final int MAX_SIZE = 32;
    private static int[][] combo;

    public static void main(String[] args) {
        initializeCombo();
        Scanner stdin = new Scanner(System.in);
        int nC = stdin.nextInt();

        for (int loop = 1; loop <= nC; loop++) {
            int n = stdin.nextInt();
            System.out.println("Case #" + loop + ":");
            processCase(n);
        }
    }

    private static void initializeCombo() {
        combo = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            combo[i][0] = 1;
            combo[i][i] = 1;
        }
        for (int i = 2; i < MAX_SIZE; i++) {
            for (int j = 1; j < i; j++) {
                combo[i][j] = combo[i - 1][j - 1] + combo[i - 1][j];
            }
        }
    }

    private static void processCase(int n) {
        if (n < 500) {
            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + " " + 1);
            }
        } else {
            handleLargeCase(n);
        }
    }

    private static void handleLargeCase(int n) {
        int sub = n - 35;
        if (sub % 2 == 1) sub--;

        ArrayList<Integer> locs = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if ((sub & (1 << i)) != 0) {
                locs.add(i);
            }
        }

        ArrayList<Integer> places = new ArrayList<>();
        places.add(1001);

        for (int loc : locs) {
            int prev = places.get(places.size() - 1);
            int pR = prev / 1000;
            int pC = prev % 1000;
            int nextRow = loc + 1;

            if (pC == 1) {
                for (int j = pR + 1; j <= nextRow; j++) {
                    places.add(1000 * j + 1);
                }
                for (int j = 2; j <= nextRow; j++) {
                    places.add(1000 * nextRow + j);
                }
            } else {
                for (int j = pR + 1; j <= nextRow; j++) {
                    places.add(1000 * j + j);
                }
                for (int j = nextRow - 1; j >= 1; j--) {
                    places.add(1000 * nextRow + j);
                }
            }
        }

        int sum = places.stream().mapToInt(code -> combo[code / 1000 - 1][code % 1000 - 1]).sum();
        int need = n - sum;
        int lastCode = places.get(places.size() - 1);
        int cR = lastCode / 1000;
        int cC = lastCode % 1000;

        if (cC == 1) {
            for (int i = 0; i < need; i++) {
                places.add(1000 * (cR + i + 1) + 1);
            }
        } else {
            for (int i = 0; i < need; i++) {
                places.add(1000 * (cR + i + 1) + (cR + i + 1));
            }
        }

        for (int code : places) {
            int r = code / 1000;
            int c = code % 1000;
            System.out.println(r + " " + c);
        }
    }
}