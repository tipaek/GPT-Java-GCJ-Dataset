import java.util.Scanner;
import java.io.*;
import java.util.*;

class Solution {
	

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.next());
		int ncases = 1;
		while(ncases <= cases) {
			String res = "";
			String st = sc.next();
			for(int x = 0; x<st.length(); x++) {
				int num = Integer.parseInt(st.substring(x, x+1));
				int indice = 0;
				while(indice<num) {
					res+= "(";
					indice++;
				}
				res+= num;
				indice = 0;
				while(indice<num) {
					res += ")";
					indice++;
				}
				
			}
			
			int origLen = res.length();
			int newLen = 0;
			
			while(newLen!=origLen) {
				origLen = res.length();
				res = res.replace(")(", "");
				newLen = res.length();
			}
			
			System.out.println("Case #"+ncases+": " +res);
			
			
			
			ncases++;
		}

	}

}
