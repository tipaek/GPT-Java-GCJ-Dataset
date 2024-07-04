
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    int b = in.nextInt();
    for (int i = 1; i <= t; i++) {
      solve(in, b);
      String ans = in.next();
      if(ans.equals("N")) break;
      
    }
  }
  public static void solve(Scanner in, int size){
	  int[] arr = new int[size + 1];
	  int[] res = start(in, arr, 1, new int[]{-1,-1}, 5);
	  //System.out.println(res[0] + " " + res[1]);
	  if(size == 10){
		  print(arr);
		  return;
	  }
	  int count = 6;
	  while(res[0] == -1 || res[1] == -1){
		 System.out.println(1);
		 int v1 = in.nextInt();
		 System.out.println(1);
		 v1 = in.nextInt();
		 if(v1 == arr[1]){
			 
		 }else if(v1 != arr[1]){
			 shift(arr, 1);
		 }
		 res = start(in, arr, count, res, 4);
		 count += 4;
		 if(count > size/2){
			 print(arr);
			 return;
		 }
	  }
	  while(count <= size/2){
		  System.out.println(res[0]);
		 int v1 = in.nextInt();
		 System.out.println(res[1]);
		 int v2 = in.nextInt();
		 //System.out.println(v1 + " " + v2);
		 if(v1 == arr[res[0]] && v2 == arr[res[1]]){
			 //System.out.println("NO CHANGE"); 
		 }else if(v1 != arr[res[0]] && v2 != arr[res[1]]){
			 shift(arr, 1);
			 //System.out.println("Complement"); 
		 }else if(v1 == arr[res[0]]){
			 shift(arr, 2);
			 //System.out.println("Reverse"); 
		 }else{
			 shift(arr, 3);
			 //System.out.println("Both"); 
		 }
		 addMore(in, arr, count, 3);
		 count += 3;
		 
	  }
	  print(arr);
	  return;
	  
  }
  public static void print(int[] arr){
	  StringBuilder ret = new StringBuilder();
	  for(int i = 1; i < arr.length; i++){
		  ret.append(arr[i]);
	  }
	  //System.out.println();
	  System.out.println(ret.toString());
  }
  public static void shift(int[] arr, int change){
	  if(change == 1){
		  for(int i = 1; i < arr.length; i++){
			  if(arr[i] == 0) arr[i] = 1;
			  else arr[i] = 0;
		  }
	  }
	  if(change == 2){
		  for(int i = 1; i < (arr.length + 1) / 2; i++){
			  int temp = arr[i];
			  arr[i] = arr[arr.length - i];
			  arr[arr.length - i] = temp;
		  }
	  }
	  if(change == 3){
		  shift(arr, 1);
		  shift(arr, 2);
	  }
	  //System.out.println(Arrays.toString(arr));
  }
  public static int[] start(Scanner in, int[] arr, int count, int[] ret, int length){
	  for(int i = 0; i < length; i++){
		  System.out.println(count + i);
		  arr[count + i] = in.nextInt();
		  
		  System.out.println(arr.length - (count + i));
		  arr[arr.length - (count + i)] = in.nextInt();
		  
		  if(ret[0] == -1 && arr[count + i] == arr[arr.length - (count + i)]){
			  ret[0] = count + i;
		  }
		  if(ret[1] == -1 && arr[count + i] != arr[arr.length - (count + i)]){
			  ret[1] = count + i;
		  }
	  }
	  
	  return ret;
  }
  public static void addMore(Scanner in, int[] arr, int count, int length){
	  for(int i = 0; i < length; i++){
		  System.out.println(count + i);
		  arr[count + i] = in.nextInt();
		  
		  System.out.println(arr.length - (count + i));
		  arr[arr.length - (count + i + 1)] = in.nextInt();
	  }
  }
}