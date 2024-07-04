import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			for(int z=1;z<=t;z++) {
				HashMap<Long, Integer> map = new HashMap<>();
				HashMap<Long, Integer> map1 = new HashMap<>();
				int n = in.nextInt();
				int d = in.nextInt();
				long ar[] = new long[n];
				for(int i=0;i<n;i++) {
					ar[i] = in.nextLong();
				}
				int cd=0;
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(ar[i]==ar[j]) {
							cd+=1;
						}
					}
					map.put(ar[i],cd);
					cd=0;
				}
				for(int i:map.values()) {
					if(i>=d) {
						cd=1;
						break;
					}
				}
				if(cd==1) {
					System.out.println("Case #"+z+": "+0);
				}
	
				else {
					int max=0;
					long maxk=0;
					for(Map.Entry<Long,Integer> i : map.entrySet()) {
						if(i.getValue()>max) {
							max=i.getValue();
							maxk = i.getKey();
						}
					}
					long div=0;int count=0;
					for(Map.Entry<Long,Integer> i: map.entrySet()) {
						if(i.getKey()%maxk==0 && i.getKey()!=maxk) {
							count+=1;
							map1.put(i.getKey(),i.getValue());}
					/*		for(int j=1;j<=i.getKey();j++) {
								if(i.getKey()/j==maxk) {
									div=j-1;
									break;
								}
							}
							if((div*i.getValue())+(maxk*max)>=d) {
								cd=2;
								break;
							}
						
						}*/
					}
					for(Map.Entry<Long,Integer> i: map1.entrySet()) {
						for(int j=1;j<=i.getKey();j++) {
							if(i.getKey()/j==maxk) {
								div=j-1;
								break;
							}
						}
						if((div*i.getValue())+(maxk*max)>=d) {
							cd=2;
							break;
						}
					}
					if(cd==2) {
						System.out.println("Case #"+z+": "+div);
					}
					if(count==0) {
						System.out.println("Case #"+z+": "+(d-1));
					}
					
				}
			}
		}catch(Exception e) {
			return;
		}
	}

}
