
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int min,f=0,f1=0,min1,N,n,cr=0,cc=0;
        
        N=sc.nextInt();
        int[] sum=new int[N];
        int[] c=new int[N];
        int[] c1=new int[N];
        for(int l=0;l<N;l++){
        n=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        //trace..
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==j){
                sum[l]=sum[l]+arr[i][j];
                }
            }
        }
       
        //for row..
      for(int i=0;i<arr.length;i++){
          f=0;
          for(int j=0;j<arr.length;j++){
              min1=arr[i][j];
              for(int k=j+1;k<arr.length;k++){
                  if(min1==arr[i][k])
                  {
                      cr++;
                      f=1;
                      break;
                  }
              }
              if(f==1)
                  break;
          }
      }
      c[l]=cr;
      cr=0;
        
        //for column
        for(int j=0;j<arr.length;j++){
            f1=0;
            for(int i=0;i<arr.length;i++){
                min=arr[i][j];
              for(int k=i+1;k<arr.length;k++){
                  if(min==arr[k][j])
                  {
                      cc++;
                      f1=1;
                      break;
                  }
              }
              if(f1==1)
                  break;
            }
        }
        c1[l]=cc;
        cc=0;
        
    }
        for(int a=0;a<N;a++){
            System.out.println("Case #"+(a+1)+": "+sum[a]+" "+c[a]+" "+c1[a]);
        }
    }
}
