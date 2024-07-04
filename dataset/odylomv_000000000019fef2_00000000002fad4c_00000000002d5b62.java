import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {
    static BigInteger x, y;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int loops = 1; loops <= t; ++loops) {
            //Input
            x = in.nextBigInteger();
            y = in.nextBigInteger();

            //Solution
//            ArrayList<BigInteger> possibleX = new ArrayList<>();
//            ArrayList<BigInteger> possibleY = new ArrayList<>();
//            for (int i = 0; BigInteger.valueOf(2).pow(i).compareTo(x.abs()) < 0; i++) {
//                possibleX.add(BigInteger.valueOf(2).pow(i));
//            }
//            for (int i = 0; BigInteger.valueOf(2).pow(i).compareTo(y.abs()) < 0; i++) {
//                possibleY.add(BigInteger.valueOf(2).pow(i));
//            }
//            System.out.println(possibleX);
            String result = findBest(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE, "");

            if (result.equals(""))
                result = "IMPOSSIBLE";



            //Result
            System.out.println("Case #" + loops + ": " + result);
        }
    }

    public static String findBest(BigInteger currX, BigInteger currY,BigInteger size, String previous) {
        if (currX.compareTo(x.abs()) > 0 || currY.compareTo(y.abs()) > 0 || size.compareTo(x.max(y).multiply(BigInteger.valueOf(4)).abs()) > 0)
            return "";

        if (currY.equals(y) && currX.equals(x))
            return previous;

//        System.out.print(currX);
//        System.out.print(" ");
//        System.out.println(currY);
        String up = findBest(currX, currY.add(size), BigInteger.valueOf(2).multiply(size), previous + "N");
        String down = findBest(currX, currY.subtract(size), BigInteger.valueOf(2).multiply(size), previous + "S");
        String right = findBest(currX.add(size), currY, BigInteger.valueOf(2).multiply(size), previous + "E");
        String left = findBest(currX.subtract(size), currY, BigInteger.valueOf(2).multiply(size), previous + "W");
        String[] moves = { up, down, right, left};
        int minSize = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (!moves[i].equals("") && moves[i].length() < minSize) {
                minSize = moves[i].length();
                minIndex = i;
            }
        }

        if (minIndex != -1)
            return moves[minIndex];

        return "";
    }
}