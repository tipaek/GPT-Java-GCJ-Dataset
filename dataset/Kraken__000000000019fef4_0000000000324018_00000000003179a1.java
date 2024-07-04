import java.util.Arrays;
import java.util.Scanner; 

public class Solution {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	int T=Integer.parseInt(s);
	for (int i = 1; i <= T; i++) {
		s = scanner.nextLine();		
		int u=Integer.parseInt(s);
		int[] cn=new int[27];
		int[] cn2=new int[27];
		for (int j = 0; j < 10000; j++) {
			s = scanner.nextLine();			
			String[] tok=s.split(" ");			
			if (tok[1].length()==2) {
				cn[tok[1].charAt(0)-'A']++;
				cn2[tok[1].charAt(1)-'A']++;
			}
			else cn2[tok[1].charAt(0)-'A']++;
		}
		//System.out.println(Arrays.toString(cn));
		//System.out.println(Arrays.toString(cn2));
		s="";
		for (int j = 0; j < 9; j++) {
			int mx=-1,in=-1;
			for (int k = 0; k < 27; k++) {
				if (cn[k]>mx) {mx=cn[k]; in=k;}				
			}
			cn[in]=0; cn2[in]=0;
			s+=(char)(in+'A');
		}
		for (int k = 0; k < 27; k++)  if (cn2[k]>0) s=(char)(k+'A')+s;
		System.out.println("Case #"+i+": "+ s);
	}
	scanner.close();		
}	
}