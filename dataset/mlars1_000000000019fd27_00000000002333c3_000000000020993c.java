import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int testCases = input.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < testCases; i++){
            set.clear();
            int N = input.nextInt();
            int k = 0,r = 0, c = 0;

            int[][] matrix = new int[N][N];
            for(int j = 0; j < N; j++){
                for (int l = 0; l < N; l++)
                    matrix[j][l] = input.nextInt();
            }

            //trace
            for(int j = 0; j < N; j++){
                k += matrix[j][j];
            }


            for(int j = 0; j < N; j++){
                //rows
                for (int l = 0; l < N; l++) {
                    if(set.contains(matrix[j][l])){
                        r++;
                        break;
                    }
                    else{
                        set.add(matrix[j][l]);
                    }
                    
                }
                set.clear();
                for (int l = 0; l < N; l++) {
                    if(set.contains(matrix[l][j])){
                        c++;
                        break;
                    }
                    else{
                        set.add(matrix[l][j]);
                    }
                }
                set.clear();
            }

            System.out.printf("Case #%d: %d %d %d\n", i, k, r, c);
        }

    }

}
