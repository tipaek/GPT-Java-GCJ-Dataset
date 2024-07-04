import java.util.*;
class Solution
{
    public static void main(String ar[])
    {
        Scanner scan= new Scanner(System.in);
        int test=scan.nextInt();
        int x=1;
        while(x++<=test)
        {
            int n=scan.nextInt(),trace=0;
            HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
            hm.put(-1,-1);
            ArrayList<HashMap<Integer,Integer>> row= new ArrayList<HashMap<Integer,Integer>>();
            ArrayList<HashMap<Integer,Integer>>col= new ArrayList<HashMap<Integer,Integer>>();
            for(int i=0;i<n;i++)
            {
                row.add(hm);
                col.add(hm);
            }
            int a[][]= new int[n][n];
            int countr=0,countc=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=scan.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                    row.get(i).put(a[i][j],i);
                    col.get(j).put(a[i][j],j);
                    
                        
                }
            }
            for(int i=0;i<n;i++)
            {
                if(row.get(i).size()<n)countr++;
                if(col.get(i).size()<n)countc++;
            }
        System.out.print("Case #"+(x-1)+": ");
        System.out.print(trace+" "+" "+countr+" "+countc);
        }
    }
}