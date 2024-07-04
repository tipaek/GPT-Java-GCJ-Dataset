import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    private static boolean overlaps(int[] A, int[] B){
        return (A[0] < B[1] && B[0] < A[1]);
    }
    private static String solution(int[][] T, int tasks, BufferedWriter out) throws IOException {
        Set<Integer> jennie = new HashSet<>();
        Set<Integer> cameron = new HashSet<>();
        Arrays.sort(T, Comparator.comparingInt(o -> o[0]));
//        for(int[] aa: T){
//            System.out.println(Arrays.toString(aa));
//        }
        for(int i = 0; i < tasks; i++){
            boolean found = false;
            int a = -1;
            int b = -1;
            for(int j = i + 1; j < tasks; j++){
                if(overlaps(T[i], T[j])){
                    found = true;
                    a = j + 1;
                    b = i + 1;
                    break;
                }
            }
            if(found){
                jennie.add(a);
                cameron.add(b);
                break;
            }
        }

        StringBuilder builder = new StringBuilder();

        if(cameron.size() == 0){
            for(int task = 0; task < tasks; task++){
                if((task % 2) == 0){
                    builder.append('C');
                } else{
                    builder.append('J');
                }
            }
            return builder.toString();
        }

        for(int i = 0; i < tasks; i++){
            boolean overlapsA = false;
            boolean overlapsB = false;

            for(int a: jennie){
                if ((i + 1) != a && (overlaps(T[a - 1], T[i]))) {
                    overlapsA = true;
                    break;
                }
            }

            for(int a: cameron){
                if ((i + 1) != a && (overlaps(T[a - 1], T[i]))) {
                    overlapsB = true;
                    break;
                }
            }

            if(overlapsA && overlapsB){
                return "IMPOSSIBLE";
            }

            if(overlapsA){
                cameron.add(i + 1);
            }

            if(overlapsB){
                jennie.add(i + 1);
            }

            if(!overlapsA && !overlapsB){
                jennie.add(i + 1);
            }
        }

        char[] res = new char[tasks];
//        System.out.println(jennie);
//        System.out.println(cameron);
        for(int a: jennie){
            res[a - 1] = 'J';
        }

        for(int b: cameron){
            res[b - 1] = 'C';
        }
        return new String(res);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("schedule.in"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = scanner.nextInt();
        for(int test = 1; test <= T; test++){
            int tasks = scanner.nextInt();
            int[][] taskArray = new int[tasks][2];
            for(int taskNo = 0; taskNo < tasks; taskNo++){
                taskArray[taskNo][0] = scanner.nextInt();
                taskArray[taskNo][1] = scanner.nextInt();
            }
            String res = solution(taskArray, tasks, out);
            out.write(String.format("Case #%d: %s", test, res)+"\n");
            if(!res.equals("IMPOSSIBLE")){
                assert res.length() == tasks;
            }
            //Case #2:
            out.flush();
        }
    }

    /*
1
4
1 110
119 230
110 241
240 250
     */
}