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
						 
						 if(curr=='1') {
						 tmp=tmp +"("+curr.toString();
						 parentheses.add(')');
						}
						 else if(curr=='2') {
							 tmp=tmp +"(("+curr.toString();
							 parentheses.add(')');
                             parentheses.add(')');
							}
						 else if(curr=='3') {
							 tmp=tmp +"((("+curr.toString();
							 parentheses.add(')');
                             parentheses.add(')');
                             parentheses.add(')');
                          
							}
					    else if(curr=='4') {
								 tmp=tmp +"(((("+curr.toString();
								 parentheses.add(')');
								 parentheses.add(')');
	                             parentheses.add(')');
	                             parentheses.add(')');
	                            
								}
						 
					    else if(curr=='5') {
							 tmp=tmp +"((((("+curr.toString();
							 parentheses.add(')');
                            parentheses.add(')');
                            parentheses.add(')');
                            parentheses.add(')');
                            parentheses.add(')');
                         
							}
					    else if(curr=='6') {
								 tmp=tmp +"(((((("+curr.toString();
								 parentheses.add(')');
								 parentheses.add(')');
		                         parentheses.add(')');
		                         parentheses.add(')');
		                         parentheses.add(')');
		                         parentheses.add(')');
	                            
								}
					    else if(curr=='7') {
							 tmp=tmp +"((((((("+curr.toString();
							 parentheses.add(')');
							 parentheses.add(')');
							 parentheses.add(')');
	                         parentheses.add(')');
	                         parentheses.add(')');
	                         parentheses.add(')');
	                         parentheses.add(')');
							}
					 
				    else if(curr=='8') {
						 tmp=tmp +"(((((((("+curr.toString();
						   parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
						   parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
                    
						}
				    else if(curr=='9') {
				    	 tmp=tmp +"((((((((("+curr.toString();
						   parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
						   parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
	                       parentheses.add(')');
							}
						 
						 
						 
						 
						 
						 
						 
					}			 
					
					else if(curr !=prev && prev =='0'&& j!= S.length()-1) {
						 if(curr=='1') {
							 tmp=tmp +"("+curr.toString();
							 parentheses.add(')');
							}
							 else if(curr=='2') {
								 tmp=tmp +"(("+curr.toString();
								 parentheses.add(')');
	                             parentheses.add(')');
								}
							 else if(curr=='3') {
								 tmp=tmp +"((("+curr.toString();
								 parentheses.add(')');
	                             parentheses.add(')');
	                             parentheses.add(')');
	                          
								}
						    else if(curr=='4') {
									 tmp=tmp +"(((("+curr.toString();
									 parentheses.add(')');
									 parentheses.add(')');
		                             parentheses.add(')');
		                             parentheses.add(')');
		                            
									}
							 
						    else if(curr=='5') {
								 tmp=tmp +"((((("+curr.toString();
								 parentheses.add(')');
	                            parentheses.add(')');
	                            parentheses.add(')');
	                            parentheses.add(')');
	                            parentheses.add(')');
	                         
								}
						    else if(curr=='6') {
									 tmp=tmp +"(((((("+curr.toString();
									 parentheses.add(')');
									 parentheses.add(')');
			                         parentheses.add(')');
			                         parentheses.add(')');
			                         parentheses.add(')');
			                         parentheses.add(')');
		                            
									}
						    else if(curr=='7') {
								 tmp=tmp +"((((((("+curr.toString();
								 parentheses.add(')');
								 parentheses.add(')');
								 parentheses.add(')');
		                         parentheses.add(')');
		                         parentheses.add(')');
		                         parentheses.add(')');
		                         parentheses.add(')');
								}
						 
					    else if(curr=='8') {
							 tmp=tmp +"(((((((("+curr.toString();
							   parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
							   parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
	                    
							}
					    else if(curr=='9') {
					    	 tmp=tmp +"((((((((("+curr.toString();
							   parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
							   parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
		                       parentheses.add(')');
								}
							 
					}
					else if(curr !=prev && prev =='0'&& j== S.length()-1) {
						 if(curr=='1') {
							 tmp=tmp +"("+curr.toString()+")";
							 
							}
							 else if(curr=='2') {
								 tmp=tmp +"(("+curr.toString()+"))";
								 
								}
							 else if(curr=='3') {
								 tmp=tmp +"((("+curr.toString()+")))";
								
	                          
								}
						    else if(curr=='4') {
									 tmp=tmp +"(((("+curr.toString()+"))))";
									 
		                            
									}
							 
						    else if(curr=='5') {
								 tmp=tmp +"((((("+curr.toString()+")))))";
								
	                         
								}
						    else if(curr=='6') {
									 tmp=tmp +"(((((("+curr.toString()+"))))))";
									 
		                            
									}
						    else if(curr=='7') {
								 tmp=tmp +"((((((("+curr.toString()+")))))))";
								
								}
						 
					    else if(curr=='8') {
							 tmp=tmp +"(((((((("+curr.toString()+"))))))))";
							   
							}
					    else if(curr=='9') {
					    	 tmp=tmp +"((((((((("+curr.toString()+")))))))))";
							   
								}
							 
					}
					else if(curr==prev && j!=S.length()-1) {
						tmp=tmp+curr.toString();
					}
					else if(curr==prev && j==S.length()-1 && parentheses.size()>=1) {
						if(curr=='1') {
							par=parentheses.remove();
							tmp=tmp+curr.toString()+par.toString();
						}
						if(curr=='2') {
							par=parentheses.remove();
							par=parentheses.remove();
							tmp=tmp+curr.toString()+par.toString()+par.toString();
						}
						if(curr=='3') {
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							tmp=tmp+curr.toString()+par.toString()+par.toString()+par.toString();
						}
						if(curr=='4') {
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							tmp=tmp+curr.toString()+par.toString()+par.toString()+par.toString()+par.toString();
						}
						if(curr=='5') {
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							tmp=tmp+curr.toString()+par.toString()+par.toString()+par.toString()+par.toString()+par.toString();
						}
						if(curr=='6') {
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							tmp=tmp+curr.toString()+par.toString()+par.toString()+par.toString()+par.toString()+par.toString()+par.toString();
						}
						
						if(curr=='7') {
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							tmp=tmp+curr.toString()+par.toString()+par.toString()+par.toString()+par.toString()+par.toString()+par.toString()+par.toString();
						}
						if(curr=='8') {
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							tmp=tmp+curr.toString()+"))))))))";
						}
						if(curr=='9') {
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							par=parentheses.remove();
							tmp=tmp+curr.toString()+")))))))))";
						}
						
						
						
						
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
        

