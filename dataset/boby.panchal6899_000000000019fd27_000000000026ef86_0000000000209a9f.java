import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			String s = sc.next();

			StringBuffer newStr = new StringBuffer(s);
			for(int j=0; j<newStr.length(); j++) {
				if(Integer.parseInt(newStr.charAt(j)+"") != 0) {
					int var = Integer.parseInt(newStr.charAt(j)+"");
					int k = 0;
					do {
						k++;
						if((k+j) >= newStr.length())
							break;
					} while(var == Integer.parseInt(newStr.charAt(k+j)+""));
					for(int a=0; a<var; a++, j++)
						newStr.insert(j, "(");
					for(int a=0; a<k; a++, j++)
						newStr.replace(j, j+1, var+"");
					for(int a=0; a<var; a++, j++)
						newStr.insert(j, ")");
				    j--;
				}
			}
			System.out.println("Case #" + i + ": " + newStr);
		}
	}
}
