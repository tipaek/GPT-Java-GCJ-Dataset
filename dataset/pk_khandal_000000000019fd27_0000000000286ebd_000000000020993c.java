import java.util.*;

class Solution
{
	public static void main(String args[])
	{
    Scanner s=new Scanner(System.in);
    int t=s.nextInt();
    int t1=1;
	
    while(t-->0)
    {
        int n=s.nextInt();
       // int m[][]=new int[n][n];
        int m;
        
        HashSet<Integer> h=new HashSet<Integer>();
        
        int col=0,row=0,trace=0;
        
        ArrayList<HashSet<Integer>> hc=new ArrayList<HashSet<Integer>>();
        
        boolean b[]=new boolean[n];
		for(int i=0;i<n;i++)
        {
            hc.add(new HashSet<Integer>());    
			b[i]=true;
        }
        
		
        for(int i=0;i<n;i++)
        {
			boolean f=true;
			
            for(int j=0;j<n;j++)
            {
                m=s.nextInt();
                if(h.contains(m)&&f)
                {
                    row++;
					f=false;
                }
                else
                {
                    h.add(m);
                }
                
                if(i==j)
                    trace+=m;
                
                if(hc.get(j).contains(m)&&b[j])
				{
                    col++;
					b[j]=false;
				}
                else
                    hc.get(j).add(m);
            }
			h.clear();
        }
        
        System.out.println("Case #"+(t1)+": "+trace+" "+row+" "+col);
		t1++;
        
    }
	}
}