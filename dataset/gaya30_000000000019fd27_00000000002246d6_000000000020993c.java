import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt(),tt=1;
        while(tt<=test)
        {
            ArrayList<Integer> al=new ArrayList<>();
            int diag=0,row=0,col=0,n=sc.nextInt(),mat[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> h=new HashSet<>();
                int flag=0;
                for(int j=0;j<n;j++)
                {
                    int a=sc.nextInt(),k=i-1;
                    mat[i][j]=a;
                    if(i==j)
                    diag+=a;
                    if(h.contains(a) && flag==0)
                    {
                      row++;
                      flag=1;
                    }
                    else h.add(a);
                    while(!al.contains(j) && k>=0)
                    {
                        if(mat[k][j]==a)
                        {
                            al.add(j);
                            col++;
                            break;
                        }
                        k--;
                    }
                }
            }
            System.out.println("Case #"+tt+": "+diag+" "+row+" "+col);
            tt++;
        }
    }
}