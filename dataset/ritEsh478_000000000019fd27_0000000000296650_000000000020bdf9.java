import java.util.*;

class Solution{
	public static void main(String []args) throws Exception{
	  Scanner sc=new Scanner(System.in);
	  int t=sc.nextInt();
	  int l=1;
	  while(l<=t){
		int n=sc.nextInt();
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		HashMap<Integer,Character> pam=new HashMap<Integer,Character>();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			int scan=sc.nextInt();
			arr[i]=scan;
			map.put(scan,sc.nextInt());
		}

		for(Map.Entry<Integer,Integer> mp:map.entrySet()){
				int x=mp.getKey();
				int y=mp.getValue();
				pam.put(x,'C');
					for(Map.Entry<Integer,Integer> mp1:map.entrySet()){
						if(y<=mp1.getKey()){
							pam.put(mp1.getKey(),'C');
							y=mp1.getValue();
							}
						}
					break;

			}

				for(Map.Entry<Integer,Integer> mp1:map.entrySet()){
					if(pam.containsKey(mp1.getKey())==false){
						int x1=mp1.getKey();
						int y1=mp1.getValue();
						pam.put(x1,'J');
							for(Map.Entry<Integer,Integer> mp11:map.entrySet()){
								if(pam.containsKey(mp11.getKey())==false){
								if(y1<=mp11.getKey()){
									pam.put(mp11.getKey(),'J');
									y1=mp11.getValue();
									}
								}
							}
							break;
					}

			}
		String res="";
		int f=0;
		for(int i=0;i<n;i++){
			if(pam.containsKey(arr[i])==false){
				f=1;
				break;
				}
				else{
				res=res+(""+ pam.get(arr[i]));
			}
			}
			if(f==0)
			System.out.println("Case #"+l+": "+res);
			else
			System.out.println("Case #"+l+": IMPOSSIBLE");

			l++;
	  }
	}
}