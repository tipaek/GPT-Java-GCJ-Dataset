
import java.util.*;
 class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test=scn.nextInt();
		for(int t=1;t<=test;t++) {
			int x=scn.nextInt();
			int y=scn.nextInt();
			String s=scn.nextLine();
//			System.out.println(s);
			int ans=x;
			int tillx=0;
			if(s.length()-1<x) {
				System.out.println("Case #"+t+": "+"IMPOSSIBLE");
			}else {
				for(int i=1;i<=x;i++) {
					if(s.charAt(i)=='S')
						tillx--;
					else
						tillx++;
				}
				int south=y+tillx;
				int north=y-tillx;
				boolean flag=false;
				for(int i=x+1;i<s.length();i++) {
					if(south==0 || north==0)
					{System.out.println("Case #"+t+": "+ans);flag=true;break;}
					char ch=s.charAt(i);
					if(ch=='N') {
						if(south<0) {
							if(south+1==0)
							{System.out.println("Case #"+t+": "+(ans+1));flag=true;break;}
							else
							south+=2;
						}
						if(north>0) {
							if(north-1==0)
							{System.out.println("Case #"+t+": "+(ans+1));flag=true;break;}
							else
								north-=2;
						}
						
					}else {
						if(south>0) {
								if(south-1==0)
								{System.out.println("Case #"+t+": "+(ans+1));flag=true;break;}
								else
								south-=2;
						}
						if(north<0) {
							if(north+1==0)
								{{System.out.println("Case #"+t+": "+(ans+1));flag=true;break;}}
							else
								north+=2;
						}
					}
					ans++;
				}
				
				if((south==0 || north==0) && !flag)
					{System.out.println("Case #"+t+": "+ans);}
				else if(!flag) {
					System.out.println("Case #"+t+": "+"IMPOSSIBLE");
				}
			}
		}
	}

}
