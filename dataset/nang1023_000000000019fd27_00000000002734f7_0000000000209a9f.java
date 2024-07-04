import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int t, tmp,len, dif, ans,idx=0;
	static String s;
	static int[] d= new int[101];
	static StringTokenizer st=null;
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		st= new StringTokenizer(br.readLine());
		t=Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= t; tc++) {
			s=br.readLine();
			ans=0; len=s.length();
			Arrays.fill(d, 0);
			
			bw.append("Case #"+tc+": ");
			
			for (int i = 0; i < len; i++) 
				d[i]=s.charAt(i)-48;
			
			tmp=d[0];
			idx=tmp;
			while(idx>0) {
				bw.append("(");
				idx--;
			}
			bw.append(tmp+"");
			
			idx=1;
			while(idx<len) {
				dif=d[idx]-tmp;
				if(dif>0) {
					while(dif>0) {
						bw.append("(");
						dif--;
					}			
				}else if(dif<0) {
					dif*=-1;
					while(dif>0) {
						bw.append(")");
						dif--;
					}			
				}
				tmp=d[idx];
				bw.append(tmp+"");
				idx++;
			}
			tmp=d[len-1];
			idx=tmp;
			while(idx>0) {
				bw.append(")");
				idx--;
			}
			bw.append("\n");
		}
			
		bw.flush();
		bw.close();
	}

}
