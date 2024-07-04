
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int u=0; u<T; u++) {
								//	System.out.println("E1 #");
			int N = (int)in.nextDouble();
			int D = (int)in.nextDouble();
			int[] a = new int[N];
			for(int i=0;i<N;i++) {
				double s = in.nextDouble();
				//System.out.println("E3 #"+s);
				a[i]=(int)s;
			}
			Map<Integer, Integer> map = new HashMap<>();
			int max=0;
			for(int i=0;i<N;i++) {
				if(map.get(a[i])==null)
				map.put(a[i],1);
				else {
					int x = map.get(a[i])+1;
					if(x>max) {
					max=x;
					}
					map.put(a[i],x);
				}
			}
												// System.out.println("max #"+max);
			if(N==1) {
				System.out.println("Case #"+(u+1)+": "+(D-1));
			}else if(D<=max) {
				System.out.println("Case #"+(u+1)+": 0");
			} else {
				TreeMap<Integer,Integer> t = new TreeMap<>(Collections.reverseOrder());
				t.putAll(map);
				int flag=0;
				for (Map.Entry<Integer, Integer> j: t.entrySet()) {
					int x = j.getKey();
					int y = j.getValue();
					int count=1;
					while(x>0 && count<D) {
					//	System.out.println("Map1 #"+x);
						x=x/(count+1);
						count++;
						if(map.get(x)!=null) {
							int z = map.get(x);
							if(z+count>=D) {
								System.out.println("Case #"+(u+1)+": "+(count-1));
								flag=1; break;
							}
						}
											//	System.out.println("Map2 #"+x);
						int p = count*y;
						if(p>=D) {
							System.out.println("Case #"+(u+1)+": "+(count-1)*y);
								flag=1; break;
						}
					}
					if(flag==1)break;
										//	System.out.println("Map3 #"+x);

					map.remove(x);
				}
				if(flag==0) {
					System.out.println("Case #"+(u+1)+": "+(D-1));
				}
			}
		}
	}
}