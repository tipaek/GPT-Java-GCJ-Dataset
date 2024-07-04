import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			String s = sc.next();

			String newStr = "";
			for(int x=0; x<s.length(); x++) {
				int var = Integer.parseInt(s.charAt(x)+"");
				if(var == 0)
					newStr += 0+"";
				else {
					int y = x;
					int tmp = x-1;
					if(x != s.length()-1) {
						do{
							if(y+1 >= s.length()) {
								y--;
								break;
							}
							else 
								y++;
						} while(var == Integer.parseInt(s.charAt(y)+""));
						tmp = x;
						x = y-1;
					}
					
					for(int a=0; a<var; a++)
						newStr += "(";
					for(int a=0; a<y-tmp; a++)
						newStr+= var;
					for(int a=0; a<var; a++)
						newStr += ")";
				}
			}
			System.out.println("Case #" + i + ": " + newStr);
		}
	}
}
