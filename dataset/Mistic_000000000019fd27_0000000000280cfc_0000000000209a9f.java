import java.util.*;
class Solution {
    public static void main(String args[]) {
        int T,x=1,i,j,b;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T>0){
			b=j=0;
			String S=new String();
			String S1=new String();
			S = sc.next();
			for(i=0;i<S.length();i++) {
				j = Character.getNumericValue(S.charAt(i));
				while(b>j){
					S1+=")";
					b--;
				}
				while(b!=j){
					S1+="(";
					b++;
				}
				S1+=Integer.toString(j);
			}
			while(b!=0){
				S1+=")";
				b--;
			}
			System.out.println("Case #"+x+": "+S1);
            T--;
			x++;
			
        }
    }
}