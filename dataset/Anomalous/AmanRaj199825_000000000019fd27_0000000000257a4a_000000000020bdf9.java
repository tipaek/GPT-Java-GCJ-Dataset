import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Triple {
    int x;
    int y;
    int z;

    public Triple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Triple() {
    }
}

class Solution {
    static int[] res = null;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                List<Triple> list = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    String[] strarr = br.readLine().trim().split("\\s+");
                    Triple t = new Triple(Integer.parseInt(strarr[0]), Integer.parseInt(strarr[1]), i);
                    list.add(t);
                }
                Collections.sort(list, (a1, a2) -> a1.x - a2.x);
                System.out.println(util(list));
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
            boolean flag = false;
            if (res[0] > res[1]) {
                swap(0, 1);
            }
            if (list.get(i).y <= res[0]) {
                flag = true;
                sb.append('C');
                res[0] = list.get(i).x;
            }
            if (!flag && list.get(i).y <= res[1]) {
                flag = true;
                sb.append('J');
                res[1] = list.get(i).x;
            }
            if (!flag) {
                return "IMPOSSIBLE";
            }
        }
        return sb.reverse().toString();
    }

    public static void swap(int m, int n) {
        int t = res[m];
        res[m] = res[n];
        res[n] = t;
    }
}