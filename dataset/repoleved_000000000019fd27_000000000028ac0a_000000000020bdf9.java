import java.util.*;
import java.io.*;
public class Solution{
public static void main(String[] args){
		    Scanner in=new Scanner(System.in);
	    int t=in.nextInt();
	    
	    int tw=0;
	    
	    while(tw++<t){
	    	String s=" ";
	        int n;
	        n=in.nextInt();
	        int tc=0,tj=0;
	        
	        HashMap<Integer,Integer> hm=new HashMap<>();
	        ArrayList<Integer> al=new ArrayList<>();
	        for(int i=0;i<n;i++){
	        	int t1,t2;
	            t1=in.nextInt();
	            t2=in.nextInt();
	            hm.put(t1, t2);
	            al.add(t1);
	        }
	        Collections.sort(al);
	        
	        for(int i=0;i<n;i++){
	            int t1,t2;
	            t1=al.get(i);
	            t2=hm.get(t1);
	            if(t1>=tc){
	                s+="C";
	                tc=t2;
	            }else if(t1>=tj){
	                s+="J";
	                tj=t2;
	            }else{
	                s=" IMPOSSIBLE";
	                break;
	            }
	 
	        }
	        System.out.println("Case #"+tw+":"+s);
	        
	        
	    }
	    
	    






	}

    
    






}
