import java.util.Arrays;
import java.util.*;
 class fan
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
			long u=sc.nextLong();
			HashMap<Character,Long> h=new HashMap();
			long a[]=new long[10000];
			
			
			for(i=0;i<10000;i++)
			{
				 a[i]=sc.nextLong();
				 String s=sc.next();
				 for(int j=0;j<s.length();j++)
				 {
					 if(h.get(s.charAt(j))==null)
					 {
						 h.put(s.charAt(j),(long)1);
					 }
					 else
						 h.put(s.charAt(j), h.get(s.charAt(j))+1);
				
				 }
			}
			 List<Map.Entry<Character, Long> > list = 
		               new LinkedList<Map.Entry<Character, Long> >(h.entrySet()); 
		  
		       		        Collections.sort(list, new Comparator<Map.Entry<Character, Long> >() { 
		            public int compare(Map.Entry<Character, Long> o1,  
		                               Map.Entry<Character, Long> o2) 
		            { 
		                return (o1.getValue()).compareTo(o2.getValue()); 
		            } 
		        }); 
		          
		       
		        HashMap<Character, Long> temp = new LinkedHashMap<Character, Long>(); 
		        for (Map.Entry<Character, Long> aa : list) { 
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