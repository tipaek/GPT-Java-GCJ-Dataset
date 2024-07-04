import java.util.Scanner;
class codejam
{
    public static void main(String args[])
    {
        int tr=0,temp,s;
        int x,ele,ele1,countr=0,countc=0;
        Scanner in = new Scanner(System.in);
        x=in.nextInt();
        for(int i=0 ; i<x ; i++)
        {
            countr=0;
            countc=0;
            temp=i+1;
            s=in.nextInt();
            int a[][]=new int[s][s];
            for(int j=0 ; j<s ; j++)
            {
                for(int k=0 ; k<s ; k++)
                {
                    a[j][k]=in.nextInt();
                    if(j==k)
                    {
                        tr=tr+a[j][k];
                    }
                }
            }
            
            for(int l=0 ; l<s ; l++)
            {
                ele=a[l][0];
                for(int m=1 ; m<s ; m++)
                {
                    if(ele==a[l][m])
                    {
                        countr=countr+1;
                        break;
                    }
                }
                ele1=a[0][l];
                for(int m=1 ; m<s ; m++)
                {
                    if(ele1==a[m][l])
                    {
                        countc=countc+1;
                        break;
                    }
                }
                
            }
            System.out.println("Case #"+temp+": "+tr+" "+countr+" "+countc);
        }
    }
}