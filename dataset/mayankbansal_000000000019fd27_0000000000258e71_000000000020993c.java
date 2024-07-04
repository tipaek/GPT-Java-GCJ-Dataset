
import java.util.HashSet;
import java.util.Scanner;

 class compute_trace {

	public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int t=scn.nextInt();
      while(t>0) {
    	  int n=scn.nextInt();
    	  int[][] arr=new int[n][n];
    	  for(int i=0;i<n;i++) {
    		  for(int j=0;j<n;j++) {
    			  arr[i][j]=scn.nextInt();
    		  }
    		  
    	  }
    	  String a=compute(arr);
    	  System.out.println("Case #"+t+":"+a);
    	  t--;
      }
	}
	public static String compute(int[][] arr) {
		int sum=0;
		int row=0;
		int col=0;
		String ans="";
		HashSet<Integer> setr=new HashSet<>();
		HashSet<Integer> setc=new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i==j) {
					sum+=arr[i][j];
				}
				if(setr.contains(arr[i][j])) {
					row++;
				}
				setr.add(arr[i][j]);
				
				if(setc.contains(arr[j][i])) {
					col++;
				}
				setc.add(arr[j][i]);
			}
			setr.clear();
			setc.clear();
			}
		

	ans=sum+" "+row+" "+col;
		return ans;
	}

}
