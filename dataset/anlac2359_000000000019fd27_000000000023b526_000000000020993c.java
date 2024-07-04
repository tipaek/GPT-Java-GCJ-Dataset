import java.util.*;
import java.io.*;
import java.util.Map.Entry;
public class Solution {
    private static boolean findDuplicatesUsingHashMap(int[] inputArray) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : inputArray) {
            map.merge(element, 1, Integer::sum);
        }
        Set<Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = 0;
        int k, r, c;
        int[][] M = new int[101][101];
        int[] temp;

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }

            k = 0;
            for (int i = 0; i < N; i++) {
                k += M[i][i];
            }

            temp = new int[N];
            r = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[j] = M[i][j];
                }
                if (findDuplicatesUsingHashMap(temp))
                    r++;
            }

            c = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[j] = M[j][i];
                }
                if (findDuplicatesUsingHashMap(temp))
                    c++;
            }

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }
}