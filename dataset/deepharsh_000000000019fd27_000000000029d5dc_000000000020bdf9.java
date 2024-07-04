
import java.util.Scanner;
import java.math.*;
public class Main
{
	public static void main(String[] args) {
         Scanner s=new Scanner(System.in);
       int T=s.nextInt();
       for(int i=1;i<=T;i++){
           int n=s.nextInt();
           int[] num=new int[n*2];
           for(int j=0;j<num.length;j++){
               num[j]=s.nextInt();
           }
        System.out.println( "Case #"+i+": "+ C_willWork(num,"",0));
       }
	
         }
	
	public static String C_willWork(int[] num,String str,int i){
	    if(i==num.length-2){
	        return "Impossible";
	    }
	  str=str+"C";
  
if(num[i+1]<=num[i+2]){
    while(num[i+1]<=num[i+2]){
        str=str+"C";
        i=i+2;
        
        if(i==num.length-2){
            return str;
        }
    }
    String br=J_willWork(num,str,i+2);
	return br;
    
}
    
	else{
	String br= J_willWork(num,str,i+2);
	    return br;
	}

 }
	
  public static String J_willWork(int[] num,String str,int i){
        if(i==num.length-2){
	        return "IMPOSSIBLE";
	    }
  	   str=str+"J";
  
if(num[i+1]<=num[i+2]){
    while(num[i+1]<=num[i+2]){
        str=str+"J";
        i=i+2;
        if(i==num.length-2){
            return str;
        }
    }
 String br=C_willWork(num,str,i+2);
	return br;
    
}
    
	else{
	String br= C_willWork(num,str,i+2);
	  return br;  
	}

 }
	}

