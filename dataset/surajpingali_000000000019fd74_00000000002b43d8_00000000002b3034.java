import java.util.*;
class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for(int in=1;in<=t;in++){
			int n=sc.nextInt();
			String[]arr = new String[n];
			for(int i=0;i<n;i++)arr[i]=sc.next();
			Arrays.sort(arr);
			String s1=arr[0];
			System.out.println(s1);
			for(int i=1;i<n;i++){
				
				String s2=arr[i];
				
				s1=s1.replace("*","");
				s2=s2.replace("*","");
			//	System.out.println(s1+" "+s2);
				if(s2.contains(s1)){
					//System.out.println(s2);
					s1=s2;
				}
			}
			System.out.println("Case #"+in+": "+(s1.equals(arr[0].replace("*","")))?"*":s1);
		}
	}
}
	