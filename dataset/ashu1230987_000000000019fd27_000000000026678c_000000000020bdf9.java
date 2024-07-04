//package section3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	       int T = scan.nextInt();
	       for(int i=1;i<=T;i++) {
	    	   int N = scan.nextInt();
	    	   int flag=0;
	    	   answer.append("Case #"+i+":");
	    	   ArrayList<Integer> j = new ArrayList<>();
	           ArrayList<Integer> c = new ArrayList<>();
	           Queue<Character> ch = new LinkedList<>();
	    	   
	    	   for(int x=1;x<=N;x++) {
	    	   int Si= scan.nextInt();
	    	   int Ei=scan.nextInt();
	    	   if(toDo(c,Si,Ei)) {
	    		   c.add(Si);
	    		   c.add(Ei);
	    		   ch.add('C');
	    	   }
	    	   else if(toDo(j,Si,Ei)) {
	    		   j.add(Si);
	    		   j.add(Ei);
	    		   ch.add('J');
	    	   }
	    	   
	    	   else {
	    		   flag=1;
	    		    break;
	    	   }
	    	   }
	    	   if(flag==0) {
	    		   while(!ch.isEmpty()) {
	    			   answer.append(ch.remove());
	    		   }
	    	   }
	    	   else {
	    		   answer.append("IMPOSSIBLE");
	    	   }
	    	   answer.append("\n");
	    	  
	       }
	       System.out.println(answer);
	       scan.close();
		}
		public static boolean toDo(ArrayList<Integer> test,int strt,int end) {
			for(int i=0;i<test.size();i=i+2) {
				if(strt>=test.get(i)&&end<=test.get(i+1)) {
					return false;
				}
				else if(strt>test.get(i)&&strt<test.get(i+1)) {
					return false;
				}
				else if(end>test.get(i)&&end<test.get(i+1)) {
					return false;
				}
				else if(strt==test.get(i)||end==test.get(i+1)) {
					return false;
				}
			}
			return true;
       }
}

