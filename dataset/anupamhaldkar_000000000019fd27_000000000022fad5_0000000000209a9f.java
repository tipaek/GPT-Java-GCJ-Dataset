
import java.util.*;
class Solution {
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int n = sc.nextInt();
	int d=0;
	while(d++<n){
		String	b=sc.next();
		System.out.println("Case #"+d+": "+nested_fun(b));
}
}
	public static String nested_fun(String s){
			int depth=0;
			String a="";
			for(char q: s.toCharArray()){
				int v = q-'0';
				if(v>depth){
					while(v>depth){
						a+="(";
						depth++;
					}
				}
				if(v<depth){
					while(v<depth){
						a+=")";
						depth--;
					}
				}
				a += q;
			}
			while(depth>0){
				a +=")";
				depth--;
			}
			return a;
			}
	}

	
