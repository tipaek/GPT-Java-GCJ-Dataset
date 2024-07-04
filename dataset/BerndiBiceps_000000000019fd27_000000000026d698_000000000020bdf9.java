import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();

        for (int j = 0; j < tests; j++) {
            int activities = in.nextInt();
            int [][] t = new int [activities][2];

            for (int i = 0; i < activities; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

                t[i][0] = start;
                t[i][1] = end;
            }

            boolean[] person = new boolean[activities];
            ArrayList<Integer> used = new ArrayList<>();
            int last = -1;
            int lastF = -1;
            boolean possible = true;

            for (int i = 0; i < activities; i++) {
                int minStart = -1;
                int idx = -1;
                for (int a = 0; a < activities; a++) {
                    if (used.contains(a)) {
                        continue;
                    }

                    if (minStart == -1) {
                        minStart = t[a][0];
                        idx = a;
                    } else if (minStart > t[a][0]) {
                        minStart = t[a][0];
                        idx = a;
                    }
                }

                if (last == -1) {
                    person[idx] = true;
                    last = idx;
                } else if (t[idx][0] >= t[last][1]) {
                    person[idx] = true;
                    last = idx;
                } else {
                    if (lastF == -1){
                        lastF = idx;
                    } else {
                        if (t[lastF][1] > t[idx][0]){
                            possible = false;
                            break;
                        } else {
                            lastF = idx;
                        }
                    }
                }

                used.add(idx);
            }

            System.out.print(String.format("Case #%d: ", j+1));

            if (possible) {
                for (int i = 0; i < activities; i++) {
                    if (person[i]){
                        System.out.print('C');
                    }else{
                        System.out.print('J');
                    }

                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

}