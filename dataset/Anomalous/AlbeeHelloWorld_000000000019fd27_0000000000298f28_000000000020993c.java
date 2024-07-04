import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = getScanner();
        int T = scan.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int size = scan.nextInt();
            int sumDiag = 0;
            int repeatsRow = 0;
            int repeatsCol = 0;
            HashSet<Integer> hashSet = new HashSet<>();
            ArrayList<Integer> matrix = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    int num = scan.nextInt();
                    if (j == k) {
                        sumDiag += num;
                    }
                    matrix.add(num);
                    hashSet.add(num);
                }
                if (hashSet.size() != size) {
                    repeatsRow++;
                }
                hashSet.clear();
            }

            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    hashSet.add(matrix.get(row * size + col));
                }
                if (hashSet.size() != size) {
                    repeatsCol++;
                }
                hashSet.clear();
            }

            System.out.println("Case #" + i + ": " + sumDiag + " " + repeatsRow + " " + repeatsCol);
        }
    }

    static Scanner getScanner() throws Exception {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }
}