    import java.util.*;
    import java.io.*;
public class Vestigium{

     public static void main(String []args){
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = input.nextInt();;
        for(int t = 1; t <= testCase; t++){
            int sum = 0;
            int r = 0;
            int c = 0;
            int N = input.nextInt();
            int[][] arr = new int[N][N];
            for (int n = 0; n < N; n++){
                    for (int j = 0; j < N; j++) arr[n][j] = input.nextInt();
            }
            for(int n =0; n < N; n++ ) sum += arr[n][n];
            for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<Integer>();
            Set<Integer> colSet = new HashSet<Integer>();
            for (int j = 0; j< N; j++){
                rowSet.add(arr[i][j]);
                colSet.add(arr[j][i]);
            }
            r = rowSet.size() == N ? r : r + 1;
            c = colSet.size() == N ? c : c + 1;
            }
            System.out.println("Case #" + t + ": " + sum + " " + r + " " + c);
        }
            
     }
}