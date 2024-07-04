
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        byte caseCount = sc.nextByte();
        byte index = 0;
        byte[][] matrix = new byte[100][100];
        int[] exists = new int[100];
        short k = 0;
        byte r = 0;
        byte c = 0;
        while (index < caseCount) {
            k = r = c = 0;
            index++;
            byte n = sc.nextByte();
            for (int i = 0; i < n; i++) {
                int flag = i + 1;
                boolean r_flag = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextByte();
                    if (!r_flag && exists[matrix[i][j]] == flag) {
                        r++;
                        r_flag = true;
                    } else {
                        exists[matrix[i][j]] = flag;
                    }
                    if (i == j) {
                        k += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int flag = n + i + 1;
                for (int j = 0; j < n; j++) {
                    if (exists[matrix[j][i]] == flag) {
                        c++;
                        break;
                    } else {
                        exists[matrix[j][i]] = flag;
                    }
                }
            }
            for (int i = 0; i < 100; i++) {
                exists[i] = 0;
            }

            System.out.printf("Case #%d: %d %d %d\n", index, k, r, c);
        }
        sc.close();
    }
}
