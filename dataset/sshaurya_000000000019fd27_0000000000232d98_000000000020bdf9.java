import java.util.*;

class Solution{
    
    
    public static void main(String[] args){
        
        
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int j=0;j<t;j++){
            int cprev=0;
            int jprev=0;
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
            boolean flag=false;
            int n=sc.nextInt();
            String resul1t;
            for(int i=0;i<n;i++){
                int start=sc.nextInt();
                int end=sc.nextInt();
                pq.offer(new int[]{start,end,i});
            }
            char[] result=new char[n];
        while(pq.size()!=0) {
        	int curr[]=pq.poll();
        	int start=curr[0];
        	int end=curr[1];
        	
        	if(start>=cprev) {
        		result[curr[2]]='C';
        		cprev=end;
        	}
        	else if(start>=jprev) {
        		result[curr[2]]='J';
        		jprev=end;
        	}
        	else {
        		flag=true;
        		break;
        	}
        	
        	
        }
        if(!flag)
        resul1t=new String(result);
        else
        resul1t="IMPOSSIBLE";
        System.out.println("Case #"+(j+1)+": "+resul1t);
            
        }
    }
}