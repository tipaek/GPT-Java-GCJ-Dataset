import java.util.*;

public class Solution {



    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {

            int countRows = 0;
            int countColums = 0;
            int dia = 0;

            List<Set<Integer>> colums = new ArrayList<Set<Integer>>();
            int N =sc.nextInt();

            for (int i = 0; i <N; i++) {
                colums.add(new HashSet<Integer>());
            }
            for (int i = 0; i < N; i++) {
                Set<Integer> row = new HashSet<Integer>();

                for (int j = 0; j < N; j++) {
                    int n = sc.nextInt();
                    row.add(n);
                    colums.get(j).add(n);
                    if(i == j)
                        dia = dia + n;
                }
                if(row.size() != N){
                    countRows++;
                }
            }

            for (int i = 0; i <N; i++) {
                Set<Integer> colum = colums.get(i);
                if(colum.size() != N){
                    countColums++;
                }
            }
            String outPut = String.format("Case #%d: %d %d %d", t + 1, dia, countRows, countColums);
            System.out.println(outPut);

        }
    }

}
