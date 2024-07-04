import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int B = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int[] array = new int[B];
            Integer samePos = null;
            Integer sameVal = null;
            Integer differentPos = null;
            Integer differentVal = null;
            int queryCount = 0;
            int toCheck = 0;
            int value;
            boolean finalSameStayed = true;
            boolean finalDifferentStayed = true;
            while (toCheck != B / 2) {
                ++queryCount;
                if (queryCount % 10 == 1 && queryCount != 1) {

                    //burn two queries and check what happened to both cases
                    if (samePos != null) {
                        ++queryCount;
                        query(samePos);
                        value = in.nextInt();
                        finalSameStayed = value == sameVal;
                    } else {
                        ++queryCount;
                        query(0);
                        in.nextInt();
                    }
                    if (differentPos != null) {
                        ++queryCount;
                        query(differentPos);
                        value = in.nextInt();
                        finalDifferentStayed = value == differentVal;
                    } else {
                        ++queryCount;
                        query(0);
                        in.nextInt();
                    }
                }
                query(toCheck);
                value = in.nextInt();
                array[toCheck] = value;
                ++queryCount;
                query(B - 1 - toCheck);
                value = in.nextInt();
                array[B - 1 - toCheck] = value;
                if (array[toCheck] != array[B - 1 - toCheck]) {
                    if (!finalDifferentStayed) {
                        array[toCheck] = 1 - array[toCheck];
                        array[B - 1 - toCheck] = 1 - array[B - 1 - toCheck];
                    }
                    differentPos = toCheck;
                    differentVal = array[toCheck];
                } else {
                    if (!finalSameStayed) {
                        array[toCheck] = 1 - array[toCheck];
                        array[B - 1 - toCheck] = 1 - array[B - 1 - toCheck];
                    }
                    samePos = toCheck;
                    sameVal = array[toCheck];
                }
                ++toCheck;
            }
            if (B % 2 == 1) {
                ++queryCount;
                if (queryCount % 10 == 1 && queryCount != 1) {

                    //burn two queries and check what happened to both cases
                    if (samePos != null) {
                        ++queryCount;
                        query(samePos);
                        value = in.nextInt();
                        finalSameStayed = value == sameVal;
                    } else {
                        ++queryCount;
                        query(0);
                        in.nextInt();
                    }
                    if (differentPos != null) {
                        ++queryCount;
                        query(differentPos);
                        value = in.nextInt();
                        finalDifferentStayed = value == differentVal;
                    } else {
                        ++queryCount;
                        query(0);
                        in.nextInt();
                    }
                }
                ++queryCount;
                query(B / 2);
                value = in.nextInt();
                array[B / 2] = value;
            }


            if (finalSameStayed && !finalDifferentStayed) {
                invert(array, toCheck);
            } else if (!finalSameStayed && finalDifferentStayed) {
                invert(array, toCheck);
                flip(array, toCheck);
            } else if (!finalSameStayed) {
                flip(array, toCheck);
            }

            for (int b : array) {
                System.out.print(b);
            }
            System.out.println();
            char c = in.next().charAt(0);
            if (c != 'Y') {
                throw new RuntimeException();
            }
        }
    }

    static void invert(int[] array, int toCheck) {
        for (int i = 0; i < toCheck; ++i) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    static void flip(int[] array, int toCheck) {
        for (int i = 0; i < toCheck; ++i) {
            array[i] = 1 - array[i];
            array[array.length - 1 - i] = 1 - array[array.length - 1 - i];
        }
    }


    static void query(int i) {
        System.out.println(i + 1);
    }
}
