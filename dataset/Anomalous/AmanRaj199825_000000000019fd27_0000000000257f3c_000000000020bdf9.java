import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

class Triple {
    int x, y, z;

    public Triple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Triple() {}
}

public class Solution {
    static int[] res = null;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int caseNum = 1; caseNum <= T; caseNum++) {
                int N = Integer.parseInt(br.readLine());
                List<Triple> list = new ArrayList<>();
                
                for (int i = 0; i < N; i++) {
                    String[] strArr = br.readLine().trim().split("\\s+");
                    Triple t = new Triple(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), i);
                    list.add(t);
                }
                
                Collections.sort(list, (a1, a2) -> Integer.compare(a1.x, a2.x));
                System.out.println("Case #" + caseNum + ": " + util(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String util(List<Triple> list) {
        res = new int[2];
        Arrays.fill(res, Integer.MAX_VALUE);
        StringBuilder sb = new StringBuilder();
        int n = list.size();

        for (int i = n - 1; i >= 0; i--) {
            boolean assigned = false;

            if (res[0] > res[1]) {
                swap(0, 1);
            }

            if (list.get(i).y <= res[0]) {
                assigned = true;
                sb.append('C');
                res[0] = list.get(i).x;
            }

            if (!assigned && list.get(i).y <= res[1]) {
                assigned = true;
                sb.append('J');
                res[1] = list.get(i).x;
            }

            if (!assigned) {
                return "IMPOSSIBLE";
            }
        }

        return sb.reverse().toString();  // Reverse the StringBuilder to get the correct order
    }

    public static void swap(int m, int n) {
        int temp = res[m];
        res[m] = res[n];
        res[n] = temp;
    }
}