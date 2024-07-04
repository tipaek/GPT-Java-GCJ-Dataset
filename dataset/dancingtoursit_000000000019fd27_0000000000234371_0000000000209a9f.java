import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    private static boolean overlaps(int[] A, int[] B){
        return (A[0] < B[1] && A[1] > B[0]);
    }
    private static String solution(int[][] T, int tasks, BufferedWriter out) throws IOException {
        Set<Integer> jennie = new HashSet<>();
        Set<Integer> cameron = new HashSet<>();
        for(int i = 0; i < tasks; i++){
            int j = i + 1;
            boolean found = false;
            int a = -1;
            int b = -1;
            while(j < tasks){
                if(overlaps(T[i], T[j])){
                    a = i + 1;
                    b = j + 1;
                    found = true;
                }
                j++;
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
                if((i + 1) != a && (overlaps(T[a - 1], T[i]))){
                    overlapsA = true;
                }
            }

            for(int a: cameron){
                if((i + 1) != a && (overlaps(T[a - 1], T[i]))){
                    overlapsB = true;
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
        Scanner scanner = new Scanner(System.in);
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
            out.write(String.format("Case #%d: %s\n", test, res));
            //Case #2:
            out.flush();
        }
    }

    /*
1
4
1 120
119 230
110 240
230 250
     */
}