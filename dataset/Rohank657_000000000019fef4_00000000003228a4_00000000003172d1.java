import java.io.*;
import java.util.*;
class Solution {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		for(int i = 1;i<=t;i++) {
			String[] temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int d = Integer.parseInt(temp[1]);
			boolean flag = false;
			String[] arr = br.readLine().split(" ");
			HashMap<Long,Integer> hm = new HashMap<Long,Integer>();
			long[] arr2 = new long[arr.length];
			int counter2 = 0;
			for(int j = 0;j<arr.length;j++) {
				if(hm.containsKey(Long.parseLong(arr[j]))) {
					if(d==2) {
						flag = true;
						break;
					}
					hm.replace(Long.parseLong(arr[j]), hm.get(Long.parseLong(arr[j]))+1);
					arr2[counter2] = Long.parseLong(arr[j]);
					counter2++;
					if(d==3 && hm.get(Long.parseLong(arr[j]))==3) {
						flag = true;
						break;
					}
				}
				else {
					hm.put(Long.parseLong(arr[j]),1);
				}
			}
			if(flag) {
				System.out.println("Case #"+i+": 0");
				continue;
			}
			if(d==2) {
				System.out.println("Case #"+i+": 1");
				continue;
			}
			boolean flag2 = false;
			Iterator iter = hm.entrySet().iterator();
			while(iter.hasNext()) {
				Map.Entry mapElement = (Map.Entry)iter.next(); 
				long key = (long)mapElement.getKey();
				if(hm.containsKey(key*2)) {
					System.out.println("Case #"+i+": 1");
					flag2 = true;
					break;
				}
				for(int k=0;k<counter2;k++) {
					if(arr2[k]<key) {
						System.out.println("Case #"+i+": 1");
						flag2=true;
						break;
					}
				}
				if(flag2) break;
			}
			if(!flag2) {
				System.out.println("Case #"+i+": 2");
			}
		}
	}

}
