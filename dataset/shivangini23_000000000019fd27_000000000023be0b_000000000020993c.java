import java.util.*;
public class Main{
    public static int matrixTrace(int arr[][],int n){
        int trace=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    trace+=arr[i][j];
            }
        }
        return trace;
    }
    
    public static int repeatedRows(int arr[][],int n){
        int rows=0;
        for(int i=0;i<n;i++){
            int first=arr[i][0];
            boolean allsame=true;
            for(int j=0;j<n;j++){
                if(arr[i][j]!=first){
                    allsame=false;
                    break;
                }
            }
            if(allsame)
                rows++;
        }
        return rows;
    }
    public static int repeatedCols(int arr[][],int n){
        int cols=0;
        for(int i=0;i<n;i++){
            int first=arr[i][0];
            boolean allsame=true;
            for(int j=0;j<n;j++){
                if(arr[j][i]!=first){
                    allsame=false;
                    break;
                }
            }
            if(allsame)
                cols++;
        }
        return cols;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t = 0;t<T;t++){
            
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int k = matrixTrace(arr,n);
            int r = repeatedRows(arr,n);
            int c = repeatedCols(arr,n);
            
            System.out.println("Case #"+(t+1) +": " + k +" "+r+" "+c);
            
        }
    }
}