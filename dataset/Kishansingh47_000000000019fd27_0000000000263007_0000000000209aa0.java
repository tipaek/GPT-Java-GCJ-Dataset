
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
			int k = sc.nextInt();
			
			if(n==5) {
				if(k==6 || k==24)
					sb.append("Case #"+cse+": IMPOSSIBLE");
				else if(k==5) {
					int ans[][]= {{1,4,5,3,2},{2,1,3,4,5},{3,5,1,2,4},{5,2,4,1,3},{4,3,2,5,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==7) {
					int ans[][]= {{1,2,4,5,3},{5,1,2,3,4},{2,3,1,4,5},{3,4,5,2,1},{4,5,3,1,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==8) {
					int ans[][]= {{1,2,4,3,5},{3,1,2,5,4},{5,3,1,4,2},{4,5,3,2,1},{2,4,5,1,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==9) {
					int ans[][]= {{1,2,4,3,5},{4,3,5,1,2},{5,1,2,4,3},{3,5,1,2,4},{2,4,3,5,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==10) {
					int ans[][]= {{1,4,3,5,2},{5,3,2,4,1},{4,2,1,3,5},{3,1,5,2,4},{2,5,4,1,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==11) {
					int ans[][]= {{2,3,4,5,1},{1,5,3,2,4},{3,2,1,4,5},{5,4,2,1,3},{4,1,5,3,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==12) {
					int ans[][]= {{1,5,4,3,2},{2,3,1,4,5},{4,2,3,5,1},{5,4,2,1,3},{3,1,5,2,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==13) {
					int ans[][]= {{3,2,5,4,1},{1,5,3,2,4},{5,4,1,3,2},{2,3,4,1,5},{4,1,2,5,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==14) {
					int ans[][]= {{3,4,2,1,5},{2,1,3,5,4},{5,3,4,2,1},{1,2,5,4,3},{4,5,1,3,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==15) {
					int ans[][]= {{5,4,1,2,3},{3,1,2,4,5},{2,5,4,3,1},{4,3,5,1,2},{1,2,3,5,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==16) {
					int ans[][]= {{1,3,5,4,2},{5,4,1,2,3},{2,1,3,5,4},{4,5,2,3,1},{3,2,4,1,5}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==17) {
					int ans[][]= {{4,5,3,2,1},{3,1,5,4,2},{5,3,2,1,4},{2,4,1,5,3},{1,2,4,3,5}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==18) {
					int ans[][]= {{4,3,2,1,5},{5,1,4,2,3},{2,4,5,3,1},{1,5,3,4,2},{3,2,1,5,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==19) {
					int ans[][]= {{3,2,4,1,5},{1,5,3,2,4},{2,3,5,4,1},{5,4,1,3,2},{4,1,2,5,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==20) {
					int ans[][]= {{3,4,1,5,2},{4,5,2,1,3},{5,3,4,2,1},{1,2,3,4,5},{2,1,5,3,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==21) {
					int ans[][]= {{4,5,3,1,2},{1,4,2,3,5},{2,3,5,4,1},{3,2,1,5,4},{5,1,4,2,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==22) {
					int ans[][]= {{5,4,3,2,1},{4,5,2,1,3},{1,2,4,3,5},{3,1,5,4,2},{2,3,1,5,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==23) {
					int ans[][]= {{4,3,1,2,5},{1,5,2,4,3},{2,4,5,3,1},{3,1,4,5,2},{5,2,3,1,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==25) {
					int ans[][]= {{5,1,2,3,4},{4,5,1,2,3},{3,4,5,1,2},{2,3,4,5,1},{1,2,3,4,5}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
			}
			else if(n==4) {
				if(k==5 || k==15)
					sb.append("Case #"+cse+": IMPOSSIBLE");
				else if(k==4) {
					int ans[][]= {{1,2,3,4},{4,1,2,3},{3,4,1,2},{2,3,4,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==6) {
					int ans[][]= {{1,3,2,4},{3,2,4,1},{2,4,1,3},{4,1,3,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==7) {
					int ans[][]= {{1,4,2,3},{3,2,1,4},{4,1,3,2},{2,3,4,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==8) {
					int ans[][]= {{2,3,4,1},{1,2,3,4},{4,1,2,3},{3,4,1,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==9) {
					int ans[][]= {{4,2,3,1},{3,1,2,4},{2,3,1,4},{1,4,2,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==10) {
					int ans[][]= {{1,2,3,4},{2,4,1,3},{3,1,4,2},{4,3,2,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==11) {
					int ans[][]= {{4,2,1,3},{3,1,2,4},{2,3,4,1},{1,4,3,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==12) {
					int ans[][]= {{3,4,1,2},{2,3,4,1},{1,2,3,4},{4,1,2,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==13) {
					int ans[][]= {{4,2,1,3},{1,3,4,2},{3,4,2,1},{2,1,3,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==14) {
					int ans[][]= {{3,1,4,2},{1,4,2,3},{4,2,3,1},{2,3,1,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==16) {
					int ans[][]= {{4,1,2,3},{3,4,1,2},{2,3,4,1},{1,2,3,4}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
			}
			else if(n==3) {
				if(k==4 || k==5 || k==7 || k==8)
					sb.append("Case #"+cse+": IMPOSSIBLE");
				else if(k==3) {
					int ans[][]= {{1,2,3},{3,1,2},{2,3,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==6) {
					int ans[][]= {{2,3,1},{1,2,3},{3,1,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==9) {
					int ans[][]= {{3,1,2},{2,3,1},{1,2,3}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
			}
			else if(n==2) {
				if(k==3)
					sb.append("Case #"+cse+": IMPOSSIBLE");
				else if(k==2) {
					int ans[][]= {{1,2},{2,1}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
				else if(k==4) {
					int ans[][]= {{2,1},{1,2}};
					sb.append("Case #"+cse+": POSSIBLE");
					sb.append("\n");
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							sb.append(ans[i][j]+" ");
						}
						sb.append("\n");
					}
				}
			}
			sb.append("\n");
			cse++;
		}
		System.out.print(sb.toString());
		sc.close();
	}
}
