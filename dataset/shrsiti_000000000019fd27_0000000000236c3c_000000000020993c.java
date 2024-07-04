import java.util.*;
class MagiclationSquare{
    public static void main(String[] args){
         Scanner sc= new Scanner(System.in);
         int t= sc.nextInt();
         while(t!=0){
            int[] result=new int[3];
            result= findThetrace(t);
            t--;
            system.out.println("case #"+(t+1)+result);
         }
    }
    
    public static int findThetrace(int t){
        int k=0, r=0,c=0;
        int N=sc.nextInt();
        int sum=0;
        int col=0,row=0;
        int[] ans= new int[3];
        int[][] arr= new int[N][N];
         for(int i=0;i<N;i++){
             for(int j=0;j<N;j++){
                 arr[i][j]=sc.nextInt();
                 if(i==j){
                     sum+=arr[i][j];
                 }
                 
                 if(arr[j]==arr[j-1]){
                     col+=1;
                 }
                 
             }
             if(arr[i][j]==arr[i-1][j-1]){
                 row+=1;
             }
         }
         
         ans[0]=sum;
         ans[1]=row;
         ans[2]=col;
         
        return ans;
    }
    
    
}