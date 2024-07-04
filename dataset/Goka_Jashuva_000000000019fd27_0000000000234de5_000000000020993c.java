import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int sum=0;
        for(int i=1;i<=n;i++){
            int size=s.nextInt();
            int a[][]=new int[size][size];
            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    a[j][k]=s.nextInt();
                    if(j==k)
                    {
                        sum=sum+a[j][k];
                    }
                }
            }
            int p=0,col=0,row=0;
            for(int j=0;j<size;j++){
                while(p<size){
                for(int k=0;k<size;k++){
                    if(a[j][p]==a[j][k])
                    {
                        row++;
                        if(row>1)
                        {
                            break;
                        }
                    }
                    if(a[p][j]==a[k][j])
                    {
                        col++;
                        if(col>1)
                        {
                            break;
                        }
                    }
                  }
                  p++;
                }
            }
            System.out.println("Case #"+i+": "+sum+" "+row+" "+col);
            
        }
    }
}