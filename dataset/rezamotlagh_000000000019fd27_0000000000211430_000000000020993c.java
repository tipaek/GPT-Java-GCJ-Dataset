
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int tc = 1 ;
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] list = new int[n][n];
            int k = 0 ;
            for(int i = 0 ; i < n; i++)
            {
                for(int j = 0 ; j < n ; j++)
                {
                    list[i][j] = sc.nextInt();
                }
            }

            for(int i = 0 ; i < n ;i++)
            {
                k+=list[i][i];
            }
            int rows = 0 ;
            HashSet<Integer> dups = new HashSet<>();
            for(int i = 0 ; i < n ; i++)
            {
                dups.clear();
                for(int j = 0 ; j < n ; j++)
                    dups.add(list[i][j]);
                if(dups.size()!=n)
                {
                    //has dup.
                    rows++;
                }
            }
            int cols = 0 ;
            for(int i = 0 ; i < n ; i++)
            {
                dups.clear();
                for(int j = 0 ; j < n ; j++)
                    dups.add(list[j][i]);
                if(dups.size()!=n)
                {
                    //has dup.
                    cols++;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n",tc++,k,rows,cols);
        }
    }
}