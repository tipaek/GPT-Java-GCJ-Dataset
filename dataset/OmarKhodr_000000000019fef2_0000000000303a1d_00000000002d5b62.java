import java.util.*;

public class Solution {

    public static int binary(int decimalNumber, int[] binary) {
        //initialize array
        if (decimalNumber < 0) decimalNumber = -decimalNumber;

        // declare the decimal number to be converted to binary
        int index = 0;
        // loop till the number is greater than 0
        while (decimalNumber > 0) {
            // divide the number by 2 using modulus operator so that we get the remainder
            int remainder = decimalNumber % 2;
            // store the remainder in array
            binary[index++] = remainder;
            // divide the number to get the quotient and assign it back to the number
            decimalNumber = decimalNumber / 2;
        }
        // loop over the array backwards and print the binary number
        return index;
    }

    public static int[] xor(int[] x, int[] y) {
        int[] res = new int[x.length];
        for (int i=0; i<res.length; i++) {
            res[i] = x[i] ^ y[i];
        }
        return res;

    }

    public static int[] twoComp(int[] x) {
        int[] res = new int[x.length];
        boolean seenOne = false;
        for (int i=0; i<x.length; i++) {
            if (seenOne) res[i] = x[i] == 0 ? 1 : 0;
            else res[i] = x[i];
            if (x[i] == 1) seenOne = true;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] dir = {'N', 'E', 'S', 'W'};
        // 0: N, 1: E, 2: S, 3: W
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int q=1; q<=t; q++) {
            int x = in.nextInt(), y = in.nextInt();
//            System.out.println(x + " " + y);
            int[] X = new int[21];
            int sizex = binary(x, X);
            int[] Y = new int[21];
            int sizey = binary(y, Y);

            int size = Math.max(sizex, sizey)+1;
            int[] binX = new int[size], binY = new int[size];
            for (int i=0; i<size; i++) {
                binX[i] = X[i];
                binY[i] = Y[i];
            }

            int[] inverseOnlyBinX = new int[size-1];
            for (int i=0; i<size-1; i++) {
                inverseOnlyBinX[i] = binX[i] == 1 ? 0 : 1;
            }

            int[] onlyBinY = new int[size-1];
            for (int i=0; i<size-1; i++) {
                onlyBinY[i] = binY[i];
            }

            //BINARY IS REVERSED !!!!

            int[] twoCompX = twoComp(binX), twoCompY = twoComp(binY);

            int[] allOnes = new int[size];
            for (int i=0; i<size; i++) {
                allOnes[i] = 1;
            }
            int[] inverseX = xor(binX, allOnes);
            int[] inverseXComp = xor(twoCompX, allOnes);

            int up = y > 0 ? 0: 2;
            int right = x > 0 ? 1 : 3;
            int down = y > 0 ? 2: 0;
            int left = x > 0 ? 3: 1;


            StringBuilder res = new StringBuilder();
            if (Arrays.equals(inverseX, binY) || Arrays.equals(inverseOnlyBinX, onlyBinY)) {
                for (int i=0; i<size-1; i++) {
                    if (inverseOnlyBinX[i] == 0) res.append(dir[right]);
                    else res.append(dir[up]);
                }
                System.out.println("Case " + q + "#: " + res);
            }
            else if (Arrays.equals(inverseX, twoCompY)) {
                for (int i=0; i<size; i++) {
                    if (binX[i] == 1) res.append(dir[right]);
                    else if (i == size-1) res.append(dir[up]);
                    else res.append(dir[down]);
                }
                System.out.println("Case " + q + "#: " + res);
            }
            else if (Arrays.equals(inverseXComp, binY)) {
                for (int i=0; i<size; i++) {
                    if (binY[i] == 1) res.append(dir[up]);
                    else if (i == size-1) res.append(dir[right]);
                    else res.append(dir[left]);
                }
                System.out.println("Case " + q + "#: " + res);
            }
            else if (Arrays.equals(inverseXComp, twoCompY)) {
                for (int i=0; i<size; i++) {
                    if (twoCompX[i] == 1 && i != size-1) res.append(dir[left]);
                    else if (twoCompX[i] == 1 && i == size-1) res.append(dir[right]);
                    else if (twoCompX[i] == 0 && i != size-1) res.append(dir[down]);
                    else if (twoCompX[i] == 0 && i == size-1) res.append(dir[up]);
                }
                System.out.println("Case " + q + "#: " + res);
            }
            else {
                System.out.println("Case " + q + "#: IMPOSSIBLE");
            }

        }
    }

}

/*
4
2 3
-2 -3
3 0
-1 1

* */
