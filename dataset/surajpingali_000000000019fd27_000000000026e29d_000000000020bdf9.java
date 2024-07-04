import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int in=1;in<=t;in++){
            int n=sc.nextInt();
            int[][]arr = new int[n][3]; 
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            	arr[i][2]=i;
            }
        Arrays.sort(arr,new Comparator<int[]>(){
    	public int compare(int[]a,int[]b){
	    	return a[0]-b[0];
		}});	
			int[]ans = new int[n];
			int[]ab = new int[2];
			String res="";
        PriorityQueue<loc>pq = new PriorityQueue<>((loc x,loc y) -> x.end - y.end);   
			pq.add(new loc(arr[0][0],arr[0][1],arr[0][2],'C'));
			ans[arr[0][2]]=0;
			ab[0]=1;
			int flag=0;
			for(int i=1;i<n;i++){
				while(pq.size()>0){
					if(arr[i][0]>=pq.peek().end){
						char c=pq.peek().f;
						ab[c=='C'?0:1]=0;
						pq.poll();
					}
					else break;
				}
				if(pq.size()==0 || arr[i][0]<pq.peek().end){
					if(ab[0]==1 && ab[1]==1){
						flag=1;
						break;
					}
					else if(ab[0]==0){
						ab[0]=1;
						ans[arr[i][2]]=0;
						pq.add(new loc(arr[i][0],arr[i][1],arr[i][2],'C'));
					}
					else if(ab[1]==0){
						ab[1]=1;
						ans[arr[i][2]]=1;
						pq.add(new loc(arr[i][0],arr[i][1],arr[i][2],'J'));
					}
				}
				
			}
	        
	        if(flag==0){
				for(int i=0;i<n;i++)
				res+=(ans[i]==0)?'C':'J';
			}   
	            
            if(flag==1)
            System.out.println("Case #"+in+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+in+": "+res);
        }
}
	
    }
	
class loc{
	int start,end,index; char f;
	loc(int start,int end,int index,char f){
		this.start=start;
		this.end=end;
		this.f=f;
	}
}