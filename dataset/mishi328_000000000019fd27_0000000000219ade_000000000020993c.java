import java.util.*;
class Matrix
{
    public static void main(String []args)
    {
        Scanner sn=new Scanner(System.in);
        Matrix m=new Matrix();
        int T=sn.nextInt();
        while(T>0)
        {
            int N=sn.nextInt();
            int arr[][]=new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    arr[i][j]=sn.nextInt();
                }
            }
            System.out.print("Case #"+T+": ");
            m.compute(N,arr);
            System.out.println();
            T--;
        }
    }
    void compute(int N,int arr[][])
    {
        int trace=0, num1=0,num2=0,c1=0,c2=0,cr=0,cc=0;
        for(int i=0;i<N;i++)
        {
          for(int j=0;j<N;j++)
          {
              if(i==j)
              trace=trace+arr[i][j];
              num1=arr[i][j];
              num2=arr[j][i];
              for(int k=j+1;k<N;k++)
              {
                  if(num1==arr[i][k])
                  c1=1;
                  if(num2==arr[k][i])
                  c2=1;
              }
          } if(c1==1){cr++;c1=0;}
          if(c2==1){cc++;c2=0;}
        }
        System.out.println(trace+" "+cr+" "+cc);
    }
}