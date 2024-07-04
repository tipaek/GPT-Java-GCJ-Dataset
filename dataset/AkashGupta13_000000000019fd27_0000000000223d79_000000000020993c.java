import java.util.*;
// import java.util.Stream.*;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int c = 1;
        while(t-- > 0){
            System.out.print("Case #" + c++ + ": ");
            int n = in.nextInt();
            int a[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j] = in.nextInt();
                }
            }
            int trace = 0, rows = 0, cols = 0;
            for(int i=0;i<n;i++){
                trace += a[i][i];
            }
            for(int i=0;i<n;i++){
                long count = Arrays.stream(a[i])
                                .distinct()
                                .count();
                if(count != n)
                    rows++;
            }
            for(int i=0;i<n;i++){
                HashSet<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++){
                   set.add(a[j][i]); 
                }
                if(set.size() != n)
                    cols++;
            }
            System.out.println(trace + " " + rows + " " + cols);
        }
    }
}