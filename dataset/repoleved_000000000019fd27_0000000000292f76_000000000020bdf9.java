import java.util.*;
import java.io.*;
public class Solution{
public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
    int t=in.nextInt();
    
    int tw=0;
    
    while(tw++<t){
    	boolean s=true;
        int n;
        n=in.nextInt();
        int tc=0,tj=0;
        
        HashMap<String,Integer> hm=new HashMap<>();
        HashMap<String,String> hmb=new HashMap<>();
        ArrayList<Integer> al=new ArrayList<Integer>();
        ArrayList<Integer> alb=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
        	int t1,t2;
        	String ss;
            t1=in.nextInt();
            ss=t1+"";
            t2=in.nextInt();
            while(hm.containsKey(t1+""))
            	ss="0"+t1;
            hm.put(ss, t2);
            al.add(t1);
            alb.add(t1);
        }
        Collections.sort(al);
        
        for(int i=0;i<n;i++){
            int t1,t2;
            String ss;
            t1=al.get(i);
            ss=t1+"";
            
            
            while(hm.get(ss)==null)
                ss="0"+ss;
           t2=hm.get(ss);
           hm.remove(ss);
            
            if(t1>=tc){
                //s+="C";
                tc=t2;
                hmb.put(ss,"C");
            }else if(t1>=tj){
               // s+="J";
                tj=t2;
                hmb.put(ss,"J");
            }else{
                s=false;
                break;
            }
 
        }
         String ret=" IMPOSSIBLE";
         
         if(s){
	        ret=" ";
	        for(int i:alb){
	            String ss;
	            ss=i+"";
	            
	            
	            while(hmb.get(ss)==null)
	                ss="0"+ss;
	          ret+=hmb.get(ss);
	           
	        }
	    }
        System.out.println("Case #"+tw+":"+ret);
        
        
    }
    
    






}



}
