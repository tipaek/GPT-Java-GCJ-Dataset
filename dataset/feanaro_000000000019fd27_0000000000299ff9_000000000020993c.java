import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;


public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        Function<int[][],String> solver = (m) -> {
            int k=0,r=0,c=0;

            for (int i=0;i<m.length;++i) {
                Set<Integer> bag = new HashSet<>();
                for (int j = 0; j < m.length; ++j)
                    if (!bag.contains(m[i][j]))
                        bag.add(m[i][j]);
                    else {
                        ++r;
                        break;
                    }
            }

            for (int i=0;i<m.length;++i) {
                Set<Integer> bag=new HashSet<>();
                for (int j = 0; j < m.length; ++j)
                    if (!bag.contains(m[j][i]))
                        bag.add(m[j][i]);
                    else {
                        ++c;
                        break;
                    }
            }

            for (int i=0;i<m.length;++i)
                k+=m[i][i];

            return k+" "+r+" "+c;
        };

        if (scanner != null) {
            Integer tests = scanner.nextInt();
            for (int i = 1; i <= tests; ++i){
                Integer n = scanner.nextInt();
                int[][] matrix= new int[n][n];

                for (int j=0;j<n;++j)
                    for (int k=0;k<n;++k) {
                        matrix[j][k] = scanner.nextInt();
                    }

                System.out.println("Case #"+i+": "+solver.apply(matrix));
            }
        }
    }
}