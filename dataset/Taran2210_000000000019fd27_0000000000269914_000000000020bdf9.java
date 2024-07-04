


import java.util.*;
public class Solution {
	
	static class Pair{
		int a,b;
		Pair(int a , int b){
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s= new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int i =1;i<=T;i++){
			int N = s.nextInt();
			int arr[][] = new int[N][3];
			
			for(int j=0;j<N;j++){
				arr[j][0] = s.nextInt();
				arr[j][1] = s.nextInt();
				arr[j][2] = j;
			}
			
			Arrays.sort(arr,new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if(o1[1]<o2[1])
						return -1;
					if(o1[1]>o2[1])
						return 1;
					return 0;
				}
			});
			
			Stack<Pair> sc  = new Stack<Pair>();
			Stack<Pair> sj  = new Stack<Pair>();
			int flag=0;
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<N;j++)
				sb.append("A");
			
			for(int j=0;j<N;j++){
				Pair temp;
				Pair p = new Pair(arr[j][0],arr[j][1]);
				if(!sc.empty()){
					temp =sc.peek();
					if(temp.b<=p.a){
						sc.push(p);
//						sb.replace(arr[j][2],"C");
						sb.replace(arr[j][2], arr[j][2]+1, "C");
					}
					else{
						if(!sj.empty()){
							temp =sj.peek();
							if(temp.b<=p.a){
								sj.push(p);
								sb.replace(arr[j][2], arr[j][2]+1, "J");
							}
							else{
								flag=1;
								break;
							}
						}else{
							sj.push(p);
							sb.replace(arr[j][2], arr[j][2]+1, "J");
						}
					}
				}
				else{
					sc.push(p);
					sb.replace(arr[j][2], arr[j][2]+1, "C");
				}
				
			}
			
			if(flag==1){
				sb = new StringBuilder();
				sb.append("IMPOSSIBLE");
			}
			
			System.out.println("Case #"+i+": "+sb.toString());
		}

	}

}
