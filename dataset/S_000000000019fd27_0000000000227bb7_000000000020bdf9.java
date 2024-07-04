import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 1; i <= size; i++) {
            int count = scanner.nextInt();
            List<int[]> C = new ArrayList<>();
            List<int[]> J = new ArrayList<>();
            String output = "";

            for (int j = 0; j < count; j++) {
                int[] temp = new int[2];
                temp[0] = scanner.nextInt();
                temp[1] = scanner.nextInt();
                if (helper(C, temp)) {
                    output += 'C';
                    C.add(temp);
                } else if (helper(J, temp)) {
                    output += 'J';
                    J.add(temp);
                }
            }


            if (count != output.length()) System.out.println("case #" + i + ": "  + "IMPOSSIBLE");
            else System.out.println("case #" + i + ": "  + output);
        }
    }

 
    static boolean helper(List<int[]> list, int[] temp) {
        for (int[] prev : list) {
            if (prev[0] <= temp[0] && temp[0] < prev[1]) return false;
            else if (prev[0] < temp[1] && temp[1] <= prev[1]) return false;
            else if (temp[0] <= prev[0] && prev[0] < temp[1]) return false;
        }
        return true;
    }
}
