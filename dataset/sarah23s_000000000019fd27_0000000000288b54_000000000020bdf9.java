
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.annotation.Generated;

class Work {
	int l ;
	int r ;
	int id ;

	public Work(int id, int l, int r) {
		this.l = l;
		this.r = r;
		this.id = id;
	}

	public void printWork() {
		System.out.println("id: " + id + " l: " + l + " r: " + r );
	}

}

class Solution{

	// sort based on ending time
	public static boolean cmp (Work a, Work b) { 
		if (a.r == b.r) 
			return a.l < b.l;
		return a.r < b.r;
	}



	public static Work[] sort(Work[] arr) {
		Work temp;

		for(int i =0; i< arr.length-1 ; i++) {
			for(int j =0; j< arr.length-1-i ; j++) {
				if(arr[j].r > arr[j+1].r ) {
					temp= new Work(arr[j].id,arr[j].l,arr[j].r);
					arr[j] = new Work(arr[j+1].id,arr[j+1].l,arr[j+1].r);
					arr[j+1] = new Work(temp.id,temp.l,temp.r);
				}

			}

		}



		return arr;
	}



	public static StringBuilder generateString(char[] ans, Work[] mat) {
		StringBuilder res = new StringBuilder();

		for(int i = 0; i < mat.length;i++) {
			for(int j = 0; j < mat.length;j++) {
				if(mat[j].id == i)
					res.append(ans[j]);

			}
		}

		return res;
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


			Work[] myArr = new Work[n];
			//			System.out.println("blaa");
			//			myArr[0].printWork();
			//			System.out.println("blaa2");


			for(int j = 0; j < n ; j++) {
				String[] tempArr = temp[j].split(" ");
				myArr[j] = new Work(j,Integer.parseInt(tempArr[0]),Integer.parseInt(tempArr[1]));

			}

			//-------------------------------------------------------------------

			int C_end = -1;
			int J_end = -1;
			boolean valid = true;



			//
			//			for(int e=0; e<myArr.length;e++) {
			//				myArr[e].printWork();
			//			}


			myArr = sort(myArr);



			for (int j = 0; j < n; j++) {
				if (C_end <= myArr[j].l) {
					ans[myArr[j].id] = 'C';
					C_end = myArr[j].r;
					
				}
				else if (J_end <= myArr[j].l) {
					ans[myArr[j].id] = 'J';
					J_end = myArr[j].r;
				}
				else {
					valid = false;
					break;
				}

			}

			//			System.out.println("before sort");
			//			for(int e=0; e<myArr.length;e++) {
			//				myArr[e].printWork();
			//			}
			//			
			//			
			//			System.out.println("after sort");
			//			for(int e=0; e<myArr.length;e++) {
			//				myArr[e].printWork();
			//			}


			//StringBuilder sb = new StringBuilder();
			//sb = generateString(ans, myArr);

			if(valid) {
				System.out.print("Case #" + (i+1)+": " );

			}else
				System.out.println("Case #" + (i+1)+": IMPOSSIBLE");

			printArr(ans);

		}
	}


	public static void printArr(char[] arr) {
		for(int i=0; i <arr.length;i++) {
			System.out.print(arr[i] );
		}
		System.out.println("");
	}

}
