import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Activities {
	int startTime ;
	int endTime ;
	int index ;

	public Activities(int index, int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.index = index;
	}

//	public void printActivities() {
//		System.out.println("index: " + index + " startTime: " + startTime + " endTime: " + endTime);
//	}

}


public class Solution{



	public static Activities[] sort(Activities[] arr) {
		Activities temp;

		for(int i =0; i< arr.length-1 ; i++) {
			for(int j =0; j< arr.length-1-i ; j++) {
				if(arr[j].startTime > arr[j+1].startTime ) {
					temp= new Activities(arr[j].index,arr[j].startTime,arr[j].endTime);
					arr[j] = new Activities(arr[j+1].index,arr[j+1].startTime,arr[j+1].endTime);
					arr[j+1] = new Activities(temp.index,temp.startTime,temp.endTime);
				}

			}

		}

		return arr;
	}



//	public static StringBuilder generateString(char[] ans, Activities[] mat) {
//		StringBuilder res = new StringBuilder();
//
//		for(int i = 0; i < mat.length;i++) {
//			for(int j = 0; j < mat.length;j++) {
//				if(mat[j].index == i)
//					res.append(ans[j]);
//
//			}
//		}
//
//		return res;
//	}


	public static StringBuilder printArr(char[] arr) {
		StringBuilder sb = new StringBuilder();

		for(int i=0; i <arr.length;i++) {
			sb.append(arr[i]);
		}

		return sb;
	}



	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());


		for(int i = 0; i <testCases; i++) {
			int n = Integer.parseInt(br.readLine());

			String[] temp = new String[n];
			for(int j = 0; j< n;j++) {
				temp[j] = br.readLine();
			}

			char[] ans = new char[n];


			Activities[] myArr = new Activities[n];
			
			for(int j = 0; j < n ; j++) {
				String[] tempArr = temp[j].split(" ");
				myArr[j] = new Activities(j,Integer.parseInt(tempArr[0]),Integer.parseInt(tempArr[1]));

			}

			//-------------------------------------------------------------------

			int C_end = -1;
			int J_end = -1;
			boolean valid = true;

			myArr = sort(myArr);



			for (int j = 0; j < n; j++) {
				if (C_end <= myArr[j].startTime) {
					ans[myArr[j].index] = 'C';
					C_end = myArr[j].endTime;

				}
				else if (J_end <= myArr[j].startTime) {
					ans[myArr[j].index] = 'J';
					J_end = myArr[j].endTime;
				}
				else {
					valid = false;
					break;
				}

			}

			if(valid) {
				System.out.println("Case #" + (i+1)+": " + printArr(ans));

			}else
				System.out.println("Case #" + (i+1)+": IMPOSSIBLE");

//			printArr(ans);

		}
	}
}