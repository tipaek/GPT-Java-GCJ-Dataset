import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		
		int tcount=1;
		
		while(tcount<=t) {
			
			int n = Integer.parseInt(br.readLine());
			
			String s[] = new String[n];
			
			for(int i=0;i<n;i++) {
				s[i] = br.readLine();
			}
			
			Arrays.sort(s,new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
				if(o1.length()-o2.length()<0)
				{return 1;}
				else if(o1.length()-o2.length()==0) 
				{return 0;}
				else return -1;
				}
				
			});
			String output="";
			/*
			 * int flag=0;
			 * 
			 * for(int i=0;i<n-1;i++) { String s1 = s[i]; String s2 = s[i+1]; //make string
			 * of equal length for(int j=0;j<n;j++) { if(s1.charAt(j)!=s2.charAt(j)) { char
			 * ch=s1.charAt(j); char ch1=s2.charAt(j); if(ch!='*' || ch1!='*') { flag=1;
			 * break; } else {
			 * 
			 * } } } if(flag==1) break; }
			 * 
			 * if(flag==1) System.out.println("*");
			 */
			String s0=s[0].substring(1);
			
			for(int i=0;i<n;i++) {
				s[i]=s[i].substring(1);
			}
			int flag=1;
			for(int i=1;i<n;i++) {
				String si =s[i];
				int count=si.length()-1;
				for(int j=s0.length()-1;j>=0;j--) {
					char ch = s0.charAt(j);
					char ch1 = 0;
					if(count>=0) {
						ch1 =si.charAt(count);
						count--;
					}
					else {break;}
					if(ch!=ch1) {
						flag=0;
						break;
					}
						
				}
				if(flag==0) break;
				
			}
			if(flag==0) System.out.println("Case #"+tcount+": "+"*");
			else System.out.println("Case #"+tcount+": "+s[0]);	
			tcount++;
		}

	}

}
