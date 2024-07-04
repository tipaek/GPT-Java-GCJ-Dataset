import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 1; i <= size; i++) {
            int count = scanner.nextInt();
            String output = "";
            List<int[]> C = new ArrayList<>();
            List<int[]> J = new ArrayList<>();
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
                    break;
                }
            }

            if (flag) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": "  + output);
            }
        }

    }

    static boolean haveTime(List<int[]> p, int left, int right) {
        int[] temp = new int[2];
        temp[0] = left;
        temp[1] = right;
        for (int[] inv : p) {
            if (inv[0] <= left && left < inv[1]) {
                return false;
            } else if (inv[0] < right && right <= inv[1]) {
                return false;
            } else if (left < inv[0] && inv[1] < right) {
                return false;
            }
            
        }
        p.add(temp);
        return true;
    }

}
