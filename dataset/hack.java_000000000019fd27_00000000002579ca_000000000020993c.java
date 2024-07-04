import java.util.*;
class matrix{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int t= scan.nextInt();
        for(int i=0;i<t;i++)
        {
            int sum=0;
            int cr =0,cc=0;
            int n= scan.nextInt();
            Integer[][] array = new Integer[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    array[j][k]=scan.nextInt();
                    if(j==k)
                    {
                        sum=sum+array[j][k];
                    }
                    
                }
            }
          int r1 = array[0][0];
              for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(r1==array[j+1][k+1])
                    {
                        cr=cr+1;
                        break;
                   }
             }}
                     for(int l=0;l<n;l++)
            {
                for(int k=0;k<n;k++)
                {
                    if(r1==array[k+1][l+1]){
                        cc=cc+1;
                        break;
                   }
             }
            }
            System.out.println("Case #" + i+1 +": "+ sum +" "+cr+" "+cc);
        }
    }
}