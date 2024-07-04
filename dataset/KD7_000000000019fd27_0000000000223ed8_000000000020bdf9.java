import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	static class Temp implements Comparable<Temp>{
		int begin,end;
		char id;
		Temp(int b,int e) {
			begin=b;
			end=e;
			id=' ';
		}
		@Override
		public int compareTo(Temp o) {
			if(this.begin<o.begin)
				return -1;
			if(this.begin>o.begin)
				return 1;
			return 0;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x,i,t,n,C,J;
		Temp temp1[],temp2[];
		String s[],out[];
		t=Integer.parseInt(br.readLine());
		out=new String[t];
		for(x=0;x<t;x++) {
			out[x]="";
			n=Integer.parseInt(br.readLine());
			temp1=new Temp[n];
			temp2=new Temp[n];
			for(i=0;i<n;i++) {
				s=br.readLine().split(" ");
				temp1[i]=new Temp(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
				temp2[i]=temp1[i];
			}
			Arrays.sort(temp1);
			C=0;J=0;
			for(i=0;i<n;i++) {
				if(C<=temp1[i].begin) {
					temp1[i].id='C';
					C=temp1[i].end;
				}
				else if(J<=temp1[i].begin) {
					temp1[i].id='J';
					J=temp1[i].end;
				}
				else {
					out[x]="IMPOSSIBLE";
					break;
				}
			}
			if(i==n) {
				for(i=0;i<n;i++) {
					out[x]+=temp2[i].id;
				}
			}
		}
		for(x=0;x<t;x++) {
			System.out.println("Case #"+(x+1)+": "+out[x]);
		}
	}
}
