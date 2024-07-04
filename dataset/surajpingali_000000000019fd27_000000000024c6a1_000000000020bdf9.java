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
	
            int[] res = new int[(24*60)+1];
            String ans = "";
            int flag=0;
            HashMap<Integer,Character>map = new HashMap();
            
            for(int i=0;i<n;i++){
                int k=-1;
                if(res[arr[i][0]]==0||res[arr[i][0]]==2){k=1;map.put(arr[i][0],'C');}
                else if(res[arr[i][0]]==1){
                    k=2;map.put(arr[i][0],'J');
                }
                for(int j=arr[i][0];j<arr[i][1];j++){
                    res[j]+=k;
                }
            }
            
            if(flag == 1){
                System.out.println("Case #"+in+": "+"IMPOSSIBLE");
            }
            else{
                for(int i=0;i<n;i++){
                    if(map.containsKey(arr1[i][0]))
                	ans+=map.get(arr1[i][0]);
                	else{
                	    ans = "IMPOSSIBLE";break;
                	}
	            }
                System.out.println("Case #"+in+": "+ans);
            }
        }
    }
}