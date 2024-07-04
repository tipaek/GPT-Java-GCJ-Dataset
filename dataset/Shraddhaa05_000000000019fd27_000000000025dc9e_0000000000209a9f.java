import java.util.*;
class Solution{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
        String S="";
        String s1[]=new String[T];
        sc.nextLine();
        for(int x=0;x<T;x++){
        	s1[x]="";
        	S=sc.nextLine();
        	int i=0;
        	int a=0,prev=0,sub1=0,sub2=0;
        	int len=S.length();
        	int last=Character.getNumericValue(S.charAt(len-1));
        	while(i<len){
                if(i==0 && S.charAt(i)=='0'){
                	s1[x]=s1[x]+"0";
                	i++;
                }
                	
                else{

                	a=Character.getNumericValue(S.charAt(i));
                	if(i==0){
                	   for(int j=0;j<a;j++){
                		   s1[x]=s1[x]+"(";
                	   }
                	   s1[x]=s1[x]+String.valueOf(a);
                	
                    }

                    else{
                     
                          prev=Character.getNumericValue(S.charAt(i-1));
                      // nxt=Character.getNumericValue(s.charAt(i+1));

                        if(a>prev){
                           sub2=a-prev;
                        	for(int k=0;k<sub2;k++){
                        		s1[x]=s1[x]+"(";
                        	}
                        	s1[x]=s1[x]+String.valueOf(a); 	
                        } 
                        
                        else if(a<prev){
                        	sub1=prev-a;
                        	for(int k=0;k<sub1;k++){
                        		s1[x]=s1[x]+")";
                        	}
                        	s1[x]=s1[x]+String.valueOf(a);
                        } 
                        
                        else{
                        	s1[x]=s1[x]+String.valueOf(a);
                          
                        } 
                     }  
                    
                }
                i++;
                
        	}
        	 if(last==0){
        	 	s1[x]=s1[x]+"0";
        	 }

        	while(last>0){
        		s1[x]=s1[x]+")";
        		last--;
        	}
        }
        
        for(int i=0;i<T;i++){
        	    System.out.println("Case #"+(i+1)+": "+s1[i]);
        	}    
	}
}