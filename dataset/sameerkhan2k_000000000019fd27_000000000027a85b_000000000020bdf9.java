import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<int[]> a = new ArrayList<>();
            Map<String, Integer> m = new HashMap();
            String[] r = new String[N];

            for (int i = 0; i < N; i++) {
                String x = br.readLine();
                String[] y = x.split(" ");
                a.add(new int[]{ Integer.parseInt(y[0]), Integer.parseInt(y[1])});
                m.put(x, i);
            }

            Collections.sort(a, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

//            for (int[] x: a) {
//                System.out.println(Arrays.toString(x));
//            }

            List<int[]> cameroon = new ArrayList();
            if (a.size() > 0) {
                int i = 0, j = 1;
                cameroon.add(a.get(i));
                for (; j < a.size(); j++) {
                    if (a.get(j)[0] >= a.get(i)[1]) {
                        cameroon.add(a.get(j));
                        i = j;
                    }
                }
            }

//            System.out.println("Cameroon....");
            for (int[] p: cameroon) {
                a.remove(p);
                r[m.get(p[0] + " " + p[1])] = "C";
//                System.out.println(Arrays.toString(p));
            }

//            System.out.println("Jamie....");
            List<int[]> jamie = new ArrayList();
            if (a.size() > 0) {
                int i = 0, j = 1;
                jamie.add(a.get(i));
                for ( ; j < a.size(); j++) {
                    if (a.get(j)[0] >= a.get(i)[1]) {
                        jamie.add(a.get(j));
                        i = j;
                    }
                }
            }

            for (int[] p: jamie) {
                a.remove(p);
                r[m.get(p[0] + " " + p[1])] = "J";
//                System.out.println(Arrays.toString(p));
            }

            System.out.println("Case #" + (-~t) + ": " + (a.size() == 0? String.join("", r): "IMPOSSIBLE"));
        }
    }
}
