import java.util.Scanner;

public class Solution {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int t = s.nextInt();
        int b = s.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println(getB10());
        }
    }

    private static String getB10() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = s.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x);
        return sb.toString();
    }
}
