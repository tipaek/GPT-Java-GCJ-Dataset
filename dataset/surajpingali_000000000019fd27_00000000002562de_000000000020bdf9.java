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
            
        Arrays.sort(arr,new Comparator<int[]>(){
		
    	public int compare(int[]a,int[]b){
	    	return a[0]-b[0];
		}
	    });	
	    
        PriorityQueue<Integer>pq = new PriorityQueue<>((x, y) -> x - y);   
        HashMap<Integer,Character>map = new HashMap();
        int flag=0;
        
            for(int i=0;i<n;i++){
                if(pq.size()==0){pq.add(arr[i][1]);map.put(arr[i][1],'C');}
                else{
                    char c='x';
                    while(pq.size()>0){
                        if(arr[i][0]>=pq.peek()){
                            c = map.get(pq.peek());
                            pq.poll();
                        }
	                    else break;
                    }
                    if(c!='x'){
                        pq.add(arr[i][1]);
                        map.put(arr[i][1],c);
                    }
                    else{
                        if(pq.size()<2){
                            
                            if(map.get(pq.peek())=='C')
                            map.put(arr[i][1],'J');
                            else
                            map.put(arr[i][1],'C');
                            pq.add(arr[i][1]);
                        }
                        else{
                            flag=1;break;
                        }
                    }
                }
	
            }
            String ans="";
            if(flag==0)
            for(int i=0;i<n;i++){
                if(map.get(arr1[i][1])=='x'){
                    flag=1;break;
                }
                else
                ans+=map.get(arr1[i][1]);
            }
            
            if(flag==1)
            System.out.println("Case #"+in+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+in+": "+ans);
        }
    }
}