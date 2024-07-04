import java.util.Scanner;

class Solution {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int z = 1; z <= T; z++) {
            int k = getRandomNumInRange(0, 2);
            System.out.println("Case #" + z + ": " + k);
        }
    }

    private static int getRandomNumInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("IMPOSSIBLE");
        }
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}