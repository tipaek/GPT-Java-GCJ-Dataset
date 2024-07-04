import java.util.*;
 class Solution {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0) {
			int n=scn.nextInt();
			scn.nextLine();
			String[]arr=new String[n];
			for(int i=0;i<n;i++) {
				arr[i]=scn.nextLine();
			}
			StringBuilder s1=new StringBuilder();
			StringBuilder s2=new StringBuilder();
			for(int i=0;i<arr[0].length();i++) {
				if(arr[0].charAt(i)=='*') {
					s1=new StringBuilder(arr[0].substring(0,i));
					s2=new StringBuilder(arr[0].substring(i+1));
					break;
				}
			}
			
			boolean possible=true;
			for(int i=1;i<n && possible;i++) {
				String s=arr[i];
				boolean flag=true;
				int j=0;int k=0;
				for(;j<s.length() && flag;j++) {
					if(s.charAt(j)=='*')
						{flag=false;continue;}
					if(k>=s1.length()) {
						while(j<s.length() && s.charAt(j)!='*') {
							s1.append(s.charAt(j));
							j++;
						}
						break;
					}
					if(s1.charAt(k)==s.charAt(j)) {
						k++;
					}else {
						possible=false;
						break;
					}
				}
				int idx=j;
				k=s2.length()-1;
				for(j=s.length()-1;j>=idx && possible;j--) {
					if(s.charAt(j)=='*')
						continue;
					if(k<0) {
						while(j>=0 && s.charAt(j)!='*') {
							s2.insert(0,s.charAt(j));
							j--;
						}
						break;
					}
					if(s2.charAt(k)==s.charAt(j)) {
						k--;
					}else {
						possible=false;
						break;
					}
				}
				
			}
			if(!possible) {
				System.out.println("*");
			}else {
				System.out.println(s1+""+s2);
			}
		}
	}
//	public static StringBuilder getprefix(String s,int idx) {
//		StringBuilder ans=new StringBuilder
//	}
//	public static StringBuilder getsuffix(String s,int idx) {
//		
//	}

}
