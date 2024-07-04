import java.util.*;

class Solution{
    
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            String result="";
            String str=sc.next();
            
            
		
		Stack<String> stk=new Stack<>();
		int size=0;
		for(int i=0;i<str.length();i++) {
		int a=Character.getNumericValue(str.charAt(i));
		if(a>size) {
			int add=a-size;
			while(add-->0) {
				size++;
				stk.push("(");
			}
			
		}
		if(a<size) {
			int min=size-a;
				
			while(min-->0) {
				size--;
				stk.push(")");
			}
		}
			stk.push(String.valueOf(a));
		}
		while(!stk.isEmpty()) {
			result=stk.pop()+result;
		}
		while(size-->0)
			result+=")";	
		System.out.println("Case #"+(i+1)+": "+result);
		
		
		
		
            
            
        }
        
    }
}