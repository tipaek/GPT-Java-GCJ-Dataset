import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int ti=1;ti<=t;ti++){
            int n = in.nextInt();
            int mat[][] = new int[n][n];
            int trace = 0;
            int rowDup = 0;
            int columnDup = 0;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int inp = in.nextInt();
                    mat[i][j] = inp;
                    if(i==j){
                        trace+=mat[i][i];
                    }
                }
            }

            for(int row=0;row<n;row++){
                HashSet<Integer> set = new HashSet<>();
                for(int col=0;col<n;col++){
                    if(set.add(mat[row][col]) == false){
                        ++rowDup;
                        break;
                    }

                }
            }

            for(int col=0;col<n;col++){
                HashSet<Integer> set = new HashSet<>();
                for(int row=0;row<n;row++){
                    if(set.add(mat[row][col]) == false){
                        ++columnDup;
                        break;
                    }

                }
            }

            System.out.println("Case #"+ti+": "+trace+" "+rowDup+" "+columnDup);

        }
    }
}