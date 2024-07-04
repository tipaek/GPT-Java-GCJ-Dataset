import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for ( int i =0; i < cases; i++){

            int tasks = sc.nextInt();
            int [][] schedule = new int [1441][tasks];

            for(int j =0; j< tasks; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                for (int n = start; n < end; n++){
                    schedule[n][j] = 1;
                }
            }

            boolean isPossible = possible(schedule, tasks);

            if(isPossible){
                String solution = result(schedule, tasks);
                System.out.println("Case #" + (i + 1) + ": " + solution);
            }
            else System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
        }
    }

    static boolean possible(int[][] schedule, int tasks){
        for(int r = 0; r <= 1440; r++){
            int sum = 0;
            for(int c = 0; c < tasks; c++){
                sum += schedule[r][c];
            }
            if(sum > 2) return false;
        }
        return true;
    }

    static String result(int[][] schedule, int tasks){
        int [] result = new int [tasks];
        HashSet<Integer> cameroon = new HashSet<>();
        HashSet<Integer> jamie = new HashSet<>();
        for ( int r = 0; r <= 1400; r++){
            for(int c =0; c< tasks; c++){
                if(schedule[r][c] == 1){
                    if(result[c] == 0){
                        if(cameroon.size() == 0){
                            cameroon.add(c);
                            result[c] = -1;
                        }
                        else if(jamie.size() == 0){
                            jamie.add(c);
                            result[c] = 1;
                        }
                    }
                }
                else {
                    cameroon.remove(c);
                    jamie.remove(c);
                }
            }
        }
        StringBuilder solution = new StringBuilder();

        for(int c =0; c< tasks; c++){
            if(result[c] == -1) solution.append('C');
            else if (result[c] == 1) solution.append('J');
        }
        return solution.toString();
    }
}