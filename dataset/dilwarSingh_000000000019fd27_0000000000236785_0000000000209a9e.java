 
import java.util.Scanner;

public class Solution {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int t = s.nextInt();
        int b = s.nextInt();

        String rep = "Y";
        for (int i = 0; i < t && rep.equals("Y"); i++) {
            if (b == 10) {
                System.out.println(getB10());
                System.out.flush();
                s.nextLine();
                rep = s.nextLine().trim();
            }
        }
    }

    private static String getB10() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = readCharAt(i);

        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x);
        return sb.toString();
    }

    private static int readCharAt(int x) {
        System.out.println(x + 1);
        System.out.flush();
        return s.nextInt();
    }
}
