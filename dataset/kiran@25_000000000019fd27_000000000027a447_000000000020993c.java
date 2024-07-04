import java.util.*;
public class Solution{
    public static void main(String[] args){
    int n,m,i,j;
    Scanner st=new Scanner(System.in);
    n=st.nextInt();
    while(n>0)
    {
        int count=0,trace=0;
        m=st.nextInt();
        int[][] a=new int[m][m];
        for(i=0;i<m;i++)
        {
            for(j=0;j<m;j++)
            {
                a[i][j]=st.nextInt();
            }
        }
        for(i=0;i<m;i++)
        {
            for(j=0;j<m;j++)
            {
                if(i==j)
                    trace+=a[i][j];
            }
        }
        System.out.print(trace+" ");
        HashMap<Integer,Integer> row=new HashMap<Integer,Integer>();
        int r1=0;
        for(i=0;i<m;i++)
        {
            int r=0;
            for(j=0;j<m;j++)
            {
                if(!row.containsKey(a[i][j]))
                    row.put(a[i][j],j);
                else
                    r=1;
            }
            if(r==0)
                r1=0;
            else
                r1=r1+1;
            row.clear();
        }
         HashMap<Integer,Integer> col=new HashMap<Integer,Integer>();
        int c1=0;
        int q=m;
        for(i=0;i<m;i++)
        {
            int c=0;
            for(j=0;j<m;j++)
            {
                if(col.containsKey(a[j][i]))
                    c=1;
                else
                    col.put(a[j][i],j);
            }
            if(c==0)
                c1=0;
            else
                c1=c1+1;
            col.clear();
        }
        System.out.println(r1+" "+c1);
        n=n-1;
    }
  }
}