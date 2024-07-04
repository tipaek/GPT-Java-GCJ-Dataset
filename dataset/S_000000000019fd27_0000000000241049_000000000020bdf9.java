
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 1; i <= size; i++) {
            int count = scanner.nextInt();
            String output = "";
            int[] C = new int[60*24 + 1];
            int[] J = new int[60*24 + 1];
            boolean flag = false;
            for (int j = 0; j < count; j++) {
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                if (haveTime(C, left, right)) {
                    output += "C";
                } else if (haveTime(J, left, right)) {
                    output += "J";
                } else {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": "  + output);
            }
        }
        
    }

    static boolean haveTime(int[] p, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            if (p[i] == 1) return false;
        }
        for (int i= left; i <= right; i++) {
            p[i] = 1;
        }
        return true;
    }

}
