import java.util.*;
class test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int sum=0;
        int col=0;
        int row=0;
        int a=0;
        int check=0;
        int b=0;
        int c=0;
        int instance=0;
        
        for(int test=0;test<m;test++){
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            
            for(int i=0;i<n;i++)
             for(int j=0;j<n;j++)
               arr[i][j]=sc.nextInt();
               
              for(int i=0;i<n;i++)
                sum+=arr[i][i];
                
          while(check<=n-1){
              a=arr[b][instance];
              c=arr[instance][b];
              for(int j=instance+1;j<n;j++){
                  if(a==arr[b][j])
                      row++;
                   break;
              }
              for(int j=instance+1;j<n;j++){
                  if(c==arr[j][b])
                      col++;
                  break;
              }
              instance++;
              if(instance==n-1){
                  instance=0;
                  b++;
                  check++;
              }
          }
              
              System.out.println(sum+" "+row+" "+col);
    }
}
}