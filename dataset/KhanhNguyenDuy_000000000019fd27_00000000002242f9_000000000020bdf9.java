import java.util.*;
public class Solution{
	 public static void main (String[] args){
		 Scanner sc= new Scanner(System.in);
		 int T= sc.nextInt();
		 for(int t = 0 ;t<T;t++){
		 	int N=sc.nextInt();
		 	List<int[]> task= new ArrayList<>();
		 	for(int n=0;n<N;n++){
		 		int[] temp= new int[]{sc.nextInt(),sc.nextInt(),n};
		 		task.add(temp);
		 	}

		 	Collections.sort(task,new Comparator<int[]>(){
		 		public int compare(int[] a, int[] b){
		 			return a[0]-b[0];
		 		}
		 	});

		 	int thresc=0, thresj=0;
		 	Map<Integer, Integer> map= new HashMap<>();
		 	map.put(task.get(0)[2],0); 
		 	thresc= task.get(0)[1];
		 	// 0: "C", 1:  "J"
		 	boolean impossible=false;
		 	for(int i=1;i<N;i++){
		 		if(task.get(i)[0]>=thresc && task.get(i)[0]>=thresj){
		 			if(thresc>thresj){
		 				map.put(task.get(i)[2],0);
		 				thresc= task.get(i)[1];
		 			}
		 			else{
		 				map.put(task.get(i)[2],1);
		 				thresj= task.get(i)[1];
		 			}
		 		}
		 		else if(task.get(i)[0]<thresc && task.get(i)[0]>=thresj){
		 				map.put(task.get(i)[2],1);
		 				thresj= task.get(i)[1];
		 		}
		 		else if(task.get(i)[0]>=thresc && task.get(i)[0]<thresj){
		 				map.put(task.get(i)[2],0);
		 				thresc= task.get(i)[1];
		 		}
		 		else{
		 			impossible=true;
		 			break;
		 		}
		 	}
		 	if(impossible){
		 		System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
		 		continue;
		 	}
		 	String res="";
		 	for(int i=0;i<N;i++){
		 		if(map.get(i)==0){
		 			res+= "C";
		 		}
		 		else{
		 			res+= "J";
		 		}
		 	}
		 	System.out.println("Case #"+(t+1)+": "+res);

		 }
	 }

}