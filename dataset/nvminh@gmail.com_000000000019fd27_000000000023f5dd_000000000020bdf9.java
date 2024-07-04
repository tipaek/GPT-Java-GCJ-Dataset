import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Stream;
import static java.lang.Math.*;

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
//        List<int[]> list = Arrays.asList(taskTimes);
//        Collections.sort(list, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        Map<String, List<int[]>> parent = new HashMap<>();
        Map<int[], String> assigned = new HashMap<>();
        parent.put("C", new ArrayList<>());
        parent.put("J", new ArrayList<>());
        for(int[] task : taskTimes) {
            if(!assign(parent, task, assigned)) {
                return "IMPOSSIBLE";
            }
        }
        for(int[] task : taskTimes) {
            builder.append(assigned.get(task));
        }
        return builder.toString();
    }

    private static boolean assign(Map<String,List<int[]>> parent, int[] task, Map<int[], String> assigned) {
        for(Map.Entry<String, List<int[]>> entry : parent.entrySet()) {
            if(canAssign(entry.getValue(), task)) {
                entry.getValue().add(task);
                assigned.put(task, entry.getKey());
                return true;
            }
        }
        return false;
    }

    private static boolean canAssign(List<int[]> tasks, int[] task) {
        for(int[] t : tasks) {
            if((max(t[1],task[1]) - min(t[0],task[0])) < ((t[1] - t[0]) + (task[1] - task[0]))) {
                return false;
            }
        }
        return true;
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