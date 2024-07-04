import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
     int start;
     int end;
     Node(int start , int end){
         this.start= start;
         this.end =end;
     }
}

class Sortbystart implements Comparator<Node> 
{ 
    public int compare(Node a, Node b) 
    { 
         return a.start - b.start; 
    } 
} 

public class Solution
{

	public static void main (String[] args) throws IOException
	{
	    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         int itr = scan.nextInt();
         int x =1;
	      while(itr-->0){
	          int n = scan.nextInt();
	          ArrayList<Node> llist = new ArrayList<Node>();
	          for(int i = 0 ;i<n ;i++){
	               int s = scan.nextInt(); 
	               int e = scan.nextInt();
	               llist.add(new Node(s,e));
	          }
	          
	        Collections.sort(llist, new Sortbystart());
	        String s = "";
	        int eC=0;
	        int eJ = 0;
	        for(int i = 0 ;i<n ;i++){
	            if(llist.get(i).start>=eC && llist.get(i).start>=eJ){
	                  int diff1 = llist.get(i).start-eJ;
	                  int diff2 = llist.get(i).start-eC;
	                  if(diff1<=diff2){
	                      s+="J";
	                      eJ= llist.get(i).end;
	                  }else{
	                      s+="C";
	                      eC = llist.get(i).end;
	                  }
	                 
	            }else{
	                
	                  if(llist.get(i).start>=eC){
	                      eC = llist.get(i).end;
	                      s+="C";
	                  }else if(llist.get(i).start>=eJ){
	                      eJ = llist.get(i).end;
	                      s+="J";
	                  }else{
	                      s = "IMPOSSIBLE";
	                  }
	                
	                
	                
	                
	            }
	            //System.out.println(eC+" "+eJ);
	        }
		     
		    System.out.println("Case #"+x+": "+s);
		    x++;
		     
		}
	}
}
