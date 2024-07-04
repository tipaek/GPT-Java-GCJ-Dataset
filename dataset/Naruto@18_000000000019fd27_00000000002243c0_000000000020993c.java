import java.util.*;

public class Solution{
    
    public static void main(String[] args ){
         Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            int i=1;
            while(i <= t ){
                StringBuilder ans = solve(in);
                System.out.println("Case #"+i+": "+ans);
                i++;
            }
    }
    private static StringBuilder solve(Scanner in ){
        // a = trace , b = repeat in row  , c = repeat in col
        int a=0, b=0, c=0;
        int n  = in.nextInt();
        int[][]matrix = new int[n][n];
        boolean r_row = false;
        boolean c_col = false;
        for(int i=0;i<n;i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            r_row = false;
            for(int j=0;j<n;j++){
                matrix[i][j] = in.nextInt();
                if( !row.isEmpty() && row.contains(matrix[i][j])  ){
                    r_row = true;
                }else{
                    row.add(matrix[i][j]);
                }

                if(i == j ){
                    a += matrix[i][j];
                }

            }
            if(r_row)b++;
        }

        for(int j=0;j<n;j++){
            ArrayList<Integer>col = new ArrayList<Integer>();
            c_col = false;
            for(int i=0;i<n;i++){
                if(!col.isEmpty() && col.contains(matrix[i][j])){
                    c_col = true;
                    break;
                }else{
                    col.add(matrix[i][j]);
                }
            }
            if(c_col)c++;
        }
        StringBuilder ans = new StringBuilder("");
        ans.append(a);
        ans.append(" ");
        ans.append(b);
        ans.append(" ");
        ans.append(c);

        return ans;
    }
}
