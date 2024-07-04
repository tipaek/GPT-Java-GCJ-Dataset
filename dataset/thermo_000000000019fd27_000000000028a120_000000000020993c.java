import java.util.Scanner;
public class vestigium
 {
public static void main(String args[])
    {
         Scanner Sc= new Scanner(System.in);
        int ar[][]=new int[100][100];
        int T=Sc.nextInt();
        int N=Sc.nextInt();
      
        for (int k=1;k<=T;k++)
        {
        for(int i=0;i<=N;i++)
        {
            for (int j=0;j<=N;j++)
            {
                ar[i][j]=Sc.nextInt();
            }
        
        }
        for(int i=0;i<=N;i++)
        {
            for (int j=0;j<=N;j++)
            {
                temp=ar[i][j];
                if(i==j)
                sum=sum+ar[i][j];
                else if(ar[i+1][j+1]==ar[i][j])
                r++;
                else if(ar[j+1][i+1]==ar[j][i])
                c++;
            }
        
        }
        System.out.println("case"+k+":" +r+c);
    
        }
        }
 }