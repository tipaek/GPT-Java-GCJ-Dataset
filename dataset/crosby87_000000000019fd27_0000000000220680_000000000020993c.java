import java.util.*;

public class vestigium {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++){
            int a = sc.nextInt();
            int[][] mat = new int[a][a];

            for (int j = 0; j < a; j++){
                for (int k = 0; k < a; k++){
                    mat[j][k] = sc.nextInt();
                }
            }

            int trace = 0;

            for (int j = 0; j < a; j++){
                trace += mat[j][j];
            }
            int rows = 0;
            int cols = 0;

            HashSet<Integer> r = new HashSet<>();
            HashSet<Integer> c = new HashSet<>();

            for (int j = 0; j < a; j++){
                r = new HashSet<>();
                for (int k = 0; k < a; k++){
                    r.add(mat[j][k]);
                }
                if (r.size() != a) rows++;
            }

            for (int j = 0; j < a; j++){
                c = new HashSet<>();
                for (int k = 0; k < a; k++){
                    c.add(mat[k][j]);
                }
                if (c.size() != a) cols++;
            }

            System.out.print("Case #" + i + ": " + trace + " " + rows + " " + cols);
            System.out.println();
        }
        System.exit(0);
    }
}
