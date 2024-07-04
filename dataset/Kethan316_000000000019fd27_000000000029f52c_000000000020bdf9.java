import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= x; i++) {
            int endC = 0;
            int endJ = 0;
            int y = Integer.parseInt(bf.readLine());
            int[] pos = new int[y];
            List<Integer> start = new LinkedList<>();
            List<Integer> end = new LinkedList<>();
            for (int j = 0; j < y; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                start.add(Integer.parseInt(st.nextToken()));
                end.add(Integer.parseInt(st.nextToken()));
                pos[j] = j;
            }

            for (int j = 0; j < y; j++) {
                int min = start.get(j);
                int minIdx = j;
                for (int z = i + 1; z < y; z++)
                    if (start.get(z) < start.get(minIdx)) {
                        minIdx = z;
                        min = start.get(z);
                    }
                start.set(minIdx, start.get(i));
                start.set(j, min);
                min = end.get(minIdx);
                end.set(minIdx, end.get(j));
                end.set(j, min);
                min = pos[minIdx];
                pos[minIdx] = pos[j];
                pos[j] = min;
            }

            char[] ans = new char[y];
            boolean notAvail = false;
            for (int j = 0; j < y; j++) {

                if (start.get(j) < endC && start.get(j) < endJ) {
                    notAvail = true;
                    break;
                } else {
                    if (start.get(j) >= endC) {
                        ans[pos[j]] = 'C';
                        endC = end.get(j);
                    } else {
                        ans[pos[j]] = 'J';
                        endJ = end.get(j);
                    }
                }
            }
            if (notAvail)
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            else
                System.out.println("Case #" + i + ": " + new String(ans));
        }
    }
}