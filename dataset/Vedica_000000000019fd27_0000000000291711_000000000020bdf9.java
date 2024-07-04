import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int noCases=0;
		String finalRes="";
		int Size=0;
		noCases=sc.nextInt();
		for(int i=0;i<noCases;i++) {
			Size=sc.nextInt();
			int arr[][]=new int[Size][2];
			for(int j=0;j<Size;j++) {
				arr[j][0]=sc.nextInt();
				arr[j][1]=sc.nextInt();
			}
			Arrays.sort(arr, new java.util.Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return Integer.compare(a[0], b[0]);
			    }
			});
			String res="C";
			int StartC=arr[0][0];
			int endC=arr[0][1];
			int StartJ=0;
			int endJ=0;
			
			res=tryParenting(1,StartC,endC,StartJ,endJ,"C",arr);
			finalRes=finalRes+"Case #"+(i+1)+": "+res+"\n";
		}
		System.out.println(finalRes);
		
		
	}
	static String tryParenting(int Curr, int StartC, int endC, int StartJ, int endJ, String res, int arr[][]) {
				if(arr.length==Curr) {
						return res;
		}
		if(!(endC<=arr[Curr][0]) && !(endJ<=arr[Curr][0])) {
			res="IMPOSSIBLE";
			return "IMPOSSIBLE";
		}
		if(endC<=arr[Curr][0]) {
			endC=arr[Curr][1];
			res=res+"C";
			res=tryParenting(Curr+1,StartC,endC,StartJ,endJ,res,arr);
			if(res.equals("IMPOSSIBLE")){
				return "IMPOSSIBLE";
			}
		}
		
		else{
			if(endJ<=arr[Curr][0]) {
			endJ=arr[Curr][1];
			res=res+"J";
			res=tryParenting(Curr+1,StartC,endC,StartJ,endJ,res,arr);

			if(res.equals("IMPOSSIBLE")){
				return "IMPOSSIBLE";
			}
		}
		}
		return res;
	}

}
