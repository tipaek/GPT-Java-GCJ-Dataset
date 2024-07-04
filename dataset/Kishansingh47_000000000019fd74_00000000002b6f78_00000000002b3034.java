import java.util.Scanner;

class Solution{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int cse=1;
		while(t-->0) {
			int n = sc.nextInt();
			String ip[] = new String[n];
			int min_flag=0,max_flag=0,min_len=Integer.MAX_VALUE,max_len=Integer.MIN_VALUE,temp=0;
			for(int i=0;i<n;i++) {
				ip[i] = sc.next();
				if(ip[i].length()<min_len) {
					min_len=ip[i].length();
					min_flag=i;
				}
				if(ip[i].length()>max_len) {
					max_len=ip[i].length();
					max_flag=i;
				}
			}
			for(int i=0;i<n;i++) {
				if(i!=max_flag) {
					String flag = ip[i].substring(1);
					if(!ip[max_flag].substring(max_len-flag.length()).equals(flag)) {
						sb.append("Case #"+cse+": *");
						temp=1;
						break;
					}
				}
			}
			if(temp!=1) {
				sb.append("Case #"+cse+": "+ip[max_flag].substring(1));
			}
			sb.append("\n");
			cse++;
		}
		System.out.print(sb.toString());
		sc.close();
	}
}