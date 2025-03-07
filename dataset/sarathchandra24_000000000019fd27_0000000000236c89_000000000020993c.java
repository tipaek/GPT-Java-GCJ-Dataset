
import java.util.Scanner;

public class RoundA1 {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int cases=sin.nextInt();
        for (int i=0;i<cases;i++){
            int n=sin.nextInt(), rowcount=0, column_count=0;
            int[][] mat = new int[n][n];
            for (int row=0;row<n;row++) {
                for (int col = 0; col < n; col++)
                    mat[row][col] = sin.nextInt();
            }
            for (int row=0;row<n;row++){
                if (isRepeating(mat[row])){
                    rowcount++;
                }
            }
            int[][] tranpose = new int[n][n];
            for (int temp=0;temp<n;temp++)
                for (int temp2=0;temp2<n;temp2++)
                    tranpose[temp][temp2]=mat[temp2][temp];
            for (int row=0;row<n;row++){
                if (isRepeating(tranpose[row])){
                    column_count++;
                }
            }
            int case_num=i+1;
            System.out.println("Case #"+case_num+": "+trace(mat)+" "+rowcount+" "+column_count);
        }
    }

    public static boolean isRepeating(int[] arr){
        int i,j,size=arr.length;
        for (i = 0; i < size; i++)
        {
            for (j = i + 1; j < size; j++)
            {
                if (arr[i] == arr[j])
                    return true;
            }
        }
        return false;
    }
    public static int trace(int[][] arr){
        int trace=0,size=arr.length;
        for (int i=0;i<size;i++){
            trace+=arr[i][i];
        }
        return trace;
    }
}