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
			
			char[]output = new char[N];
			boolean possible=true;
			for(int j=0;j<N;j++) {

				String[] st = (sc.nextLine().split(" "));
				int start = Integer.parseInt(st[0]);
				int end = Integer.parseInt(st[1]);
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
					output[j]='C';
				}
				else if(jsjob) {
					for(int k=start;k<end;k++) {
						J[k]=true;
						
					}
					output[j]='J';
				}
				else {
					System.out.println("Case #"+i+": IMPOSSIBLE");
					possible=false;
				}
			}
			if(possible) {
				String real ="";
				for(int q=0;q<output.length;q++) {
					real+=output[q];
				}
				
				System.out.println("Case #"+i+": "+real);
				
			}
		}
	}

}
