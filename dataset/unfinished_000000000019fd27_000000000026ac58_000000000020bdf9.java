import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = input.nextInt();
			int[] startArr = new int[N];
			int[] endArr = new int[N];
			for(int j=0;j<N;j++) {
				int start = input.nextInt();
				int end = input.nextInt();
				startArr[j]=start;
				endArr[j]=end;
			}
			Arrays.sort(startArr);
			Arrays.sort(endArr);
			int prev=0;
			StringBuilder sb = new StringBuilder("Case #" + i + ": "); 
			for(int e : endArr) {
				int index = getIndex(startArr,0,startArr.length-1,e);
				int act= index-prev+1;
				prev= index+1;
				if(act>2) {
					sb.append("IMPOSSIBLE");
					break;
				}else if(act==2){
					sb.append("JC");
				}else if(act==1){
					sb.append("J");
				}
			}
			System.out.println(sb.toString());
		}
		input.close();

	}
	
	private static int getIndex(int arr[], int l, int r, int x) {
		if(arr[r]<x) {
			return r;
		}
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid] < x && arr[mid + 1] >= x)
				return mid;

			if (arr[mid] >= x)
				return getIndex(arr, l, mid - 1, x);

			return getIndex(arr, mid + 1, r, x);
		}
		return -1;
	}

}