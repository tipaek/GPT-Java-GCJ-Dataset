import java.util.*;
import java.io.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t =  sc.nextInt();
		int  o =0;
		while(t-->0){
			o++;
			int n = sc.nextInt();
			long arr[][] = new long[n+1][n+1];
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					arr[i][j] = sc.nextLong();
				}
			}
			long x =0,ans=0,total=0;
			for(int i=1;i<=n;i++){
				x+=arr[i][i];
			}
			for(int i=1;i<=n;i++){
				HashMap<Long,Integer> hm = new HashMap<>();
				for(int j=1;j<=n;j++){
					if(!hm.containsKey(arr[i][j]))
						hm.put(arr[i][j],1);
					else hm.put(arr[i][j], hm.get(arr[i][j])+1);
				}
				if(hm.size()!=n)
					ans++;
			}
			for(int i=1;i<=n;i++){
				HashMap<Long,Integer> hm = new HashMap<>();
				for(int j=1;j<=n;j++){
					if(!hm.containsKey(arr[j][i]))
						hm.put(arr[j][i],1);
					else hm.put(arr[j][i], hm.get(arr[j][i])+1);
				}
				if(hm.size()!=n)
					total++;
			}
			System.out.println("Case #"+o+": "+x+" "+ans+" "+total);
		}
	}
} 