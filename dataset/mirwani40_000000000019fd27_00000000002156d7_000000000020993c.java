import java.util.*;

public class Solution {

   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt(); int a[][]=new int[n][n];
            HashSet<Integer> row=new HashSet<Integer>();
            HashSet<Integer> col=new HashSet<Integer>();
            int countr=0,countc=0,sumd=0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++ )
                {
                    a[j][k]=sc.nextInt();
                    if(k==j)
                        sumd=sumd+a[j][k];
                }
            }
            for(int k=0;k<n;k++)
            {setval(row,n);
            setval(col,n);
                for(int j=0;j<n;j++)
                {
                   row.remove(a[k][j]);
                   col.remove(a[j][k]);
                   
                }
                if(!row.isEmpty())
                   countr++;
                if(!col.isEmpty())
                    countc++;
            }
            System.out.println("Case #"+(i+1)+": "+sumd+" "+countr+" "+countc);
         }
       
    }
    static void setval(HashSet<Integer> num,int n)
    {
        for(int i=0;i<n;i++)
            num.add(i+1);
    }
    
    
}
