import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long time = System.currentTimeMillis();
        for(int a = 1; a<=t;a++){
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for(int j = 0; j<n;j++){
                for(int i = 0; i<n;i++){
                    matrix[i][j]=scanner.nextInt();
                }
            }
            int k = 0;
            int r = 0;
            int c = 0;
            for(int b=0; b<n;b++){
                k+=matrix[b][b];
            }

            for(int b=0; b<n;b++){
                ArrayList<Integer> row = new ArrayList<>();
                ArrayList<Integer> column = new ArrayList<>();
                for(int d=0; d<n; d++){
                    boolean wrong = false;
                    for(int x:row){
                        if (matrix[d][b]==x) {
                            r++;
                            wrong = true;
                            break;
                        }
                    }
                    if(wrong) break;
                    row.add(matrix[d][b]);
                }
                for(int d=0; d<n; d++){
                    boolean wrong = false;
                    for(int x:column){
                        if (matrix[b][d]==x){
                            c++;
                            wrong = true;
                            break;
                        }
                    }
                    if(wrong) break;
                    column.add(matrix[b][d]);
                }

            }
            System.out.println("Case #"+a+": "+k+" "+r+" "+c);
        }
    }
}
