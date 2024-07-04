import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static final String IDX = "idx";
    static final String START = "start";
    static final String END = "end";
    static final String WORKER = "worker";
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    static int J_END = 0;
    static int C_END = 0;

    private static final Map<Integer, String> NAME_MAP;
    static {
        HashMap<Integer, String> m = new HashMap<Integer, String>();
        m.put(0, "J");
        m.put(1, "C");
        NAME_MAP = Collections.unmodifiableMap(m);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        T: for (int i = 1; i <= t; ++i) {

            J_END = 0;
            C_END = 0;
            List<Map<String, Integer>> taskList = new ArrayList<Map<String, Integer>>();
            int n = in.nextInt();

            for (int j = 0; j < n; ++j) {
                Map<String, Integer> m = new HashMap<String, Integer>();
                m.put(IDX, Integer.valueOf(j));
                m.put(START, in.nextInt());
                m.put(END, in.nextInt());
                taskList.add(m);
            }
            sortListMap(taskList, START);

            for (Map<String, Integer> task : taskList) {
                checkRelease(task.get(START).intValue());

                if (J_END == 0) {
                    task.put(WORKER, 0);
                    J_END = Integer.valueOf(task.get(END));
                } else if (C_END == 0) {
                    task.put(WORKER, 1);
                    C_END = Integer.valueOf(task.get(END));
                } else {
                    System.out.println("Case #" + i + ": " + IMPOSSIBLE);
                    continue T;
                }
            }

            sortListMap(taskList, IDX);
            StringBuilder sb = new StringBuilder();

            for (Map<String, Integer> task : taskList) {
                sb.append(NAME_MAP.get(task.get(WORKER)));
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
        in.close();
    }

    private static void sortListMap(List<Map<String, Integer>> list, String key) {
        Collections.sort(list, new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> rec1, Map<String, Integer> rec2) {
                Integer col1 = rec1.get(key);
                Integer col2 = rec2.get(key);
                return col1.compareTo(col2);
            }
        });
    }

    private static void checkRelease(int start) {

        if (J_END <= start) {
            J_END = 0;
        }

        if (C_END <= start) {
            C_END = 0;
        }
    }

}
