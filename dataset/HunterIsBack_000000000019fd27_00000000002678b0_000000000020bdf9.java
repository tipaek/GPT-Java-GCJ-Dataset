import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
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
            matrix = new int[N][2];
            for(int j=0;j<N;j++){
                String[] arr = sc.nextLine().split(" ");
                matrix[j] = Stream.of(arr).mapToInt(Integer::parseInt).toArray();
            }
            String result = solve(matrix,N);
            System.out.println("Case #" + i + ": "+result);

        }
        sc.close();
        out.close();
    }

    private String solve(int[][] matrix, int N) {

        Arrays.sort(matrix,(a,b)->{
            return a[0]-b[0];
        });

        StringBuilder result = new StringBuilder();
        List<int[]> one  = new ArrayList<>();
        List<int[]> two  = new ArrayList<>();
        one.add(matrix[0]);
        two.add(matrix[1]);
        result.append("C").append("J");
        for(int i=2;i<N;i++){
            int[] temp = matrix[i];
            if(temp[0]>=one.get(one.size()-1)[1]){
                result.append("C");
                one.add(temp);
            }else  if(temp[0]>=two.get(two.size()-1)[1]){
                result.append("J");
                two.add(temp);
            }else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}