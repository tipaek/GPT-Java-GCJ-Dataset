import java.util.*;
class Solution
{
	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int U=in.nextInt();
	       HashMap<Character, Integer> map= new HashMap<>(); 
	     ArrayList<String> aLS=new ArrayList<String>();
	     ArrayList<Integer> aLI=new ArrayList<Integer>();
	     
	        for(int i=0;i<10000;i++)
	        {
	            int Mi=in.nextInt();
	            String s=in.next();
	            if(s.length()==1)
	            {
	                char c=s.charAt(0);
                    if (map.containsKey(c) ) 
                    { 
                        if(map.get(c)>Mi)
                        map.put(c,Mi);
                    }else map.put(c,Mi); 
	            }else 
	            {
	                aLS.add(s);
	                aLI.add(Mi);
	            }
	        }
	        int z=0;
	        char cs[]=new char[10];
	        int val[]=new int[10];
	        
	       for (Map.Entry<Character, Integer> entry : map.entrySet())
	       { z++;
    	   }
    	   int remain=10-z;
    	   int t=0;
	       while(remain>0 && t<aLS.size())
	       {
	           char a=aLS.get(t).charAt(0);
	           int aM=aLI.get(t)/10;
	           char b=aLS.get(t).charAt(1);
	           int bM=aLI.get(t)%10;
	           t++;
	            if(map.containsKey(a) && map.get(a)==aM && (!map.containsKey(b) || map.get(b)>bM) ){map.put(b,bM);}
	           else if(map.containsKey(b) && map.get(b)==bM && (!map.containsKey(a) || map.get(a)>aM) ){map.put(a,aM);}
	       }
	       z=0;
	       for (Map.Entry<Character, Integer> entry : map.entrySet())
	       { 
    			cs[z] = entry.getKey();
    			val[z++] = entry.getValue();
    			
	       }
	        int n=10;
	        for(int i=0; i < n; i++)
	        {  
                 for(int j=1; j < (n-i); j++)
                 {  
                          if(val[j-1] > val[j])
                          {  
                                 //swap elements  
                                 int temp = val[j-1];  
                                 val[j-1] = val[j];  
                                 val[j] = temp;
                                   
                                 char temp1 = cs[j-1];  
                                 cs[j-1] = cs[j];  
                                 cs[j] = temp1;
                         }  
                          
                 }  
            }  
	        String res="";
	        for(int i=0;i<10;i++)res+=cs[i];
	        System.out.println("Case #"+tc+": "+res);
	   }
	    
	}
}
