import java.io.*;

class Solution {
	public static int nums(char x) {
		switch(x) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		default:
			return 9;
	}
}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int cnt=0;
		while(t-->0) {
			cnt++;
			String s=br.readLine();
			int n=s.length();
			String str="";
			int c=0;
			for(int i=0;i<n;i++) {
				char ch=s.charAt(i);
				int x=nums(ch);
				if(c<x) {
					while(c<x) {
						str+='(';
						c++;
					}
				}
				else if(c>x) {
					while(c>x) {
						str+=')';
						c--;
					}
				}
				str+=ch;
			}
			while(c!=0) {
				str+=')';
				c--;
			}
			System.out.println("Case #"+cnt+": "+str);
		}
	}
}

