import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int x,i;
		for(x=1;x<=T;x++){
		    //HashSet<Character> dSet = new HashSet<Character>();
		    int U = sc.nextInt();
		    long digit[]=new long[26];
		    for(int k=0;k<26;k++)
		    digit[k]=10;
		    for(i=1;i<=10000;i++){
		        long q=sc.nextLong();
		        String s=sc.nextLine().trim();
		        int l=s.length();
		        char ch=s.charAt(0);
		       // dSet.add(ch);
		        if(l==1){
		            if(q<10){
		                 if(digit[ch-65]>q)
		                    digit[ch-65]=q;
		            }
		           // else{
		               // int r=q/((long)Math.pow(10,(U-1)));
		                
		           // }
		        }
		        else{
		            long r=q/((long)Math.pow(10,(U-1)));
		            if(digit[ch-65]>r)
		                    digit[ch-65]=r;
		            if(q==10){
		                char c=s.charAt(1);
		                digit[c-65]=0;
		            }
		        }
		        
		    }
		    HashMap<Character, Long> map  = new HashMap<Character,Long>(); 
		     for(int k=0;k<26;k++){
		         if(digit[k]<10)
		         {
		             char c1=(char)(k+65);
		             map.put(c1,digit[k]);
		         }
		     }
		     
		     
		     // Create a list from elements of HashMap 
		List<Map.Entry<Character, Long> > list = 
			new LinkedList<Map.Entry<Character, Long> >(map.entrySet()); 

		// Sort the list 
		Collections.sort(list, new Comparator<Map.Entry<Character, Long> >() { 
			public int compare(Map.Entry<Character, Long> o1, 
							Map.Entry<Character, Long> o2) 
			{ 
				return (o1.getValue()).compareTo(o2.getValue()); 
			} 
		}); 
		System.out.print("Case #" + x + ": ");
		
		for (Map.Entry<Character, Long> aa : list) { 
		    System.out.print(aa.getKey());
		
		} 
		System.out.println();
        
	}
}
}
