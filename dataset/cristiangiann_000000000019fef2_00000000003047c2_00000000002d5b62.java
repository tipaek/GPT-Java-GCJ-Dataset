import java.util.Scanner;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int counter = 0; counter < n; counter++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int length = (int)(Math.ceil(Math.log(Math.max(Math.abs(x),Math.abs(y)))) / Math.log(2)) + 2;
            int[][] array = null;
            if((x + y) % 2 != 0) array = scomponiNum(x, y, length);
            System.out.print("Case #" + (counter + 1) + ": ");

            if(array != null) {
                printArray(array);
            } else{
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 1) System.out.print("E");
            if (array[i][0] == -1) System.out.print("W");
            if (array[i][1] == 1) System.out.print("N");
            if (array[i][1] == -1) System.out.print("S");
        }
        System.out.println();
    }

    private static int[][] scomponiNum(int x, int y, int length) {
        int[][] xArray = new int[length][2];
        return scomponiNumero(xArray, length -1, 0, 0, x, y);
    }

    private static int[][] scomponiNumero(int[][] array, int index, int sumx, int sumy, int x, int y) {
        if(sumx == x && sumy == y) return array;
        if(index < 0) return null;
        int pow = (int)Math.pow(2, index);
        int[][] result = null;

        if(sumx == 0 && sumy == 0) {
            array[index][0] = 0;
            array[index][1] = 0;
            result = scomponiNumero(array, index - 1, sumx, sumy, x, y);
            if (result != null) return array;
        }

        array[index][0] = -1;
        array[index][1] = 0;
        result = scomponiNumero(array, index - 1, sumx - pow, sumy, x, y);
        if (result != null) return array;

        array[index][0] = 1;
        array[index][1] = 0;
        result = scomponiNumero(array, index - 1, sumx + pow, sumy, x, y);
        if (result != null) return array;

        array[index][0] = 0;
        array[index][1] = 1;
        result = scomponiNumero(array, index - 1, sumx, sumy + pow, x, y);
        if (result != null) return array;

        array[index][0] = 0;
        array[index][1] = -1;
        result = scomponiNumero(array, index - 1, sumx, sumy - pow, x, y);
        if (result != null) return array;
        else return null;
    }

}
