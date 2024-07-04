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
            HashSet<Integer> h= new HashSet<Integer>();
            h.add(0);
	    //HashSet<Integer> hm= new HashSet<Integer>();
            int n=scan.nextInt(),trace=0;
            ArrayList<HashSet<Integer>> row= new ArrayList<HashSet<Integer>>();
            ArrayList<HashSet<Integer>>col= new ArrayList<HashSet<Integer>>();
            for(int i=0;i<n;i++)
            {
                row.add(new HashSet<Integer>());
                col.add(new HashSet<Integer>());
            }
	    //System.out.println(row+" "+col);
            int a[][]= new int[n][n];
            int countr=0,countc=0;
            for(int i=0;i<n;i++)
            {
		    //HashSet<Integer> hm= new HashSet<Integer>();
                for(int j=0;j<n;j++)
                {
                    a[i][j]=scan.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                    //hm.add(add[i][i])
                    row.get(i).add(a[i][j]);
		            col.get(j).add(a[i][j]);
                //System.out.println(col.get(0)+" "+col.get(1)+" "+col.get(2));    
                        
                }
            }
            for(int i=0;i<n;i++)
            {
		//System.out.println(row.get(i)+" "+col.get(i));
                if(row.get(i).size()<n)countr++;
                if(col.get(i).size()<n)countc++;
            }
        System.out.print("Case #"+(x-1)+": ");
        System.out.println(trace+" "+countr+" "+countc);
        }
    }
}