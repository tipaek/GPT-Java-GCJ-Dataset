import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int in=1;in<=t;in++){
            int n=sc.nextInt();
            int[][]arr = new int[n][2]; 
	        int[][]arr1=new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            	arr1[i][0]=arr[i][0];
	            arr1[i][1]=arr[i][1];
            }
            ArrayList<loc>al = new ArrayList();
        Arrays.sort(arr,new Comparator<int[]>(){
		
    	public int compare(int[]a,int[]b){
	    	return a[0]-b[0];
		}
	    });	
	    
        PriorityQueue<loc>pq = new PriorityQueue<>((loc x,loc y) -> x.end - y.end);   
        	
			pq.add(new loc(arr[0][0],arr[0][1],'C'));
			al.add(new loc(arr[0][0],arr[0][1],'C'));
			int flag=0;
			for(int i=1;i<n;i++){
				char c='x';
				//System.out.println(pq);
				while(pq.size()>0){
					if(arr[i][0]>=pq.peek().end){
						c=pq.peek().f;
						pq.poll();
					}
					else break;
				}
				
				if(c!='x'){
					pq.add(new loc(arr[i][0],arr[i][1],c));
					al.add(new loc(arr[i][0],arr[i][1],c));
				}
				else{
					if(pq.size()<2){
                            if(pq.peek().f=='C'){
                           	pq.add(new loc(arr[i][0],arr[i][1],'J'));
							al.add(new loc(arr[i][0],arr[i][1],'J'));
							}
                            else{
                            pq.add(new loc(arr[i][0],arr[i][1],'C'));
							al.add(new loc(arr[i][0],arr[i][1],'C'));
							}
                        }
                        else{
                            flag=1;break;
                        }
				}
			}
	        String ans="";
	        if(flag==0){
				
				for(int i=0;i<n;i++){
					for(int j=0;j<al.size();j++){
						if(arr1[i][0]==al.get(j).start && arr1[i][1]==al.get(j).end){
							ans+=al.get(j).f;
							break;
						}
					}
				}
			}   
	            
            if(flag==1)
            System.out.println("Case #"+in+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+in+": "+ans);
        }
}
    }
	
class loc{
	int start,end; char f;
	loc(int start,int end,char f){
		this.start=start;
		this.end=end;
		this.f=f;
	}
}