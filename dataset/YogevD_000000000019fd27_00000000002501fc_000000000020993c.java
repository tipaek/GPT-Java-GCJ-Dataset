import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int t = 0; t < T ; t ++){
            int N = scanner.nextInt();
            int[][] arr = new int[N][N];

            int trace = 0;
            int row = 0;

            List<Set<Integer>> list= new ArrayList<>();
            for (int i = 0; i < N ; i ++){
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < N ; j ++) {
                    int num = scanner.nextInt();
                    arr[i][j] = num;
                    if (i == j){
                        trace += num;
                    }
                    set.add(num);
                    if (list.size() <= j){
                        list.add(new HashSet<>());
                    }
                    list.get(j).add(num);
                }
                if (set.size() < N){
                    row++;
                }
            }

            long col  = list.stream().filter(s -> s.size() < N).count();
            System.out.println("Case #" + (t+1) + ": " + trace + " " + row + " " + col);
        }
        scanner.close();
    }

}