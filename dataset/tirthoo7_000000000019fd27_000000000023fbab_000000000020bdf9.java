/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.io.*;

/**
 *
 * @author EliteBook
 */
public class Solution2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            getResult(i);
        }
    }

    public static void getResult(int tc) {
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        int[][] sortedMat = mat.clone();
        char person = 'J';

        char[] chars = new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impo = false;

        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();

            }
            map.put(mat[i], i);

        }
        Arrays.sort(sortedMat, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < sortedMat.length; i++) {
            chars[map.get(sortedMat[i])] = person;
            if (i < sortedMat.length - 1 && isOverlap(sortedMat[i], sortedMat[i + 1])) {
                if (person == 'J') {
                    JStack.push(sortedMat[i]);
                    person = getperson(person);

                    if (!CStack.isEmpty() && isOverlap(CStack.peek(), sortedMat[i + 1])) {
                        impo = true;
                        break;
                    }
                } else {
                    CStack.push(sortedMat[i]);
                    person = getperson(person);

                    if (!JStack.isEmpty() && isOverlap(JStack.peek(), sortedMat[i + 1])) {
                        impo = true;
                        break;
                    }

                }
            } else {

                if (person == 'J') {
                    JStack.push(sortedMat[i]);
                } else {
                    CStack.push(sortedMat[i]);
                }
            }

        }
        System.out.println("Case #" + tc + ": " + (impo ? "IMPOSSIBLE" : new String(chars)));
    }

    private static char getperson(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean isOverlap(int[] fa, int[] sa) {
        return fa[1] > sa[0];
    }
}
