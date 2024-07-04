import java.util.Scanner;

public class Solution {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int ks = 1; ks <= T; ks++) {
        int n=sc.nextInt(),a[]=new int[n];
		int i=1,cnt=0;
		for(;i<=n;i++) {
			System.out.println(i);
			int res=sc.nextInt();
			if(i%10==1) {
				a[i-1]=-1;
				cnt++;
			}
			else a[i-1]=res;
		}
		int pos=1;
		while(cnt>0) {
			System.out.println(pos);
			int res=sc.nextInt();
			if(i%10!=1) {
				a[pos-1]=res;
				pos+=10;
				cnt--;
			}
			i++;
		}
		StringBuilder ans=new StringBuilder();
		for(int x:a) ans.append(x);
		System.out.println(ans);
		String o=sc.next();
		if(o.equals("N")) return;
    }
  }
}