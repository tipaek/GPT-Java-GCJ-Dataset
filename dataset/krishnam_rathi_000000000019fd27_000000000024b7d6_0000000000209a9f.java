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
		    for(int i=0;i<a[0];i++) {
		    	ans+='(';
		    	st.push(')');
		    }ans+=a[0];
		    boolean isOpen=true;
		    for(int i=1;i<n;i++) {
		    	if(isOpen) {
		    		if(a[i]>a[i-1]) {
		    			while(st.size()!=a[i]) {
		    				ans+='(';
		    				st.push(')');
		    			}
		    		}else if(a[i]<a[i-1]) {
		    			while(st.size()!=a[i]) {
		    				ans+=st.pop();
		    			}
		    			isOpen=false;
		    		}
		    		ans+=a[i];
		    	}else {
		    		if(a[i]<a[i-1]) {
		    			while(st.size()!=a[i]) {
		    				ans+=st.pop();
		    			}ans+=a[i];
		    		}else if(a[i]>a[i-1]) {
		    			while(!st.empty()) ans+=st.pop();
		    			for(int j=0;j<a[i];j++) {
		    				ans+='(';
		    				st.push(')');
		    			}ans+=a[i];
		    			isOpen=true;
		    		}else {
		    			ans+=a[i];
		    		}
		    	}
		    }
		    while(!st.empty()) ans+=st.pop();
		    System.out.println("Case #"+T+": "+ ans);
		}
	}
}