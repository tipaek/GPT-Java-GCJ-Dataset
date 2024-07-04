
import java.util.*;

class Solution {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		for(int t=1;t<=x;t++) {
			int n =s.nextInt();
			List<String> pattern=new ArrayList<String>();
			for(int i=0;i<n;i++) {
				pattern.add(s.next());
			}
			StringBuffer sb=new StringBuffer(pattern.get(0));
			int len1=sb.length();
			int first=0;
			String befSb="";
			String aftSb="";
			String middleSb=(pattern.get(0)).contains("*")?"*":"";
			for(int i=0;i<len1;i++) {
				if(sb.charAt(i)=='*' && first==0) {
					first=1;
				}
				else
				if(first==0) {
					befSb+=sb.charAt(i);
				}
				else
				if(sb.charAt(i)=='*'&&first==1)
				{
					middleSb+=aftSb;
					aftSb="";
				}
				else
				if(first==1)
				{
					aftSb+=sb.charAt(i);
				}	
			}
			int imp=0;
			for(String st:pattern) {
				String befS="";
				String aftS="";
				String middleS=st.contains("*")?"*":"";
				int len=st.length();
				first=0;
				for(int i=0;i<len;i++) {
					if(st.charAt(i)=='*' && first==0) {
						first=1;
					}
					else
					if(first==0) {
						befS+=st.charAt(i);
					}
					else
					if(st.charAt(i)=='*'&&first==1)
					{
						middleS+=aftS;
						aftS="";
					}
					else
					if(first==1)
					{
						aftS+=st.charAt(i);
					}	
				}
				if(befS.contains(befSb)) {
					befSb=befS;
				}
				else
				if(befSb.contains(befS)) {
					befS="";
				}
				else
				{
					imp=1;
					break;
				}
				
				if(aftS.contains(aftSb))
				{
					aftSb=aftS;
				}
				else
				if(aftSb.contains(aftS)) {
					aftS="";
				}
				else
				{
					imp=1;
					break;
				}	
				sb=new StringBuffer(befSb+middleSb+aftSb);
				int indS=sb.indexOf("*");
				sb.replace(indS, indS+1, middleS);
			}
			if(imp!=1) {
			int indx=sb.indexOf("*");
			while(indx!=-1) {
				sb.replace(indx,indx+1,"");
				indx=sb.indexOf("*");
			}
			System.out.println("Case #"+t+": "+sb.toString());
			}
			else
			if(imp==1) {
				System.out.println("Case #"+t+": *");
			}
		}
	}
}

