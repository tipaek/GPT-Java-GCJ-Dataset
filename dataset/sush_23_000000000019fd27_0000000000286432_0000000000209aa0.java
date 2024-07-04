import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
	   // ArrayList<String> res = new ArrayList<>();
        out:for(int t=1;t<=T;t++){
            int n = sc.nextInt(), k=sc.nextInt();
			int arr[][] = new int[n][n];
            ArrayList<ArrayList<Integer>> al = solve(n,k);
			for(ArrayList<Integer> ans:al){
				if(ans.size()!=n)continue;
				Set<Integer> set = new HashSet<>();
				set.addAll(ans);
				if(set.size()!=2){
					arr = new int[n][n];
					for(int i=0;i<n;i++) arr[i][i] = ans.get(i);
					//for(int a[]:arr)for(int x:a)System.out.print(x+" ");System.out.println();
					if(isPossible(arr,n,0,0)){
					System.out.println("Case #"+t+": POSSIBLE");
						for(int a[]:arr){
						for(int x:a){
						System.out.print(x+" ");
						}System.out.println();}
						continue out;
					}
				}
			}
			System.out.println("Case #"+t+": IMPOSSIBLE");
        }
    }
	static boolean isPossible(int arr[][],int n,int r,int c){
	if(c>n-1) return isPossible(arr,n,r+1,0);
	if(r == c){
		if(r == n-1) return true;
		return isPossible(arr,n,r,c+1);
	}
		//for(int i=0;i<n;i++)
		//	for(int j=0;j<n;j++)
				//if(i==j)continue;
				//if(arr[i][j]!=0)continue;
				for(int k=1;k<=n;k++){
					if(isCorrect(arr,n,r,c,k)){
						if(isPossible(arr,n,r,c+1)) return true;
						arr[r][c] = 0;
					}
				}
				return false;
			}
	static boolean isCorrect(int arr[][],int n,int i,int j,int k){
		for(int r=0;r<n;r++)if(arr[r][j] == k) return false;
		for(int c=0;c<n;c++)if(arr[i][c] == k) return false;
		arr[i][j] = k;
		return true;
	}
		//return false;
	
    static ArrayList<ArrayList<Integer>> solve(int n,int k){
	
        ArrayList<ArrayList<Integer>> dp1[] = new ArrayList[k+1];
        for(int j=0;j<=k;j++)dp1[j] = new ArrayList<ArrayList<Integer>>();
		//System.out.println(Arrays.toString(dp1));
        for(int i=1;i<=n;i++){
		
       	 	ArrayList<ArrayList<Integer>> dp2[] = new ArrayList[k+1];
			
			for(int j=0;j<=k;j++){
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
				
			if(j==0){dp2[j] = temp; continue;}
			
            if(j-i >= 0){
			if(dp2[j-i].size()==0){ ArrayList<Integer> t = new ArrayList<>(); t.add(i); temp.add(t);dp2[j] = temp;}
			
			else{
			if(!(dp2[j-i].size() == 1 && dp2[j-1].get(0).get(0) == -1)){
			for(ArrayList<Integer> same:dp2[j-i]){
				if(same.size()<n){
				ArrayList<Integer> t =new ArrayList<>(same);
				t.add(i);;
				temp.add(t); }
				}
				}
				}	
				}
				
			if(!(dp1[j].size()==0 || (dp1[j].size() == 1 && dp1[j].get(0).get(0) == -1))){
			
				for(ArrayList<Integer> above:dp1[j])
				temp.add(above);
				}
				if(temp.size()==0){ArrayList t = new ArrayList<Integer>(); t.add(-1); temp.add(t);}
				dp2[j]=temp;
			}
			dp1 = dp2;
			
			/*for(int j=0;j<=k;j++){
				System.out.print(dp1[j]+" ");
			}	
			System.out.println();*/
			}
			//for(int i=0;i<n;i++){
			
			
			/*	Set<Integer> set = new HashSet<>(ans);
				if(set.size()!=2)
			}*/
			return dp1[k];
			}
}