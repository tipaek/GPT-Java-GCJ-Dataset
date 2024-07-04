/**
 * Created by kareem on 3/22/2020.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kareem on 3/19/2020.
 */
public class Solution {

    static int r, c, req;
    static int[][] arr;


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        for (int i = 1; i <= testCases; i++) {
            r = s.nextInt();
            c = s.nextInt();
//            req = s.nextInt();
            arr = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    arr[j][k] = s.nextInt();
                }
            }

            testCase(i);
        }

    }

    static long clacRound(HashMap<String, Integer> map) {
        long value = 0;
        for (int v : map.values()) {
            value += v;
        }
        return value;
    }


    static boolean toRemove(HashMap<String, Integer> map, int i, int j) {
        int count = 0;
        int value = 0;
        int var = i;
        while (var - 1 >= 0) {
            if (map.containsKey((var - 1) + ":" + j)) {
                count++;
                value += arr[var - 1][j];
                break;
            }
            var --;
        }
        var = i;
        while (var + 1 < r) {
            if (map.containsKey((var + 1) + ":" + j)) {
                count++;
                value += arr[var + 1][j];
                break;
            }
            var++;
        }
        var = j;
        while (var - 1 >= 0) {
            if (map.containsKey(i + ":" + (var - 1))) {
                count++;
                value += arr[i][var - 1];
                break;
            }
            var --;
        }
        var = j;
        while (var + 1 < c) {

            if (map.containsKey(i + ":" + (var + 1))) {
                count++;
                value += arr[i][var + 1];
                break;
            }
                var++;

        }
        if (count != 0) {
            if ((double)arr[i][j] < (double) value / (double)count) {
                return true;
            }
        }
        return false;
    }

    static void testCase(int caseNum) {


        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map.put(i + ":" + j, arr[i][j]);
            }
        }
        long res = 0;
        long check = res;
        long lastRound = -1;


        while (true) {
            check = clacRound(map);

            List<String> toRemove = new ArrayList<String>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map.containsKey(i + ":" + j)) {
                        if (toRemove(map, i, j)) {
                            toRemove.add(i + ":" + j);
                        }
                    }

                }
            }

            for(String s  : toRemove){
                map.remove(s);
            }

            toRemove = null;
            if(check == lastRound) break;
            lastRound = check;
            res += check;

        }

        System.out.println("Case #" + caseNum + ": " + res);
    }

}