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
                }
            }
            for(int t=0 ; t<s ; t++)
            {
                tr=tr+a[t][t];
            }
            for(int i=0 ; i<s ; i++)
            {
                ele=a[i][0];
                for(int j=1 ; j<s ; j++)
                {
                    if(ele==a[i][j])
                    {
                        countr=countr+1;
                        break;
                    }
                }
                ele1=a[0][i];
                for(int j=1 ; j<s ; j++)
                {
                    if(ele1==a[j][i])
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