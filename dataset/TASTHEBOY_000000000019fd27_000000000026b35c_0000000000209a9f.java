import java.util.*;
import java.io.*;


public class Solution{
	
	public static void main (String args []) {
      // Scanner in= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	   Scanner in= new Scanner(System.in);
		/*T is the number of test case*/
		String T=in.nextLine();
		String S=new String();
		String tmp=new String();
		tmp="";
		Character par;
		Character curr;
		Character prev=' ';
		ArrayList<String>arr=new ArrayList<String>();
		/*use remove(), add for queue, peek()*/
	
		Queue<Character>parentheses=new LinkedList<Character>();
		for(int i=0; i<Integer.parseInt(T); i++) {
		S=in.nextLine();
		
		for(int j=0; j<S.length(); j++) {
			curr=S.charAt(j);
			
			if(curr=='0') {
				
			 if(prev !='0' && prev != ' '&& parentheses.size()>=1) {
				 par=parentheses.remove();
				 tmp=tmp+par.toString()+curr.toString();
			 }
			 else{
				 tmp=tmp+curr.toString();
			 }
			  //prev=curr;
			}
			else {
				if(S.length()>1) {
					if(j==0 && S.length()>1) {
						 parentheses.add(')');
						 tmp=tmp +"("+curr.toString();
						}
					
					else if(curr !=prev && prev =='0'&& j!= S.length()-1) {
						parentheses.add(')');
						tmp=tmp+"("+curr.toString();
					}
					else if(curr !=prev && prev =='0'&& j== S.length()-1) {
						tmp=tmp+"("+curr.toString()+")";
					}
					else if(curr==prev && j!=S.length()-1) {
						tmp=tmp+curr.toString();
					}
					else if(curr==prev && j==S.length()-1 && parentheses.size()>=1) {
						par=parentheses.remove();
						tmp=tmp+curr.toString()+par.toString();
					}
					else if(curr !=prev && prev !=' ' && j==S.length()-1 && parentheses.size()>=1) {
						par=parentheses.remove();
						tmp=tmp+par.toString()+"("+curr.toString()+")";
					}
					else if(curr !=prev && prev !=' ' && j!=S.length()-1&& parentheses.size()>=1) {
						par=parentheses.remove();
						tmp=tmp+par.toString()+"("+curr.toString();
						parentheses.add(')');
					}
				}
				
				else if(S.length()==1) {
					tmp=tmp +"("+curr.toString()+")";
				}
				
			}
			prev=curr;
			
			
			
		
			     
			     
			
		}
		      prev=' ';
		      arr.add(tmp);
		      tmp="";
		
		
	}
		for(Integer i=1; i<=arr.size(); i++) {
			System.out.println("Case"+ " "+"#"+i.toString()+":"+" "+arr.get(i-1));
		}
		
		
		
			  
			 
		  
		
		  
		  
		
		
        in.close();
        
   
   }


}    
        

