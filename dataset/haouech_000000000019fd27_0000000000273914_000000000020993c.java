import java.util.*;

class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String argv[]) {
        int t = scanner.nextInt();
        for (int tc=1; tc <= t; tc++) {
            int N = scanner.nextInt();
            List<List<Integer>> matrix = readMatrix(N);

            Result result = solve(N, matrix);
            System.out.println("Case #" + tc + ": " + result.k + " " + result.r + " " + result.c);
        }
    }

    private static List<List<Integer>> readMatrix(int N) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<N; i++) {
            result.add(new ArrayList<>());
            for (int j=0; j<N; j++) {
                int v = scanner.nextInt();
                result.get(i).add(v);
            }
        }
        return result;
    }

    private static Result solve(int N, List<List<Integer>> matrix) {
        Result result = new Result(4, 0, 0);
        int trace = 0;
        int r = 0, c = 0;
        // check rows
        for (int i=0; i<N; i++) {
            Set<Integer> visited = new HashSet<>();
            trace += matrix.get(i).get(i);
            for (int j=0; j<N; j++) {
                int v = matrix.get(i).get(j);
                if (visited.contains(v)) {
                    r++;
                    break;
                }
                visited.add(v);
            }
        }
        //check columns
        for (int i=0; i<N; i++) {
            Set<Integer> visited = new HashSet<>();
            for (int j=0; j<N; j++) {
                int v = matrix.get(j).get(i);
                if (visited.contains(v)) {
                    c++;
                    break;
                }
                visited.add(v);
            }
        }
        return new Result(trace, r, c);
    }
}

class Result {
    int k, r, c;
    public Result(int k, int r, int c) {
        this.k = k;
        this.r = r;
        this.c = c;
    }
}