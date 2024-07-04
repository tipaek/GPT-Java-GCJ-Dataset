import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

class Solution     {

    Scanner             sc;
    static final String FILENAME = "A-large";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;


    private void run() throws Exception {
        // out = new PrintStream(new FileOutputStream(OUT));

        int[][] matrix ;
        sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        for (int i = 1; i <= t; i++) {
                int N =  Integer.valueOf(sc.nextLine());
            matrix = new int[N][N];
                for(int j=0;j<N;j++){
                    String[] arr = sc.nextLine().split(" ");
                    matrix[j] = Stream.of(arr).mapToInt(Integer::parseInt).toArray();
                }
            List<Integer> result = solve(matrix,N);
            System.out.println("Case #" + i + ": "+result.get(0)+" "+result.get(1)+" "+result.get(2));

        }
        sc.close();
        out.close();
    }

    private List<Integer> solve(int[][] matrix, int N) {

        Set<Integer> set = new HashSet<>();
        int r=0;
        int c=0;
        int trace=0;
        for(int i=0;i<N;i++){
            set = new HashSet<>();
            for(int j=0;j<N;j++){
                if(i==j){
                    trace+=matrix[i][j];
                }
                set.add(matrix[i][j]);
            }
            if(set.size()!=N){
                r++;
            }
        }

        for(int i=0;i<N;i++){
            set = new HashSet<>();
            for(int j=0;j<N;j++){
                set.add(matrix[j][i]);
            }
            if(set.size()!=N){
                c++;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(trace);
        res.add(r);
        res.add(c);

        return res;


    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}