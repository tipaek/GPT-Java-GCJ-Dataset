import java.util.*;

class Solution
{
	public static void main(String args[])
	{
    Scanner scanner=new Scanner(System.in);
    int test=scanner.nextInt();
    int count=1;
	
    while(test-->0)
    {
        int no=scanner.nextInt();
     
        int m;
        
        int c=0,r=0,t=0;
        
        HashSet<Integer> h=new HashSet<Integer>();
        
        //count print ke liye
        System.out.print("Case #"+count+": ");
        count++;
        
        ArrayList<HashSet<Integer>> hash=new ArrayList<HashSet<Integer>>();
        
        boolean b[]=new boolean[no];
		for(int i=0;i<no;i++)
        {
            hash.add(new HashSet<Integer>());    
			b[i]=true;
        }
        
		
        for(int i=0;i<no;i++)
        {
			boolean f=true;
			
            for(int j=0;j<no;j++)
            {
                m=scanner.nextInt();
                if(h.contains(m)&&f)
                {
                    r++;
					f=false;
                }
                else
                {
                    h.add(m);
                }
                
                if(i==j)
                    t+=m;
                
                if(hash.get(j).contains(m)&&b[j])
				{
                    c++;
					b[j]=false;
				}
                else
                    hash.get(j).add(m);
            }
			h.clear();
        }
        
        System.out.println(t+" "+r+" "+c);
		
        
    }
	}
}