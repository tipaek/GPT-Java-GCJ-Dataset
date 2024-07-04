import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int row = 0, column = 0, sum = 0;
            int arr[][] = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    arr[j][k] = scanner.nextInt();
                    if (j == k){
                        sum += arr[j][k];
                    }
                }
            }
            for (int j = 0; j < size; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    if (hashSet.contains(arr[k][j])){
                        column++;
                        break;
                    }
                    hashSet.add(arr[k][j]);
                }
            }
            for (int j = 0; j < size; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    if (hashSet.contains(arr[j][k])){
                        row++;
                        break;
                    }
                    hashSet.add(arr[j][k]);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sum + " " + row + " " + column);
        }
    }
}
