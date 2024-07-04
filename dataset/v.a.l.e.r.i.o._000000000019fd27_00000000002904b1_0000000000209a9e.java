package codejam2020;

import java.util.*;

public class Solution {

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {

         Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(new java.io.FileInputStream("latin.in"));

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt(); // size matrix
            int K = in.nextInt(); // size matrix
            Latin create = new Latin(N, K);
            System.out.println("Case #" + t + ": " + create.compute());
        }
        in.close();
    }

    int N;
    int K;
    int[][] matrix;

    public Solution(int N, int K) {
        this.N = N;
        this.K = K;
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 0;
            }
        }
    }


    public static List<Integer> getDiagonal(int N, int K) {
        int D = K / N;
        int R = K % N;
        //FORMULA DEL SECOLO
        //(N - R ) di valore D
        //R di valore D +1
        List<Integer> diagonale = new ArrayList<>();
        for (int i = 0; i < (N - R); i++) {
            diagonale.add(D);
        }
        for (int i = 0; i < (R); i++) {
            diagonale.add(D + 1);
        }
        return diagonale;
    }


    public String compute() {
        if (K > N * N || K < N) {
            return "IMPOSSIBLE";
        }

        List<Integer> diagonale = getDiagonal(N, K);

        // CREO I PUNTI
        HashMap<Integer, List<Position>> rowPerPoints = new HashMap<>();
        HashMap<Integer, List<Position>> columnsPerPoints = new HashMap<>();
        Set<Position> allPoints = new HashSet<>();
        for (int i = 0; i < N; i++) {
            rowPerPoints.putIfAbsent(i, new ArrayList<>(N));
            columnsPerPoints.putIfAbsent(i, new ArrayList<>(N));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    Position pos = new Position(i, j);
                    allPoints.add(pos);
                    rowPerPoints.get(i).add(pos);
                    columnsPerPoints.get(j).add(pos);
                }
            }
        }

        Map<Integer, List<Position>> num2dictionary = new HashMap<>();
        for (int j = 1; j <= N; j++) {
            num2dictionary.put(j, new ArrayList<>(allPoints));
        }

        int index = 0;
        for (int d : diagonale) {
            matrix[index][index] = d;
            num2dictionary.get(d).removeAll(rowPerPoints.get(index));
            num2dictionary.get(d).removeAll(columnsPerPoints.get(index));
            index++;
        }

        Random rnd = new Random();
        for (int num = 1; num <= N; num++) {
            while (!num2dictionary.get(num).isEmpty()) {
                Position randomPosition = num2dictionary.get(num).get(rnd.nextInt(num2dictionary.get(num).size()));
                matrix[randomPosition.x][randomPosition.y] = num;
                num2dictionary.get(num).removeAll(rowPerPoints.get(randomPosition.x));
                num2dictionary.get(num).removeAll(columnsPerPoints.get(randomPosition.y));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("POSSIBLE\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matrix[i][j]);
                if (matrix[i][j] == 0) {
                    return "IMPOSSIBLE";
                }
                if (j < N - 1) {
                    sb.append(" ");
                }
            }
            if (i < N - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }


}
