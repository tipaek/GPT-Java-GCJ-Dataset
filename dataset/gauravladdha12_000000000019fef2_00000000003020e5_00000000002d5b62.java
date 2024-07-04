import java.util.*;
class Solution{
	public static int check(int x){
		int u=(int)(Math.log(x)/Math.log(2));
		if(Math.pow(2,u)==x)
			return u;
		else if(Math.abs(Math.pow(2,u)-0)>Math.abs(Math.pow(2,u+1)-0)){
			return u+1;
		}
		else
		return u;
	}
	public static String check3(String s){
		String ans="";
		int i;
		for(i=s.length()-1;i>=0;i--){
			if(s.charAt(i)=='E'){
				ans=ans+"W";
			}
			if(s.charAt(i)=='W'){
				ans=ans+"E";
			}
			if(s.charAt(i)=='N'){
				ans=ans+"S";
			}
			if(s.charAt(i)=='S'){
				ans=ans+"N";
			}
		}
		return ans;
	}
	public static String check2(int x,int y,int u){
		String ans="";
		//System.out.println(u);
		while(u>0){
					if(Math.abs(x)>Math.abs(y))
					{
					if(x>0){
						x=x-u;
						u=u/2;
						ans=ans+"W";
					}
					else{
						x=x+u;
						u=u/2;
						ans=ans+"E";
					}
				}
				else{
					if(y>0){
						y=y-u;
						u=u/2;
						ans=ans+"S";
						//System.out.println("yoooo"+" "+y+" "+u);
					}
					else{
						y=y+u;
						u=u/2;
						ans=ans+"N";
					}
				}
				//System.out.println(x+" "+y);
				}
				if(x==0&&y==0)
					return ans;
				return "i";
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int r=1;
		while(t-->0){
			String ans="";
			int x=sc.nextInt();
			int y=sc.nextInt();
			int x1=Math.abs(x);
			int y1=Math.abs(y);
			int u=0;
			int f=(int)(Math.log(x1+y1+1)/Math.log(2));
			//System.out.println(f);
			/*if(Math.pow(2,f)==x1+y1+1)
				u=f;
			else if(x1>y1){
				u=check(x1);
				u=(int)Math.pow(2,u);
			}
			else{
				u=check(y1);
				u=(int)Math.pow(2,u);
			}*/
			if(Math.abs(x)>Math.abs(y))
			u=(int)(Math.log(x1)/Math.log(2));
		else
			u=(int)(Math.log(y1)/Math.log(2));
			int u1=u;
			int u2=u-1;
			int u3=u+1;
			//System.out.println(u1+" "+u2+" "+u3);
			String s1=check2(x,y,(int)Math.pow(2,u1));
			String s2=check2(x,y,(int)Math.pow(2,u2));
			String s3=check2(x,y,(int)Math.pow(2,u3));
			int l1=0,l2=0,l3=0;
			//System.out.println(s1+" "+s2+" "+s3);
			if(s1.charAt(0)!='i'){
				l1=s1.length();
			}
			else{
				l1=Integer.MAX_VALUE;
			}
			if(s2.charAt(0)!='i'){
				l2=s2.length();
			}
			else{
				l2=Integer.MAX_VALUE;
			}
			if(s3.charAt(0)!='i'){
				l3=s3.length();
			}
			else{
				l3=Integer.MAX_VALUE;
			}
			//System.out.println(u);
			if(l1==l2&&l2==l3&&l1==Integer.MAX_VALUE){
				System.out.println("Case #"+r+": IMPOSSIBLE");
			}
			else{
				if(l1<l2&&l1<l3){
					String as=check3(s1);
					System.out.println("Case #"+r+": "+as);
				}
				else if(l2<l1&&l2<l3){
					String as=check3(s2);
					System.out.println("Case #"+r+": "+as);
				}
				else{
					String as=check3(s3);
					System.out.println("Case #"+r+": "+as);
				}
			}					
					
				r++;
		}
	}
}