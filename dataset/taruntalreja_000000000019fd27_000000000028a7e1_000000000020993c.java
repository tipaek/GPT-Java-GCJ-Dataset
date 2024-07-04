import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
      Scanner s = new Scanner(System.in); 
      int t= s.nextInt();
      for(int k=0;k<t;k++){
         // s.nextLine();
          int n= s.nextInt();
         // s.nextLine();
          int[][] matrix= new int[n][n];
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  matrix[i][j]=s.nextInt();
              }
            //  s.nextLine();
          }
        /*  System.out.println();
          System.out.print("case #"+(k+1)+": ");
          for(int i=0;i<n;i++){
              System.out.println();
              for(int j=0;j<n;j++){
                 System.out.print(matrix[i][j]+" ");
              }
             
          }*/
         
       System.out.println();
       System.out.print("case #"+(k+1)+": ");
       printTrace(matrix,n);
       invalidrowsCount(matrix,n);
       invalidcolCount(matrix,n);
          
          
      }
    }
   static void printTrace(int[][] matrix,int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=matrix[i][i];
        }
        System.out.print(sum+" ");
    }
    static void invalidrowsCount(int[][] matrix,int n){
        boolean []arr;
        int cnt=0;
        for(int i=0;i<n;i++){
            arr= new boolean[n];
            for(int j=0;j<n;j++){
                if(arr[matrix[i][j]-1]==true){
                    cnt++;
                    break;
                }else{
                   arr[matrix[i][j]-1]=true; 
                }
            }
        }
        System.out.print(cnt+" ");
    }
    static void invalidcolCount(int[][] matrix,int n){
        boolean []arr;
        int cnt=0;
        for(int i=0;i<n;i++){
            arr= new boolean[n];
            for(int j=0;j<n;j++){
                if(arr[matrix[j][i]-1]==true){
                    cnt++;
                    break;
                }else{
                   arr[matrix[j][i]-1]=true; 
                }
            }
        }
        System.out.print(cnt+" ");
    }
}
