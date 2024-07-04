import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[]args) throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = Integer.parseInt(sc.nextLine().trim());
		for(int i=1;i<=t;i++) {
			int N = Integer.parseInt(sc.nextLine());
			int[]C=new int[1440];
			int[]J=new int[1440];
			Arrays.fill(C, -1);
			Arrays.fill(J, -1);
			int[][]test = new int[2][N];
			String output = "C";
			boolean possible=true;
			String[] st = (sc.nextLine().split(" "));

			int start = Integer.parseInt(st[0]);
			int end = Integer.parseInt(st[1]);
			test[0][0]=start;
			test[1][0]=end;
			
			for(int k=start;k<end;k++) {
				C[k]=0;
			}

			for(int j=1;j<N;j++) {
				
				st = (sc.nextLine().split(" "));
				start = Integer.parseInt(st[0]);
				end = Integer.parseInt(st[1]);
				
				boolean csjob=true;
				boolean jsjob=true;
				ArrayList<Integer>holdC = new ArrayList<Integer>();
				ArrayList<Integer>holdJ = new ArrayList<Integer>();
				for(int k=start;k<end;k++) {
					if(C[k]>=0&&!holdC.contains(C[k])) {
						csjob=false;
						holdC.add(C[k]);
						
					}
					if(J[k]>=0&&!holdJ.contains(J[k])) {
						jsjob=false;
						holdJ.add(J[k]);
						
					}

				}
				if(csjob) {
					for(int k=start;k<end;k++) {
						C[k]=j;

					}
					output+='C';
				}
				else if(jsjob) {
					for(int k=start;k<end;k++) {
						J[k]=j;

					}
					output+='J';
				}
				else {
					int totalC=0;
					for(int b=0;b<holdC.size();b++) {
						int stew =0;
						
						while(C[stew]!=holdC.get(b)) {
							stew++;
						}
						int ew= stew;
						while(ew<J.length-1&&C[ew+1]==holdC.get(b)) {
							ew++;
						}
						boolean ours =true;
						for(int f=stew;f<ew;f++) {
							if(J[f]>-1) {
								ours=false;
							}
						}
						if(ours) {
							totalC++;
						}
					}
					if (totalC==holdC.size()) {
						for(int b=0;b<holdC.size();b++) {
							int stew =0;
							
							while(C[stew]!=holdC.get(b)) {
								stew++;
							}
							int ew= stew;
							while(ew<J.length-1&&C[ew+1]==holdC.get(b)) {
								ew++;
							}
							
							for(int f=stew;f<ew;f++) {
								C[f]=-1;
								J[f]=holdC.get(b);
								
							}
							
						}
						for(int k=start;k<end;k++) {
							C[k]=j;

						}
						for(int b=0;b<holdC.size();b++) {
							output = output.substring(0,b)+"J"+output.substring(b+1);
						}
						output+="C";
					}
					else{
						int totalJ=0;
						for(int b=0;b<holdJ.size();b++) {
							int stew =0;
							
							while(J[stew]!=holdJ.get(b)) {
								stew++;
							}
							int ew= stew;
							while(ew<J.length-1&&J[ew+1]==holdJ.get(b)) {
								ew++;
							}
							boolean ours =true;
							for(int f=stew;f<ew;f++) {
								if(C[f]>-1) {
									ours=false;
								}
							}
							if(ours) {
								totalJ++;
							}
						}
						
						if (totalJ==holdJ.size()) {
							for(int b=0;b<holdJ.size();b++) {
								int stew =0;
								
								while(J[stew]!=holdJ.get(b)) {
									stew++;
								}
								int ew= stew;
								while(ew<C.length-1&&J[ew+1]==holdJ.get(b)) {
									ew++;
								}
								
								for(int f=stew;f<ew;f++) {
									J[f]=-1;
									C[f]=holdJ.get(b);
									
								}
								
							}
							for(int k=start;k<end;k++) {
								J[k]=j;

							}
							for(int b=0;b<holdJ.size();b++) {
								output = output.substring(0,b)+"C"+output.substring(b+1);
							}
							output+="C";
						}
						else {
						possible=false;
						}
					}
					
				}
			}
			if(possible) {
				System.out.println("Case #"+i+": "+output);

			}
			else {
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}
		}
	}

}
