import java.util.*;
class Solution {
    public static void main(String args[]) {
        int T,N,x=1,i,j,flag;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T>0){
			N = sc.nextInt();
			flag = 1;
			String y = "",max = "";
			String S[]=new String[N];
			for(i=0;i<N;i++) {
				S[i] = (sc.next()).replace("*","");
				if(S[i].length()>max.length()) {
					max = S[i];
				}
			}
			y = max;
			for(i=0;i<N;i++) {
				if(max.contains(S[i])) {
					flag = 0;
				} else {
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				System.out.println("Case #"+x+": *");
			} else {
				System.out.println("Case #"+x+": "+y);
			}
            T--;
			x++;
			
        }
    }
}