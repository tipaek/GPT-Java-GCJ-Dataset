import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args)throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.valueOf(br.readLine());

        for(int t=1;t<=T;t++) {
            String temp[]=br.readLine().split(" ");
            int N=Integer.valueOf(temp[0]);
            int K=Integer.valueOf(temp[1]);
            int arr[][]=new int [N][N];

            boolean flag=createMatrix(arr,0,0,K);

            if(flag) {
                System.out.format("Case #%d: %s\n", t,"POSSIBLE");
                printArr(arr);
            }else
                System.out.format("Case #%d: %s\n", t,"IMPOSSIBLE");

        }
        br.close();

    }
    public static void printArr(int[][] arr){
        for(int[] n:arr){
            System.out.print(n[0]);
            for(int i=1;i<n.length;i++)
                System.out.print(" "+n[i]);

            System.out.println();
        }
    }
    public static int getTrace(int[][] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
        }
        return sum;
    }


    public static boolean createMatrix(int[][]arr, int row, int col,int k){
        //System.out.format("row= %d, col= %d\n",row,col);
        for(int val=1;val<=arr.length;val++){
            boolean flag=isValid(arr, val,row,col);
            if(!flag) continue;

            arr[row][col]=val;
            //printArr(arr);
            if(col+1<arr.length)
                flag=createMatrix(arr,row,col+1,k);
            else if(row+1<arr.length)
                flag=createMatrix(arr,row+1,0,k);
            else if(getTrace(arr)==k){
                flag=true;
            }else {
                flag=false;
            }

            if(!flag){
                arr[row][col]=0;
            }else
                return true;
        }

        return false;

    }

    public static boolean isValid(int[][] arr, int val, int row, int col){

        for(int i=0;i<row;i++){
            if(arr[i][col]==val) return false;
        }
        for(int i=0;i<col;i++){
            if(arr[row][i]==val) return false;
        }
        return true;
    }
}
