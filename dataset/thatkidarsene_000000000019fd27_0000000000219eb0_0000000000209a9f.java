import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class Solution{
//<>

public static String solve(String s){
	String res ="";
	int d=0;
		if(s.charAt(0)=='0'){
			res+='0';
	}else{
		for(int i=0;i<(int)(s.charAt(0)-'0');i++){res+="(";d++;}
			res+=s.charAt(0);
	}
	for(int i=1;i<s.length();i++){
		if(Integer.parseInt(String.valueOf(s.charAt(i)))==d){
			res+=s.charAt(i);
		}else{
			if(Integer.parseInt(String.valueOf(s.charAt(i)))<d){
				int tmp = d-(int)(s.charAt(i)-'0');
				for(int j=0;j<tmp;j++){res+=")";d--;}
					res+=s.charAt(i);
			}else{
				int tmp = (int)(s.charAt(i)-'0')-d;
				for(int j=0;j<tmp;j++){res+="(";d++;}
					res+=s.charAt(i);
			}
		}
	}
	for(int i=0;i<d;i++){res+=")";}
	return res;
}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int T = s.nextInt();
	 String[] tab = new String[T];
	for(int i=0;i<T;i++){
			s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			tab[i] = s.nextLine();
	}
	for(int i=0; i<T;i++){
		System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
	}
}
}