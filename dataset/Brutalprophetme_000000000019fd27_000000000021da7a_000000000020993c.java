import java.util.*;
 class java{
    public static void main(String [] args){
        int sum=0;
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.next());
       int N=Integer.parseInt(sc.next());
       
        inr arr[][]=new int[N][N];
        
        while(t-->0)
        {
       for(int i=0;i<N;i++)
       {
           for(int j=0;j<N;j++){
         arr[i][j]=Integer.parseInt(sc.next());
             
           }
       }
        for(int i=0;i<N;i++){
       sum+=arr[i][j];
       j++;
        }
        System.out.println(sum);
        }
       
    }
}