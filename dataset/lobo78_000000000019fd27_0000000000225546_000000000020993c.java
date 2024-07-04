import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for(int i = 1; i<= x; i++){
            int N = Integer.parseInt(sc.nextLine());

            int [][] arr = new int [N][N];
            for(int j = 0; j<N; j++){
                String str = sc.nextLine();
                String [] strArr = str.split(" ");
                for(int k = 0; k< N;  k++){
                    arr[j][k] = Integer.parseInt(strArr[k]);
                }
            }
            System.out.println("Case #"+ i +": "+ trace(arr, N)
                    +" "+check(arr, N, true)+" "+check(arr, N, false));
        }
    }

    public static int check(int [][] arr, int N, boolean isRow){
        int count = 0;
        for(int i = 0; i< N; i++){
            Set<Integer> set = new LinkedHashSet<>();
            for(int j = 0; j<N; j++){
                if(isRow){
                    set.add(arr[i][j]);
                }else{
                    set.add(arr[j][i]);
                }
            }
            if(set.size()<N){
                count++;
            }
        }
        return count;
    }

    public static int trace(int[][] arr, int N){
        int sum = 0;
        for(int i = 0; i<N; i++){
            sum += arr[i][i];
        }
        return sum;
    }
}