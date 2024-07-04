import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			int a=scanner.nextInt();
			int b=scanner.nextInt();

			System.out.print("Case #"+(t+1)+":");
			if(possible(a,b)==false)System.out.println("IMPOSSIBLE");
			else if(Math.abs(a)+Math.abs(b)==5)System.out.println(dir2(a,b));
			else System.out.println(dir(a,b));
		}
		
		
		
	}
	
	public static String dir(int a,int b) {
		String s="";
		String ss="";
		int z=1;
		int x=0;
		int y=0;
		if(a%2==1) {
			if(a>0)  ss="E";
			else ss="W";
			a=Math.abs(a);
			while(x<a) {
				x+=z;
				z*=2;
				s+=ss;	
			}
			z*=2;
			if(b>0)  ss="N";
			else ss="S";
			b=Math.abs(b);
			while(y<b) {
				y+=z;
				z*=2;
				s+=ss;	
			}
		}
		else {
			if(b>0)  ss="N";
			else ss="S";
			b=Math.abs(b);
			while(y<b) {
				y+=z;
				z*=2;
				s+=ss;	
			}
			z*=2;
			if(a>0)  ss="E";
			else ss="W";
			a=Math.abs(a);
			while(x<a) {
				x+=z;
				z*=2;
				s+=ss;	
			}
			
			
		}
		return s;
	}
	
	public static boolean possible(int a,int b) {
		boolean p=true;
		int c=Math.abs(a)+Math.abs(b);
		if((c)%2==0)p=false;
		else {
			c+=1;
			int x=1;
			while(x<c) {
				x*=2;
			}
			//if(x>c)p=false;
		}
		
		return p;
	}
	
	public static String dir2(int a,int b) {
		String s="";
		if(a==2) {
			if(b==3)s="SEN";
			else s="NES";
		}
		if(a==-2) {
			if(b==3)s="SWN";
			else s="NWS";
		}
		if(b==2) {
			if(a==3)s="WNE";
			else s="ENW";
		}
		if(b==-2) {
			if(a==3)s="WSE";
			else s="ESW";
		}
		
		return s;
	}

}
