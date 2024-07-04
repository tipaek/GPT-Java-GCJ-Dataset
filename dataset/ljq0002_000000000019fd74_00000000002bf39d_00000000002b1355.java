import java.util.*;
import java.io.*;

public class Solution {

    public static int sum(int[][] data) {
        int sum = 0;
        for (int[] d : data) {
            for (int n : d) {
                sum += n;
            }
        }
        return sum;
    }

    public static int cal(int[][] data) {
        int sum = sum(data);
        int pre = sum;
        Queue<int[]> q = new LinkedList<>();
        while (true) {
            int delta = 0;
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    int cur = data[i][j];
                    if(cur <= 0) continue;
                    int count = 0;
                    int subSum = 0;
                    int ptr = j - 1;
                    while (ptr >= 0 && data[i][ptr] <= 0) ptr--;
                    if (ptr >= 0) {
                        count++;
                        subSum += data[i][ptr];
                    }
                    ptr = j + 1;
                    while (ptr < data[0].length && data[i][ptr] <= 0) ptr++;
                    if (ptr < data[0].length) {
                        count++;
                        subSum += data[i][ptr];
                    }
                    ptr = i - 1;
                    while (ptr >= 0 && data[ptr][j] <= 0) ptr--;
                    if (ptr >= 0) {
                        count++;
                        subSum += data[ptr][j];
                    }
                    ptr = i + 1;
                    while (ptr < data.length && data[ptr][j] <= 0) ptr--;
                    if (ptr < data.length) {
                        count++;
                        subSum += data[ptr][j];
                    }
                    if (cur * count < subSum) {
                        delta += data[i][j];
                        q.offer(new int[]{i, j});
                    }
                }
            }
            if (q.isEmpty()) {
                break;
            }
            while (!q.isEmpty()) {
                int[] cor = q.poll();
                data[cor[0]][cor[1]] = -data[cor[0]][cor[1]];
            }
            sum += pre - delta;
            pre = pre - delta;
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] data = new int[R][C];
            for (int p = 0; p < R; p++) {
                for (int q = 0; q < C; q++) {
                    data[p][q] = sc.nextInt();
                }
            }
            int res = cal(data);
            System.out.println("Case #" + i + ": " + res);
        }
    }
}