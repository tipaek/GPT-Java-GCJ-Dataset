import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = getScanner();
        int caseNum = readLineToInt(sc);
        for(int caseIndex = 1; caseIndex <= caseNum; caseIndex ++) {
            int n = readLineToInt(sc);
            int[][] taskTimes = new int[n][];
            for(int i=0; i<n; i++) {
                taskTimes[i] = readLineToInts(sc);
            }
            System.out.println(String.format("Case #%s: %s", caseIndex, solve(taskTimes)));
        }
    }

    private static String solve(int[][] taskTimes) {
        StringBuilder builder = new StringBuilder();
        List<int[]> list = Arrays.asList(taskTimes);
        Collections.sort(list, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        Map<String, int[]> parent = new HashMap<>();
        Map<int[], String> assigned = new HashMap<>();
        parent.put("C", new int[2]);
        parent.put("J", new int[2]);
        for(int[] task : list) {
            if(!assign(parent, task, assigned)) {
                return "IMPOSSIBLE";
            }
        }
        for(int[] task : taskTimes) {
            builder.append(assigned.get(task));
        }
        return builder.toString();
    }

    private static boolean assign(Map<String,int[]> parent, int[] task, Map<int[], String> assigned) {
        for(Map.Entry<String, int[]> entry : parent.entrySet()) {
            if(entry.getValue()[1] <= task[0]) {
                parent.put(entry.getKey(), task);
                assigned.put(task, entry.getKey());
                return true;
            }
        }
        return false;
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
        // try {
        //     return new Scanner(new FileInputStream("input3.txt"));
        // } catch (Exception x) {
        //     return null;
        // }
    }

    private static int readLineToInt(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    private static int[] readLineToInts(Scanner sc) {
        String line = sc.nextLine();
        return Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
