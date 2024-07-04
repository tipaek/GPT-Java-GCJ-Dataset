import java.util.*;
import java.io.*;
 class Solution {
	public static void main(String[] args) {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
	int t=in.nextInt();
	int te=0;
	while(t-->=0){
		int n=in.nextInt();
		int[][] a=new int[n][n];
		int[][] b=new int[n][n];
int trace=0;
int maxR=0,maxC=0;
				for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++){
				a[i][j]=in.nextInt();
				b[j][i]=a[i][j];
				if(i==j)
				 trace+=a[i][j];
				 }
				 maxR=Math.max(maxR,comp(a[i]));
				 }
			
			for(int j=0;j<n;j++){
				maxC=Math.max(maxC,comp(b[j]));
				}
	if(maxR==1) maxR=0;
	if(maxC==1) maxC=0;
	System.out.println("Case #"+(++te)+": "+trace+" "+maxR+" "+maxC);
	}
	}
	
	
	static int comp(int [] arrA){
     HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <arrA.length; i++) {
            if(map.containsKey(arrA[i])){
                map.put(arrA[i],map.get(arrA[i])+1);
            }else{
                map.put(arrA[i], 1);
            }
        }

        //traverse the map and track the element which has max count
        Iterator entries = map.entrySet().iterator();
        int maxCount = 0;
        int element =arrA[0];
        while(entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            int count = (Integer)entry.getValue();
            if(maxCount<count){
                maxCount = count;
                element = (Integer)entry.getKey();
            }
        }
  //      System.out.println("Element repeating maximum no of times: " + element + ", maximum count: " + maxCount);
        return maxCount;
    }
	


}