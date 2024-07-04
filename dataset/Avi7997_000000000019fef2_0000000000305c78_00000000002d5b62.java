import java.io.*;
import java.util.*;

class Solution {
	
	public static String inBin(long n) {
		String ans = "";
		while(n>0) {
			ans = (n%2) + ans;
			n = n/2;
		}
		return ans;
	}
	static boolean isPowerOfTwo(int n) { 
        return (int)(Math.ceil((Math.log(n) / Math.log(2))))  
            == (int)(Math.floor(((Math.log(n) / Math.log(2))))); 
    } 
	static String strBin(int n) {
		String ans = "";
		while(n>0) {
			ans =  ans+(n%2);
			n = n/2;
		}
		return ans;
	}
	public static String answer(int x,int y) {
		int temp_x=x,temp_y=y;
		if(x<0)	x = 0-x;
		if(y<0)	y = 0-y;
		boolean flag = (x!=0 && y!=0 && (y&x)==0), flag_1 = isPowerOfTwo(y+(~x)),flag_2 = isPowerOfTwo((~y)+x),flag_1_1 = isPowerOfTwo(y+1),flag_2_1 = isPowerOfTwo(x+1);
		if(!(flag  || (x>0 && x<y && flag_1 || (x==0 && flag_1_1)) || ((y>0 && x>y && flag_2) || (y==0 && flag_2_1))))	return "IMPOSSIBLE";
		
		String a = strBin(x),b = strBin(y);
//		System.out.println(x+" "+a+"  "+y+" "+b);
		char ans[] = new char[Math.max(a.length(), b.length())];
		for(int i=0;i<a.length() || i<b.length();i++) {
			if(flag) {
				if(i<b.length() && b.charAt(i)=='1')	ans[i] = temp_y>0?'N':'S';
				else if(a.charAt(i)=='1')	ans[i] = temp_x>0?'E':'W';
			}
			else if(x>0 && x<y && flag_1) {
				if(i<a.length() && a.charAt(i)=='1')	ans[i] = temp_x>0?'E':'W';
				else if(b.charAt(i)=='1')	ans[i] = temp_y>0?'S':'N';
			}
			else if(x==0 && flag_1_1) {
				ans[i] = temp_y>0?'N':'S';
			}
			else if((y>0 && x>y && flag_2))  { 
				if(i<b.length() && b.charAt(i)=='1')	ans[i] = temp_y>0?'N':'S';
				else if(a.charAt(i)=='1')	ans[i] = temp_x>0?'W':'E';
			}
			else if(y==0 && flag_2_1) {
				ans[i] = temp_x>0?'E':'W';
			}
		}
		String str="";
		for(int i=0;i<ans.length;i++) {
			str+=ans[i];
		}
		if(flag || (x==0 && flag_1_1) || (y==0 && flag_2_1))	return str;
		if(x>0 && x<y && flag_1)	return (str+(temp_y>0?'N':'S'));
		return (str = str+(temp_x>0?'E':'W'));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String buff[] = scan.readLine().split(" ");
		int t = Integer.parseInt(buff[0]);
		for(int p=1;p<=t;p++) {
			buff = scan.readLine().split(" ");
			int x=  Integer.parseInt(buff[0]);
			int y=  Integer.parseInt(buff[1]);
			String ans = answer(x,y);
			
			System.out.println("Case #"+p+": "+ans);
		}
	}
}