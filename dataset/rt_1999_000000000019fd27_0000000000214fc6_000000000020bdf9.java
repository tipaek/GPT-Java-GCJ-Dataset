import java.util.*;
import java.io.*;
public class Solution{
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t =  sc.nextInt();
		int  o =0;
		while(t-->0){
			o++;
			int n = sc.nextInt();
			char arr[] = new char[2461];
			StringBuilder sb = new StringBuilder();
			boolean b = true;
			for(int i=1;i<=n;i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				int marj = 0;
				int marm = 0;
				for(int j=u;j<v;j++){
					if(arr[j]=='J'){
						marj=1;
					}else if(arr[j]=='C')
						marm=1;
				}
				
				if(marj!=1){
					sb.append("J");
					for(int j=u;j<v;j++)
						arr[j]='J';
				}else if(marm!=1){
					for(int j=u;j<v;j++)
						arr[j]='C';
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