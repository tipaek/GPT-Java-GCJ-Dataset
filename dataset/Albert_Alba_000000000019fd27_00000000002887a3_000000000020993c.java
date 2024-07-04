
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> hashSet;

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int size = sc.nextInt();
            int[][] arr = new int[size][size];
            for (int a = 0; a < size; a++) {
                for (int b = 0; b < size; b++) {
                    arr[a][b] = sc.nextInt();
                }
            }
            System.out.print("Case #" + (i + 1) + ": ");

            int sum = 0;
            for (int a = 0; a < size; a++) {
                sum += arr[a][a];
            }
            System.out.print(sum + " ");

            int gR = 0;
            for (int a = 0; a < size; a++) {
                hashSet = new HashSet<>();
                for (int b = 0; b < size; b++) {
                    hashSet.add(arr[a][b]);
                }
                if (hashSet.size() != size) {
                    gR += 1;
                }
            }
            System.out.print(gR + " ");

            int gV = 0;
            for (int a = 0; a < size; a++) {
                hashSet = new HashSet<>();
                for (int b = 0; b < size; b++) {
                    hashSet.add(arr[b][a]);
                }
                if (hashSet.size() != size) {
                    gV += 1;
                }
            }
            System.out.print(gV);
        }
    }
}
