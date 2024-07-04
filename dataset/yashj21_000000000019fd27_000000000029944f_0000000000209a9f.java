import java.util.Scanner;


class Solution{
    
  public static void main(String args[]){
	        Scanner sc = new Scanner(System.in);
	        String test[] = new String[sc.nextInt()];
	        String ans[] = new String[test.length];
	         for(int i=0;i<test.length;i++){
	            test[i]= sc.next();
	        }
	        for(int i=0;i<test.length;i++){
	            ans[i] = performMinNesting(test[i]);
	        }
	        for(int i=0;i<test.length;i++){
	            System.out.println("Case #"+(i+1)+": "+ans[i]);
	        }
	    }
	    
	    public static String performMinNesting(String s){
	        int prev=-1;
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            int dig = c-'0';
	            if(sb.length()==0){
	                prev = dig;
	                while(dig>0){
	                    sb.append('(');
	                    dig--;
	                }
	                sb.append(prev);
	            }else{
	                if(dig>prev){
	                    int temp = prev;
	                    prev = dig;
	                    dig = dig-temp;
	                    while(dig>0){
	                        sb.append('(');
	                        dig--;
	                    }
	                    sb.append(prev);
	                }else if(prev>dig){
	                    int temp = prev;
	                    prev = dig;
	                    dig = temp - dig;
	                    while(dig>0){
	                        sb.append(')');
	                        dig--;
	                    }
	                    sb.append(prev);
	                }else{
	                    sb.append(dig);
	                    prev = dig;
	                }
	            }
	        }
	        while(prev>0){
	        	sb.append(')');
	        	prev--;
	        }
	        return sb.toString();
	    }
}