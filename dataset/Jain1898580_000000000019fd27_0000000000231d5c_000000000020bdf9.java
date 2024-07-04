/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    
    	// function to sort hashmap by values 
	public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) 
	{ 
		// Create a list from elements of HashMap 
		List<Map.Entry<Integer, Integer> > list = 
			new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 

		// Sort the list 
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
			public int compare(Map.Entry<Integer, Integer> o1, 
							Map.Entry<Integer, Integer> o2) 
			{ 
				return (o1.getValue()).compareTo(o2.getValue()); 
			} 
		}); 
		
		// put data from sorted list to hashmap 
		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
		for (Map.Entry<Integer, Integer> aa : list) { 
			temp.put(aa.getKey(), aa.getValue()); 
		} 
		return temp; 
	} 
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i =0;i<t;i++){
		    int n = sc.nextInt();
		    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		    for(int j=0;j<n;j++){
		        int s = sc.nextInt();
		         int e = sc.nextInt();
		          hm.put(s,e);
		        
		    }
		    
		    	Map<Integer, Integer> hm1 = sortByValue(hm); 
         int c=0,j=0;
         boolean posible = true;
         ArrayList<String> sol = new ArrayList<String>();
		// print the sorted hashmap 
		for (Map.Entry<Integer, Integer> en : hm1.entrySet()) { 
		//	System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue()); 
		if(c>en.getKey()&&j>en.getKey()){
		    
		    posible = false;
		    
		}else{
		    if(c<=en.getKey()){
		        c = en.getValue();
		        sol.add("C");
		    }else{
		         j = en.getValue();
		        sol.add("J");
		    }
		    
		    
		    
		}
		} 
		    
		
		
		if(posible){
		    System.out.print("Case #" + (i + 1) + ": ");
		    for(int k =0;k<n;k++)
		    System.out.print(sol.get(k));
		    
		}else{
		    System.out.print("Case #" + (i + 1) + ": "+"IMPOSSIBLE");
		}
		System.out.println();
	}
}}
