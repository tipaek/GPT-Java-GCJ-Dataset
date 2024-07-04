
import java.util.*;
public class Solution{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		while(n>0) {
			int test=in.nextInt();
			String[] str=new String[test];
			for(int i=0;i<test;i++) {
				str[i]=in.next();
			}
			for(int j=0;j<test;j++) {
			for(int i=1;i<test;i++) {
				if(str[i-1].length()>str[i].length()) {
					String swap=str[i-1];
					str[i-1]=str[i];
					str[i]=swap;
				}
			}
			}
//			for(int i=0;i<str.length;i++) {
//				System.out.println(str[i]);
//			}
			String ref=str[str.length-1];
//			int star=-1;
//			for(int j=0;j<ref.length();j++) {
//				if(ref.charAt(j)=='*') {
//					star=j;
//				}
//			}
//			String[] re=new String[2];
//			re[0]=ref.substring(0,star);
//			re[1]=ref.substring(star+1,ref.length());
//			System.out.println(re[0]+"-"+re[1]);
			int flag=0;
			String ret="";
			for(int i=0;i<str.length-1;i++) {
				String[] re=new String[2];
				String[] te=new String[2];
				int star=-1;
				for(int j=0;j<ref.length();j++) {
					if(ref.charAt(j)=='*') {
						star=j;
					}
				}
				re[0]=ref.substring(0,star);
				re[1]=ref.substring(star+1,ref.length());
				ret=re[0]+re[1];
				star=-1;
				for(int j=0;j<str[i].length();j++) {
					if(str[i].charAt(j)=='*') {
						star=j;
					}
				}

				te[0]=str[i].substring(0,star);
				//System.out.println(str[i].substring(star+1,str[i].length()));
				te[1]=str[i].substring(star+1,str[i].length());
				
				if(!(re[0].contains(te[0]))||!(re[1].contains(te[1]))) {
					flag=1;
//					if(!(re[0].contains(te[0])))
//						System.out.println(re[0]);
					break;
				}
			}
			if(flag==0) {
				System.out.println(ret);
			}else {
				System.out.println('*');
			}
			n--;
		}
	}

}
