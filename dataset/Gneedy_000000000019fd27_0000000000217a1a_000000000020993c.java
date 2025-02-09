import java.util.*;
public class Solution {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		int t=input.nextInt();
		int counter=1;
		for(;t>0;t--) {
			int n=input.nextInt();
			String [] rows = new String[n];
			String [] cols = new String[n];
			Arrays.fill(rows,"");
			Arrays.fill(cols,"");
			int nrows=0,ncols=0,trace=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					String ch=input.next();
					if(!rows[i].contains("dn")&&rows[i].contains(ch)) {
						nrows++;
						rows[i]+="dn";
					}
					if(!cols[j].contains("dn")&&cols[j].contains(ch)) {
						ncols++;
						cols[j]+="dn";
					}
					if(i==j)
						trace+=Integer.parseInt(ch);
					rows[i]+=ch;
					cols[j]+=ch;
				}
			}
			
			System.out.printf("Case #%d: %d %d %d\n",counter++,trace,nrows,ncols);
		}
	}

}
