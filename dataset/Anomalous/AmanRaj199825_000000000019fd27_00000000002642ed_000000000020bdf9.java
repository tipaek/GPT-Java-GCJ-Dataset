import java.io.*;
import java.util.*;

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
        // Default constructor
    }
}

class Solution {
    static int[] res = null;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int x = 1; x <= T; x++) {
                int N = Integer.parseInt(br.readLine());
                List<Triple> list = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    String[] strarr = br.readLine().trim().split("\\s+");
                    Triple t = new Triple(Integer.parseInt(strarr[0]), Integer.parseInt(strarr[1]), i);
                    list.add(t);
                }

                list.sort(Comparator.comparingInt(a -> a.y));
                list.forEach(i -> System.out.println(i.x + " " + i.y));
                System.out.println("Case #" + x + ": " + util(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String util(List<Triple> list) {
        res = new int[2];
        char[] arr = new char[list.size()];
        Arrays.fill(res, Integer.MAX_VALUE);

        for (int i = list.size() - 1; i >= 0; i--) {
            boolean assigned = false;
            if (res[0] > res[1]) swap(0, 1);

            if (list.get(i).y <= res[0]) {
                arr[list.get(i).z] = 'C';
                res[0] = list.get(i).x;
                assigned = true;
            } else if (list.get(i).y <= res[1]) {
                arr[list.get(i).z] = 'J';
                res[1] = list.get(i).x;
                assigned = true;
            }

            if (!assigned) return "IMPOSSIBLE";
        }

        return new String(arr);
    }

    public static void swap(int m, int n) {
        int temp = res[m];
        res[m] = res[n];
        res[n] = temp;
    }
}