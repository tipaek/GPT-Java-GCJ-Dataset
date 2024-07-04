import java.util.*;
class test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int sum=0;
        int col=0;
        int row=0;
        int a=0;
        
        for(int test=0;test<m;test++){
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            
            for(int i=0;i<n;i++)
             for(int j=0;j<n;j++)
               arr[i][j]=sc.nextInt();
               
              for(int i=0;i<n;i++)
                sum+=arr[i][i];
                
              for(int i=0;i<n-1;i++){
                  a=arr[a][i];
                  for(int j=i+1;j<n;j++){
                      if(a==arr[i][j])
                       row++;
                  }
                  if(i==n-1)
                   a++;
              }
              
              
                for(int i=0;i<n-1;i++){
                  a=arr[i][a];
                  for(int j=i+1;j<n;j++){
                      if(a==arr[j][i])
                       col++;
                  }
                  if(i==n-1)
                   a++;
              }
              
              System.out.println(sum+" "+row+" "+col);
    }
}
}