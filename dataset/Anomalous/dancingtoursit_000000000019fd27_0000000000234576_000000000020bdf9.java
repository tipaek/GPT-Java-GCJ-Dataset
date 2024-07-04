import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    private static boolean overlaps(int[] A, int[] B) {
        return (A[0] < B[1] && A[1] > B[0]);
    }
    
    private static String assignTasks(int[][] tasks, int taskCount) {
        Set<Integer> jennieTasks = new HashSet<>();
        Set<Integer> cameronTasks = new HashSet<>();
        
        for (int i = 0; i < taskCount; i++) {
            for (int j = i + 1; j < taskCount; j++) {
                if (overlaps(tasks[i], tasks[j])) {
                    jennieTasks.add(i + 1);
                    cameronTasks.add(j + 1);
                    break;
                }
            }
        }
        
        StringBuilder resultBuilder = new StringBuilder();
        
        if (cameronTasks.isEmpty()) {
            for (int i = 0; i < taskCount; i++) {
                resultBuilder.append((i % 2) == 0 ? 'C' : 'J');
            }
            return resultBuilder.toString();
        }
        
        for (int i = 0; i < taskCount; i++) {
            boolean overlapsJennie = false;
            boolean overlapsCameron = false;
            
            for (int task : jennieTasks) {
                if ((i + 1) != task && overlaps(tasks[task - 1], tasks[i])) {
                    overlapsJennie = true;
                }
            }
            
            for (int task : cameronTasks) {
                if ((i + 1) != task && overlaps(tasks[task - 1], tasks[i])) {
                    overlapsCameron = true;
                }
            }
            
            if (overlapsJennie && overlapsCameron) {
                return "IMPOSSIBLE";
            }
            
            if (overlapsJennie) {
                cameronTasks.add(i + 1);
            } else if (overlapsCameron) {
                jennieTasks.add(i + 1);
            } else {
                jennieTasks.add(i + 1);
            }
        }
        
        char[] result = new char[taskCount];
        
        for (int task : jennieTasks) {
            result[task - 1] = 'J';
        }
        
        for (int task : cameronTasks) {
            result[task - 1] = 'C';
        }
        
        return new String(result);
    }
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];
            
            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }
            
            String result = assignTasks(tasks, taskCount);
            out.write(String.format("Case #%d: %s\n", test, result));
            out.flush();
        }
        
        scanner.close();
        out.close();
    }
}