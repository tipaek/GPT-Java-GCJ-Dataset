import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t =  sc.nextInt();
		int  o =0;
		while(t-->0){
			o++;
			int n = sc.nextInt();
			int janestart =-1 ;
			int janeend = -1;
			int mstart = -1;
			int mend =-1;
			StringBuilder sb = new StringBuilder();
			boolean b = true;
			for(int i=1;i<=n;i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				if(u>=janeend || v<=janestart){
					janestart = u;
					janeend = v;
					sb.append("J");
				}else if(u>=mend || v<=mstart){
					mstart = u;
					mend = v;
					sb.append("C");
				}else{
					System.out.println("Case #"+o+": "+"IMPOSSIBLE");
					b=false;
					break;
				}
			}
			if(b==true)
			System.out.println("Case #"+o+": "+sb.toString());
		}
	}
} 