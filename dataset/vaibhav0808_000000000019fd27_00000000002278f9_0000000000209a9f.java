import java.util.*;

class Solution1 {
    public static void main (String[] args) {
        Scanner sc = new  Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int t=1;t<=T;t++) {
            String S = sc.nextLine();
            String ans = "";
            
            int openParan = 0;
            for (int i=0; i<S.length(); i++) {
            	int dig = (int) (S.charAt(i) - '0');
            	if(openParan == dig) {
            		ans += S.charAt(i);
            		continue;
            	} else if (openParan < dig) {
            		while(openParan<dig) {
            			ans+= "(";
            			openParan++;
            		}
            		ans += S.charAt(i);
            	} else {
            		while(openParan > dig) {
            			ans+= ")";
            			openParan--;
            		}
            		ans += S.charAt(i);
            	}
            }
            while(openParan>0) {
        		ans+= ")";
        		openParan--;
        	}
        	System.out.println("Case #" + t + ": " + ans);
        }
    }
}