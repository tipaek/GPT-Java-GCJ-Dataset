import java.util.Scanner;

public class Solution {

    private static boolean runTest(int A, int B, Scanner scanner) {

        int segs[] = new int[(2*(int)Math.pow(10,9))/B];
        int LEFT = - (int)(Math.pow(10,9));
        int RIGHT = -LEFT;
        int i = 0;
        while(LEFT < RIGHT) {
            segs[i++] = LEFT + B;
        }

        int hitX, hitY;
        for(int x=0; x<segs.length; x++) {
            for(int y=0; y<segs.length; y++) {
                System.out.println(segs[x] + " " + segs[y]);
                System.out.flush();
                String resp = scanner.nextLine();
                if(resp.equalsIgnoreCase("CENTER")) {
                    return true;
                } else if(resp.equalsIgnoreCase("HIT")) {
                    hitX = x;
                    hitY = y;
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long beginTime = System.nanoTime();
        try (Scanner scanner = new Scanner(System.in)) {
            int testCount = scanner.nextInt();
            int bitCount = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                if (!runTest(A, B, scanner)) break;
            }
        }
    }
}