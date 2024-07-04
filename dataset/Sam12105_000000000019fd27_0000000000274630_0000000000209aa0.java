import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int cse = 1;
		while(t-->0){
			int n = sc.nextInt();
			int z = sc.nextInt();
			
			if(n==5) {
				if(z==6 || z==24){
					sb.append("Case #"+cse+": IMPOSSIBLE");
					sb.append("\n");
				}
				else if(z==5) {
					int sol[][]= {{1,4,5,3,2},{2,1,3,4,5},{3,5,1,2,4},{5,2,4,1,3},{4,3,2,5,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==7) {
					int sol[][]= {{1,2,4,5,3},{5,1,2,3,4},{2,3,1,4,5},{3,4,5,2,1},{4,5,3,1,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==8) {
					int sol[][]= {{1,2,4,3,5},{3,1,2,5,4},{5,3,1,4,2},{4,5,3,2,1},{2,4,5,1,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==9) {
					int sol[][]= {{1,2,4,3,5},{4,3,5,1,2},{5,1,2,4,3},{3,5,1,2,4},{2,4,3,5,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==10) {
					int sol[][]= {{1,4,3,5,2},{5,3,2,4,1},{4,2,1,3,5},{3,1,5,2,4},{2,5,4,1,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==11) {
					int sol[][]= {{2,3,4,5,1},{1,5,3,2,4},{3,2,1,4,5},{5,4,2,1,3},{4,1,5,3,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==12) {
					int sol[][]= {{1,5,4,3,2},{2,3,1,4,5},{4,2,3,5,1},{5,4,2,1,3},{3,1,5,2,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==13) {
					int sol[][]= {{3,2,5,4,1},{1,5,3,2,4},{5,4,1,3,2},{2,3,4,1,5},{4,1,2,5,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==14) {
					int sol[][]= {{3,4,2,1,5},{2,1,3,5,4},{5,3,4,2,1},{1,2,5,4,3},{4,5,1,3,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==15) {
					int sol[][]= {{5,4,1,2,3},{3,1,2,4,5},{2,5,4,3,1},{4,3,5,1,2},{1,2,3,5,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==16) {
					int sol[][]= {{1,3,5,4,2},{5,4,1,2,3},{2,1,3,5,4},{4,5,2,3,1},{3,2,4,1,5}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==17) {
					int sol[][]= {{4,5,3,2,1},{3,1,5,4,2},{5,3,2,1,4},{2,4,1,5,3},{1,2,4,3,5}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==18) {
					int sol[][]= {{4,3,2,1,5},{5,1,4,2,3},{2,4,5,3,1},{1,5,3,4,2},{3,2,1,5,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==19) {
					int sol[][]= {{3,2,4,1,5},{1,5,3,2,4},{2,3,5,4,1},{5,4,1,3,2},{4,1,2,5,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==20) {
					int sol[][]= {{3,4,1,5,2},{4,5,2,1,3},{5,3,4,2,1},{1,2,3,4,5},{2,1,5,3,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==21) {
					int sol[][]= {{4,5,3,1,2},{1,4,2,3,5},{2,3,5,4,1},{3,2,1,5,4},{5,1,4,2,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==22) {
					int sol[][]= {{5,4,3,2,1},{4,5,2,1,3},{1,2,4,3,5},{3,1,5,4,2},{2,3,1,5,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==23) {
					int sol[][]= {{4,3,1,2,5},{1,5,2,4,3},{2,4,5,3,1},{3,1,4,5,2},{5,2,3,1,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==25) {
					int sol[][]= {{5,1,2,3,4},{4,5,1,2,3},{3,4,5,1,2},{2,3,4,5,1},{1,2,3,4,5}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
			}
			else if(n==4) {
				if(z==5 || z==15){
					sb.append("Case #"+cse+": IMPOSSIBLE");
					sb.append("\n");
				}
				else if(z==4) {
					int sol[][]= {{1,2,3,4},{4,1,2,3},{3,4,1,2},{2,3,4,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==6) {
					int sol[][]= {{1,3,2,4},{3,2,4,1},{2,4,1,3},{4,1,3,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==7) {
					int sol[][]= {{1,4,2,3},{3,2,1,4},{4,1,3,2},{2,3,4,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==8) {
					int sol[][]= {{2,3,4,1},{1,2,3,4},{4,1,2,3},{3,4,1,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==9) {
					int sol[][]= {{4,2,3,1},{3,1,4,2},{2,3,1,4},{1,4,2,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==10) {
					int sol[][]= {{1,2,3,4},{2,4,1,3},{3,1,4,2},{4,3,2,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==11) {
					int sol[][]= {{4,2,1,3},{3,1,2,4},{2,3,4,1},{1,4,3,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==12) {
					int sol[][]= {{3,4,1,2},{2,3,4,1},{1,2,3,4},{4,1,2,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==13) {
					int sol[][]= {{4,2,1,3},{1,3,4,2},{3,4,2,1},{2,1,3,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==14) {
					int sol[][]= {{3,1,4,2},{1,4,2,3},{4,2,3,1},{2,3,1,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==16) {
					int sol[][]= {{4,1,2,3},{3,4,1,2},{2,3,4,1},{1,2,3,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
			}
			else if(n==3) {
				if(z==4 || z==5 || z==7 || z==8){
					sb.append("Case #"+cse+": IMPOSSIBLE");
					sb.append("\n");
				}
				else if(z==3) {
					int sol[][]= {{1,2,3},{3,1,2},{2,3,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==6) {
					int sol[][]= {{2,3,1},{1,2,3},{3,1,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==9) {
					int sol[][]= {{3,1,2},{2,3,1},{1,2,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
			}
			else if(n==2) {
				if(z==3){
					sb.append("Case #"+cse+": IMPOSSIBLE");
					sb.append("\n");
				}
				else if(z==2) {
					int sol[][]= {{1,2},{2,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(z==4) {
					int sol[][]= {{2,1},{1,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(sol[i][j]+" ");
						}
						sb.append("\n");
					}
				}
			}
			cse++;
		}
		System.out.print(sb.toString());
		sc.close();
	}
}