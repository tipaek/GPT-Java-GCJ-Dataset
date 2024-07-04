import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[]args) throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = Integer.parseInt(sc.nextLine().trim());
		for(int i=1;i<=t;i++) {
			int N = Integer.parseInt(sc.nextLine());
			boolean[]C=new boolean[1440];
			boolean[]J=new boolean[1440];
			
			String output = "C";
			boolean possible=true;
			String[] st = (sc.nextLine().split(" "));
			int start = Integer.parseInt(st[0]);
			int end = Integer.parseInt(st[1]);
			for(int k=start;k<end;k++) {
				C[k]=true;
			}
			
			for(int j=1;j<N;j++) {

				st = (sc.nextLine().split(" "));
				start = Integer.parseInt(st[0]);
				end = Integer.parseInt(st[1]);
				boolean csjob=true;
				boolean jsjob=true;
				for(int k=start;k<end;k++) {
					if(C[k]) {
						csjob=false;
					}
					if(J[k]) {
						jsjob=false;
					}

				}
				if(csjob) {
					for(int k=start;k<end;k++) {
						C[k]=true;
						
					}
					output+='C';
				}
				else if(jsjob) {
					for(int k=start;k<end;k++) {
						J[k]=true;
						
					}
					output+='J';
				}
				else {
					System.out.println("Case #"+i+": IMPOSSIBLE");
					possible=false;
				}
			}
			if(possible) {
				
				
				
				System.out.println("Case #"+i+": "+output);
				
			}
		}
	}

}
