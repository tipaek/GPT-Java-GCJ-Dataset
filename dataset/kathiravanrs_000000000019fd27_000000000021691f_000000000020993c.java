import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = scanner.nextInt();
        String out = "";
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int k = 0, r = 0, c = 0;
            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            for (int a = 0; a < d; a++) {
                ArrayList<Integer> arr = new ArrayList<>();
                boolean rowDup = false;
                for (int b = 0; b < d; b++) {
                    int val = scanner.nextInt();
                    if (arr.contains(val) && !rowDup) {
                        r++;
                        rowDup = true;
                    }
                    arr.add(val);
                    if (a == b) k = k + val;
                }
                mat.add(arr);
            }
            for (int x = 0; x < d; x++) {
                ArrayList<Integer> in = new ArrayList<>();
                for (int z = 0; z < d; z++) {
                    int cur = mat.get(z).get(x);
                    if (in.contains(cur)) {
                        c++;
                        break;
                    } else {
                        in.add(cur);
                    }
                }
            }
            out = out + ("Case #" + (i + 1) + " " + k + " " + r + " " + c + "\n");
        }
        System.out.print(out);
        scanner.close();
    }
}
