import java.util.*;

public class Solution {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scanner.nextInt();
        while(T > 0){
            int N = scanner.nextInt();
            int [][] arr = new int[N][N];
            for(int i = 0 ; i < N ; i++ )
            {
                for(int  j = 0 ; j < N ; j++){
                    arr[i][j] = scanner.nextInt();
                }
            }
            int trace = 0;
            int row = 0;
            int column = 0;
              for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(i == j){
                trace += arr[i][j];
                        
                    }
            }
        }

            for(int i = 0 ; i<N ; i++){
                Set setrow = new HashSet();
                Set setcol = new HashSet();
                for(int j = 0; j < N ; j++){
                    setrow.add(arr[i][j]);
                    setcol.add(arr[j][i]);
                }
                if(setrow.size() < arr.length)
                {
                    row++;
                }
                if(setcol.size() < arr.length){
                    column++;
                }
            }


            System.out.print(trace + " " + row + " " + column + "\n");
            T--;
        }
    }
}
