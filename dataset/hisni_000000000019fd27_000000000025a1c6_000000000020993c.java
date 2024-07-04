import java.util.*;
import java.io.*;

public class Solution {

    static int rsolve(int[][] arr, int N){
        int count = 0;
        for(int i=0;i<N;i++){
            HashMap<Integer, Integer> map = new HashMap<>(); 
            for(int j=0;j<N;j++){
                if( map.containsKey(arr[i][j]) ){
                    count++;
                    break;
                }else{
                    map.put(arr[i][j], 1);
                }
            }
        }

        return count;
    }

    
    static int csolve(int[][] arr, int N){
        
        int count = 0;
        for(int i=0;i<N;i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<N;j++){
                if( map.containsKey(arr[j][i]) ){
                    count++;
                    break;
                }else{
                    map.put(arr[j][i], 1);
                }
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        // String temp = in.nextLine();
        
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            String temp = in.nextLine();

            int[][] arr = new int[N][N];
            int trace = 0;

            for( int j=0;j<N;j++ ){
                String[] line = in.nextLine().split(" ");
                for( int k=0;k<N;k++){
                    arr[j][k] = Integer.parseInt(line[k]);
                    if( j== k ) trace+= arr[j][k];
                } 
            }   
            
            int row = rsolve(arr,N);
            int col = csolve(arr,N);

            System.out.println("Case #" + i + ": " + trace + " "+ row + " " + col );
        }
    }
}
