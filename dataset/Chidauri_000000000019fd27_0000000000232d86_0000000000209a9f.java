import java.util.*;

class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int q=0;q<t;q++){
			String s = in.next();
			System.out.print("Case #" + (q+1) + ": ");
			int prev = 0;
			for(int i=0;i<s.length();i++){
				int a = Integer.parseInt(String.valueOf(s.charAt(i)));
				if(a - prev > 0){
					int num = a-prev;
					while(num != 0){
						System.out.print('(');
						num--;
					}
					System.out.print(a);
					if(i==s.length() - 1){
						while(a!=0){
							System.out.print(')');
							a--;
						}
					}
				} else if(a - prev < 0){
					int num = prev - a;
					while(num!=0){
						System.out.print(')');
						num--;
					}
					System.out.print(a);
					if(i==s.length() - 1){
						while(a!=0){
							System.out.print(')');
							a--;
						}
					}
				} else {
					System.out.print(a);
					if(i==s.length() - 1){
						while(a!=0){
							System.out.print(')');
							a--;
						}
					}
				}
				prev = a;
			}
			System.out.println();
		}
	}
}