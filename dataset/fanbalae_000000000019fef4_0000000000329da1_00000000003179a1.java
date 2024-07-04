import java.util.Arrays;
import java.util.*;
 class Solution
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			int u=sc.nextInt();
			HashMap<Character,Integer> h=new HashMap();
			long a[]=new long[10000];
			
			
			for(i=0;i<10000;i++)
			{
				 a[i]=sc.nextLong();
				 String s=sc.next();
				 for(int j=0;j<s.length();j++)
				 {
					 if(h.get(s.charAt(j))==null)
					 {
						 h.put(s.charAt(j),1);
					 }
					 else
						 h.put(s.charAt(j), h.get(s.charAt(j))+1);
				
				 }
			}
			 List<Map.Entry<Character, Integer> > list = 
		               new LinkedList<Map.Entry<Character, Integer> >(h.entrySet()); 
		  
		       		        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() { 
		            public int compare(Map.Entry<Character, Integer> o1,  
		                               Map.Entry<Character, Integer> o2) 
		            { 
		                return (o1.getValue()).compareTo(o2.getValue()); 
		            } 
		        }); 
		          
		       
		        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>(); 
		        for (Map.Entry<Character, Integer> aa : list) { 
		            temp.put(aa.getKey(), aa.getValue()); 
		        }
		        
		        Iterator it = temp.entrySet().iterator();
		        char ans[]=new char[10];
		        int j=0;
		        while (it.hasNext()) 
		        {
		            Map.Entry pair = (Map.Entry)it.next();
		            ans[j]=(char)pair.getKey();
		            j++;
		            
		        }
		        String an="";
		        an+=ans[0];
		        for(i=9;i>=1;i--)
		        	an+=ans[i];
		        System.out.println("Case #"+(p-t)+": "+an);
			
		}
		
	 }
} 