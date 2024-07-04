import java.util.*;

class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int T=1;T<=t;T++){
			String s=sc.next();
			int n=s.length();
			Integer[] a=new Integer[n];
			for(int i=0;i<n;i++){
			    a[i]=Character.getNumericValue(s.charAt(i));
			}
			Stack<Character> st=new Stack<Character>();
		    String ans="";
		    int max=0, f=0;
		    for(int i=0;i<n;i++) {
		    	for(int j=i;j<n;j++) {
		    		if(max<a[i]) max=a[i];
		    	}
		    	if(f==0) {
		    		for(int j=0;j<max;j++) {
		    			ans+='(';
		    			st.push(')');
		    		}
		    		f=1;
		    	}
		    	if(a[i]!=0) {
		    		while(st.size()!=a[i]) {
		    			ans+='(';
		    			st.push(')');
		    		}ans+=a[i];
		    	}else{
		    		while(!st.empty()) ans+=st.pop();
		    		ans+=a[i];
		    		max=0;
		    		f=0;
		    	}
		    }
		    while(!st.empty()) ans+=st.pop();
		    System.out.println("Case #"+T+": "+ ans);
		}
	}
}