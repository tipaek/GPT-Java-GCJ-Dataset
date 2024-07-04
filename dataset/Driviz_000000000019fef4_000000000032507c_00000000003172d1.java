package codejamround1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PancakeChoppers {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int test=0;
		while(test++<T)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int D=Integer.parseInt(st.nextToken());
			boolean flag=false;
			TreeMap<Long, Integer> hm=new TreeMap<>();
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				long key = Long.parseLong(st.nextToken());
				hm.put(key, hm.getOrDefault(key, 0)+1);
				if(hm.get(key)==D) {
					flag=true;
					break;
				}
			}
			System.out.print("Case #"+test+": ");
			if(flag) {
				System.out.println(0);
				continue;
			}
			
			if(D==2)
			{
				System.out.println(1);
				continue;
			}
			
			if(N==1)
			{
				System.out.println(D-1);
				continue;
			}
			
			for (Long key : hm.keySet()) {
				if(hm.containsKey((D-1)*key))
				{
					flag=true;
					break;
				}
			}
			
			if(flag)
			{
				System.out.println(D-2);
				continue;
			}
			
			System.out.println(3);

		}
	}

}
