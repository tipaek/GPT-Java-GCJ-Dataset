import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        int minimum = scanner.nextInt();
        int maximum = scanner.nextInt();
        long size = (long) Math.pow(10, 9);
        for (int i = 1; i <= cases; i++) {
            long Xborder = binarySearchX(size - 2*(size-maximum), size, scanner);
            long Yborder = binarySearchY(size - 2*(size-maximum), size, scanner);
            Response r = getVerdict(Xborder - maximum, Yborder-maximum, scanner);
            if (r != Response.CENTER) {
                return;
            }
        }

    }

    static long binarySearchY(long start, long stop, Scanner scanner) {
        long newVal = (start+stop)/2;
        if (getVerdict(0, newVal, scanner)== Response.HIT) {
            if (getVerdict(0, newVal+1, scanner) == Response.MISS) {
                return newVal;
            }
            return binarySearchY(newVal, stop, scanner);
        }
        return binarySearchY(start, newVal, scanner);
    }

    static long binarySearchX(long start, long stop, Scanner scanner) {
        long newVal = (start+stop)/2;
        if (getVerdict(newVal, 0, scanner)== Response.HIT) {
          if (getVerdict(newVal+1, 0, scanner) == Response.MISS) {
              return newVal;
          }
          return binarySearchX(newVal, stop, scanner);
        }
        return binarySearchX(start, newVal, scanner);
    }

    static  Response getVerdict(long coordX, long coordY, Scanner scanner) {
        System.out.println(coordX+" "+coordY);
        System.out.flush();
        String result = scanner.nextLine();
        return Response.valueOf(result);
    }


enum Response {
      HIT,
    CENTER,
    MISS,
    WRONG,
}
}
