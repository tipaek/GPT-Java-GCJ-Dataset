import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int u=1;
		o: while(t-->0){

			int n=sc.nextInt();
			int i,p;
			String ans="";
			ArrayList<Integer> arr[]=new ArrayList[n];
			for(i=0;i<n;i++)
				arr[i]=new ArrayList<Integer>();
			int a[][]=new int[n][2];
			for(i=0;i<n;i++){
				for(p=0;p<2;p++)
					arr[i].add(sc.nextInt());
				arr[i].add(i);
			}
			int c[]={-1,-1};
			int j[]={-1,-1};
			Arrays.sort(arr,new Comparator<ArrayList<Integer>>(){
				public int compare(ArrayList<Integer> a1,ArrayList<Integer> a2){
					return a1.get(0)-a2.get(0);
				}
			});
			/*for(i=0;i<n;i++)
				System.out.println(arr[i].get(0)+" "+arr[i].get(1));*/
			for(i=0;i<n;i++){
					if(arr[i].get(0)>=c[1]){
						c[0]=arr[i].get(0);
					c[1]=arr[i].get(1);
					ans="C";
					arr[i].add(0);
					}
					else if(arr[i].get(0)>=j[1]){
						j[0]=arr[i].get(0);
					j[1]=arr[i].get(1);
					ans="J";
					arr[i].add(1);
					}
					else{
						//System.out.println("IMPOSSIBLE");
						//arr[i].add(-1);
						System.out.println("Case #"+u+": IMPOSSIBLE");
						u++;
						continue o;
					}
				//System.out.println(ans);
			}
			Arrays.sort(arr,new Comparator<ArrayList<Integer>>(){
				public int compare(ArrayList<Integer> a1,ArrayList<Integer> a2){
					return a1.get(2)-a2.get(2);
				}
			});
			System.out.print("Case #"+u+": ");
			for(i=0;i<n;i++){
				System.out.print((arr[i].get(3)==0?"C":"J"));
			}
			System.out.println();
			u++;
		}
	}
}