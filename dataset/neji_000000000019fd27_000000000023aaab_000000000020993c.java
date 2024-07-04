
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            int duplicateRow = 0, duplicateColumn = 0;
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int order = scanner.nextInt();
                int[][] input = new int[order][order];
                int diagSum = 0;

                for (int i = 0; i < order; i++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    boolean containDuplicate = false;
                    for (int j = 0; j < order; j++) {
                        input[i][j] = scanner.nextInt();
                        if (!containDuplicate) {
                            if (map.get(input[i][j]) != null) {
                                containDuplicate = true;
                            } else {
                                map.put(input[i][j], 1);
                            }
                        }
                        if (i == j) {
                            diagSum += input[i][j];
                        }
                    }
                    if (containDuplicate) {
                        duplicateRow++;
                    }
                }
                for (int i = 0; i < order; i++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    boolean containDuplicate = false;
                    for (int j = 0; j < order; j++) {
                        if (!containDuplicate) {
                            if (map.get(input[j][i]) != null) {
                                containDuplicate = true;
                            } else {
                                map.put(input[j][i], 1);
                            }
                        }
                        if (containDuplicate) {
                            duplicateColumn++;
                        }
                    }
                }
                System.out.println("Case #" + testNumber + ": " + diagSum + " " + duplicateRow + " " + duplicateColumn);
            }
        } catch (Exception e) {

        }
    }

}