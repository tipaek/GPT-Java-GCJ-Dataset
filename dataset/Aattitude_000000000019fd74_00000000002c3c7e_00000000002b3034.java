

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/*Case #1: COCONUTS
 *Case #1: COCONUTS
Case #2: *
Case #2: **/
 class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
          

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			ArrayList<String> al=new ArrayList<>();
			int n=Integer.parseInt(br.readLine());
			
			String s=br.readLine();
			String max=s;
			al.add(s);
			for(int i=1;i<n;i++) {
				s=br.readLine();
				al.add(s);
				if(s.length()>max.length())
					max=s;
			}
			boolean flag=true;
			for(int i=0;i<n;i++) {
				String t1=al.get(i);
				for(int j=i+1;j<n;j++) {
					String t2=al.get(j);
					String min1="",max1="";
					if(t1.length()>t2.length())
					{min1=t2;
					max1=t1;
					}
					else {
						max1=t2;
						min1=t1;
					}
					int g=max1.length()-1;
					for(int v=min1.length()-1;v>0;v--) {
						if(min1.charAt(v)==max1.charAt(g)) {
							
						}
						else {
							flag=false;
							
						}
						g--;
					}
				}
			}
			if(flag && max.length()>1) {
				bw.write("Case #" + (t + 1) + ": "+max.substring(1)+"\n");
			}
			else {
				bw.write("Case #" + (t + 1) + ": "+"*\n");
			}
		}
		bw.flush();
	}
	
}
