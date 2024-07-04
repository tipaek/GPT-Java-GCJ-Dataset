import java.util.*;
import java.io.*;

public class Solution {
	
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void read(int[] arr, int start, int end){
		for(int i = start; i < end; i++){
			System.out.println(start+1);
			arr[i] = in.nextInt();
		}
	}
	
	//1- Complemented
	//2- Reversed
	//3- Complemented and Reversed
	//4- Nothing Happened
	public static int compare(int[] og, int[] ne){
		boolean t1 = false;
		boolean t2 = false;
		boolean t3 = false;
		boolean t4 = false;
		for(int i = 0; i < 5; i++){
			if(!(og[i] == ne[i] && og[i+15] == ne[i+15])){
				t4 = true;
			}
		}
		if(!t4){
			for(int i = 0; i < 5; i++){
				if(!((og[i] == 0 && ne[i] == 1) || (og[i] == 1 && ne[i] == 0) || (og[i+15] == 0 && ne[i+15] == 1) || (og[i+15] == 1 && ne[i+15] == 0))){
					t1 = true;
				}
			}
		}
		for(int i = 0; i < 5; i++){
			if(!(og[i] == ne[19-i]))
				t2 = true;
		}
		for(int i = 0; i < 5; i++){
			if(!((og[i] == 0 && ne[i] == 1) || (og[i] == 1 && ne[i] == 0) || (og[i+15] == 0 && ne[i+15] == 1) || (og[i+15] == 1 && ne[i+15] == 0)) && !(og[i] == ne[19-i]))
				t3 = true;
		}
		
		if(!t1) return 1;
		else if(!t2) return 2;
		else if(!t3) return 3;
		else return 4;
	}
	
	public static void adjust(int mode, int[] arr){
		if(mode == 1){
			for(int i = 0; i < arr.length; i++){
				if(arr[i] == 1)
					arr[i] = 0;
				else
					arr[i] = 1;
			}
		}else if(mode == 2){
			Collections.reverse(Arrays.asList(arr));
		}else if(mode == 3){
			Collections.reverse(Arrays.asList(arr));
			for(int i = 0; i < arr.length; i++){
				if(arr[i] == 1)
					arr[i] = 0;
				else
					arr[i] = 1;
			}
		}
	}
	
	public static void cheese(){ //small case
		String ret = "";
		for(int i = 0; i < 10; i++){
			System.out.println(i+1);
			ret += in.nextInt();
		}
		System.out.println(ret);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int b = in.nextInt();
			if(b == 10)
				cheese();
			else{
				int[] bits = new int[b]; //most current
				int[] bit1 = new int[b]; //original
				read(bits,0,5);
				read(bits,15,20);
				for(int j = 0; j < 5; j++){
					bit1[j] = bits[j];
					bit1[j+15] = bits[j+15];
				}
				//changes
				//read 1,2,3,4,5
				read(bits,0,5);
					//compare to old 1,2,3,4,5 and 16,17,18,19,20
					//adjust accordingly
				adjust(compare(bits,bit1),bits);
				//read 6,7,8,9,10
				read(bits,5,10);
				//changes
				//read 1,2,3,4,5
					//compare to old 1,2,3,4,5 and 16,17,18,19,20
					//adjust accordingly
				read(bits,0,5);
				adjust(compare(bits,bit1),bits);
				//read 11,12,13,14,15
				read(bits,10,15);
				//print
				String ret = "";
				for(int bit : bits){
					ret += bit;
				}
				System.out.printf("Case#%d: %s\n",i+1,ret);
				in.nextLine();
				if(in.nextLine().equals("N"))
					break;
			}
		}
	}
}
