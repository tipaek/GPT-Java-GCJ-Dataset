import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            String[] inputs = new String[N];
            for (int j = 0; j < N; j++) inputs[j] = sc.nextLine().substring(1);
            Arrays.sort(inputs, (a, b) -> a.length() - b.length());
            boolean flag = false;
            for (int j = 0; j < N - 1; j++) {
                if (flag) break;
                for (int p = j + 1; p < N; p++) {
                    if (!inputs[p].contains(inputs[j])) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("Case #" + i + ": " + "*");
            } else {
                System.out.println("Case #" + i + ": " + inputs[inputs.length - 1]);
            }
        }
    }
}

