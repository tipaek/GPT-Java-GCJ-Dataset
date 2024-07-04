import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        int N;
        int test_no = 1;

        for(int z = 0; z<T; z++){
            N = scn.nextInt();
            int[][] arr = new int[N][N];
            for(int j = 0; j<N; j++){
                for(int a = 0; a<N;a++){
                    arr[j][a] = scn.nextInt();
                }
            }

            int r = 0;
            int c = 0;
            int k = 0;
            int el_r;
            int el_c;
            boolean row = false;
            boolean col = false;
            int [][] dup_row = new int[N][N];
            int [][] dup_col = new int[N][N];

            for(int i = 0; i<N;i++){
                for(int j= 0; j<N;j++){
                    el_r = arr[i][j]-1;
                    el_c = arr[j][i]-1;

                    dup_row[i][el_r] +=1;
                    dup_col[el_c][i] +=1;

                    //row
                    if(dup_row[i][el_r] == 2 && !row ){
                        row = true;
                        r+=1;

                    }

                    //column
                    if(dup_col[el_c][i] == 2 && !col){
                        col = true;
                        c+=1;
                    }

                    //trace
                    if(i == j){
                        k += arr[i][j];
                    }

                }

                col = false;
                row = false;
            }
            System.out.println("Case #"+test_no+": "+k+" "+r+" "+c);
            test_no++;

        }
    }


}
