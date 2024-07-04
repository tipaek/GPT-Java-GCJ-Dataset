import java.util.*;

public class c2 {

	public static void Solution(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			int t = input.nextInt();
			for(int z=1;z<=t;z++) {
				
				int n = input.nextInt();
				int s[] = new int[n];
				int f[] = new int[n];
				//TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
				
				for(int i=0;i<n;i++) {
					s[i] = input.nextInt();
					f[i] = input.nextInt();
					//map.put(input.nextInt(), input.nextInt());
				}
				
				String out="C";
				int jpos=-1,cpos=0;
				for(int i=1;i<n;i++) {
					//for(int j=i+1;j<n;j++) {
						if(out.charAt(i-1) == 'C' && f[i-1]<=s[i]) {
							out=out+"C";
							cpos=i;
							//System.out.println(out);
						}
						else if(out.charAt(i-1) == 'J' && f[i-1]<=s[i]) {
							out=out+"J";
							jpos=i;
							//System.out.println(out);
						}
						else if(jpos==-1 && out.charAt(i-1) == 'C' && f[i-1]>s[i]) {
							out=out+"J";
							jpos=i;
						}
						else if(cpos==-1 && out.charAt(i-1) == 'J' && f[i-1]>s[i]) {
							out=out+"C";
							cpos=i;
						}
						else if(out.charAt(i-1) == 'C' && f[i-1]>s[i]  &&(f[jpos]<s[i] || (f[jpos]>s[i]&& s[jpos]>s[i]))) {
							out=out+"J";
							jpos=i;
							//System.out.println(out);
						}
						else if(out.charAt(i-1) == 'J' && f[i-1]>s[i] && (f[cpos]<s[i] || (f[cpos]>s[i]&& s[cpos]>s[i]))) {
							out=out+"C";
							cpos=i;
							//System.out.println(out);
						}
						else {
							out="IMPOSSIBLE";
							//System.out.println(out);
							break;
						}
						
					//}
				}
				System.out.println("Case #"+z+":"+out);
				
				
			}}catch(Exception e) {
				return;
			}

	}

}
