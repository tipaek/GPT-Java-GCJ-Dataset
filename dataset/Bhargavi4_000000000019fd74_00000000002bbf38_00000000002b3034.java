import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String tests = br.readLine();
		if(tests == null)return;
		
		int t = Integer.parseInt(tests);
		
		StringBuilder sb = new StringBuilder();
		for(int k=0;k<t;k++) {
			sb.append("case #"+k+": ");
			String num = br.readLine();
			if(num == null)return;
			int n = Integer.parseInt(num);
			String prefix[] = new String[n];
			String suffix[] = new String[n];
			for(int i = 0;i<n;i++) {
				
				String str = br.readLine();
				if(str.startsWith("*")) {
					prefix[i]="";
					
					suffix[i]= str.substring(1,str.length());
					
					continue;
				}
				
				if(str.endsWith("*")) {
					prefix[i]=str.substring(0,str.length()-1);
					suffix[i]="";
					continue;
				}
				String[] s = str.split("*");
				
				prefix[i] = s[0];
				suffix[i] = s[str.length()-1];
				
				
			}
			
			Arrays.sort(prefix, (a,b) -> a.length() - b.length());
			Arrays.sort(suffix, (a,b) -> a.length() - b.length());
			
			String outP=null;
			boolean isEmpty=false;
			for(int i=0;i<n;i++) {
				
				if(prefix[i].equals("")) {
					isEmpty=true;
					continue;
				}
				if(i==0) {
					outP=prefix[i];
					continue;
				}
				if(prefix[i].contains(outP)) {
					outP=prefix[i];
				}else {
					outP=null;
					break;
				}
			}
			
			String outS=null;
			boolean isSEmpty=false;
			for(int i=0;i<n;i++) {
				
				if(suffix[i].equals("")) {
					isSEmpty=true;
					continue;
				}
				
				if(i==0) {
					outS=suffix[i];
					continue;
				}
				if(suffix[i].contains(outS)) {
					outS=suffix[i];
				}else {
					outS=null;
					break;
				}
				
			}
			
			String res = "";
			
			if(outP != null && !outP.isEmpty()) {
				res=res+outP;
			}
			
			if(outS != null && !outS.isEmpty()) {
				res= res+outS;
			}
			
			if(res.isEmpty()) {
				sb.append("*");
			}else {
				sb.append(res);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());

	}

}
