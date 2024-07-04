import java.util.*;

class Solution {
	public static int a,b,na,nb;
	public static void main(String ...args) {
		int tCases;
		Scanner sc = new Scanner(System.in);
		tCases = sc.nextInt();
		for(int tCase = 1; tCase<=tCases; tCase++) {
			a=sc.nextInt();b=sc.nextInt();
			na=a<0?-1*a:a;
			nb=b<0?-1*b:b;
			int powof2 = nextPowerOf2(na+nb);
			System.out.print("Case #" + tCase +": ");
			if(a+b == 0 || a==b) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				print(na,nb,powof2,new char[powof2],1,0,0,0);
			}
		}
	}
	
	public static boolean print(int a, int b, int n, char[] s, int idx, int i, int j,int akhil) {
		if(i == a && j == b ) {printChars(s);return true;}
		if(akhil >= n ) return false;
		s[akhil] = 'S';
		if(print(a,b,n,s,idx*2,i,j-idx,akhil+1)) return true;
		s[akhil] = 'N';
		if(print(a,b,n,s,idx*2,i,j+idx,akhil+1)) return true;
		s[akhil] = 'E';
		if(print(a,b,n,s,idx*2,i+idx,j,akhil+1)) return true;
		s[akhil] = 'W';
		if(print(a,b,n,s,idx*2,i-idx,j,akhil+1)) return true;
		return false;
	}
	
	
	private static void printChars(char[] s) {
		for(int i=0;i<s.length;i++) {
			System.out.print(getchar(s[i]));
		}
		System.out.println();
		
	}

	private static char getchar(char c) {
		if(na != a && nb != b) {
			switch(c) {
				case 'S':return 'N';
				case 'N': return 'S';
				case 'E': return 'W';
				case 'W': return 'E';
			}
		} else if(na != a) {
			switch(c) {
			case 'E': return 'W';
			case 'W': return 'E';
		}
		} else if(nb != b ) {
			switch(c) {
			case 'S': return 'N';
			case 'N': return 'S';
		}
		} return c;
	}

	public static int nextPowerOf2(int n) 
    { 
        int count = 0; 
        if (n > 0 && (n & (n - 1)) == 0) return n; 
        while(n != 0) { n >>= 1; count += 1; } 
        return count; 
    } 
}