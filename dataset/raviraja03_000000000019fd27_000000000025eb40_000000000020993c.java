import java.util.*;
class Solution {
static Scanner scan = new Scanner(System.in);
static HashSet set = new HashSet();
static HashSet set1 = new HashSet();
 static public void diagnol(int arr[][]){
	int sum=0;
	 for(int i=0;i<arr.length;i++){
		 for(int j=i;j<=i;j++){
		
			 sum+=arr[i][j];
		
		 }
		 
		 set.clear();
	 }
	 System.out.print(sum+" ");
	 
 }
	public static void main(String[] args) {
	  Solution  sum =new Solution();
	  int p=scan.nextInt();
	  for(int k=1;k<=p;k++){
	 int a=scan.nextInt();
	 int arr[][]=new int[a][a];
	 int count=0,s=0,s1=0,count1=0;
	 for(int i=0;i<arr.length;i++){
		 
		 for(int j=0;j<(arr[i].length);j++){
			 
			 arr[i][j]=scan.nextInt();
			
			 if(set.contains(arr[i][j])){
				 
				 s=1;
			 }else{
				 set.add(arr[i][j]);
			 }
		 }
		 count+=s;
		 set.clear();
	 }System.out.print("Case #"+k+": ");
	 sum.diagnol(arr);
 for(int i=0;i<arr.length;i++){
		 s1=0;
		loop1: for(int j=0;j<(arr[i].length);j++){
			
			  if(set1.contains(arr[j][i])){
				  s1=1;
				  break loop1;
			  }else{
				  set1.add(arr[j][i]);
			  }
		 }
		 count1+=s1;
		 set1.clear();
	 }
	 System.out.print(count +" "+count1);
	 System.out.println();
	  }
	}
}