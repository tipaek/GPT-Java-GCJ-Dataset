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
			pair arr[] = new pair[2461];
			int treminal[] = new int[2461];
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<=2460;i++){
				arr[i] = new pair();
			}
			ArrayList<String> al = new ArrayList<>();
			ArrayList<r> input = new ArrayList<>();
			for(int i=0;i<=n;i++){
				al.add("");
			}
			for(int i=0;i<n;i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				r p = new r();
				p.u=u;
				p.v=v;
				p.index=i;
				input.add(p);
			}
			
			Collections.sort(input, new comp());
			int prevs = -1;
			int preve = -1;
			int count =0;
			for(int i=0;i<n;i++){
				int u = input.get(i).u;
				int v = input.get(i).v;
				int index = input.get(i).index;
				if(u>=preve){
					al.set(index,"J");
					prevs=u;
					preve=v;
					count++;
				}
			}
			prevs=-1;
			preve=-1;
			for(int i=0;i<n;i++){
				
				int u = input.get(i).u;
				int v = input.get(i).v;
				int index = input.get(i).index;
				if(al.get(index).length()!=0)
					continue;
				if(u>=preve){
					al.set(index,"C");
					prevs=u;
					preve=v;
					count++;
				}
			}
			if(count!=n){
				System.out.println("Case #"+o+": "+"IMPOSSIBLE");
			}
			else{
				for(int i=0;i<n;i++){
					sb.append(al.get(i));
				}
				System.out.println("Case #"+o+": "+sb.toString());
			}
		}
	}
	public static class comp implements Comparator<r>{
		public int compare(r o1, r o2){
			if(o1.u==o2.u){
				return o1.v-o2.v;
			}
			return o1.u-o2.u;
		}
	}
	static class r{
		int u=0;
		int v=0;
		int index=0;
		String st = "";
	}
	static class pair{
		int j = 0;
		int c = 0;
	}
} 