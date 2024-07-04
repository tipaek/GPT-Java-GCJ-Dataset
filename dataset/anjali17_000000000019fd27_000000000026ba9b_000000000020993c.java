import java.util.*;
class CodeJamQues1Vestigium {
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		int t1=0;
		while(t1<t)
		{
			int rows=0;
			int trace=0;
			int cols=0;
			boolean isrow=false;
			int n=scn.nextInt();
			int[][] arr=new int[n][n];
			HashSet<Integer> set=new HashSet<>();
			for(int i=0;i<n;i++) {
				 set=new HashSet<>();
			     for(int j=0;j<n;j++) {
			      	arr[i][j]=scn.nextInt();
			      	if(i==j)
			      		trace+=arr[i][j];
			      	if(set.contains(arr[i][j]))
			      			isrow=true;
			      	else {
			      		set.add(arr[i][j]);
			      	}
			     }
			     if(isrow)
			    	 rows++;
			    	 
			    	 isrow=false;
			}
			for(int i=0;i<n;i++) {
				set=new HashSet<>();
			     for(int j=0;j<n;j++) {
			      	if(set.contains(arr[j][i]))
			      			{
			      		    cols++;
			      			break;
			      			}	 
			      	else {
			      		set.add(arr[j][i]);
			      	}
			     }
			}
			   t1++;  
			System.out.println("Case #"+t1+" "+trace+" "+rows+" "+cols);
			
		}

	}

}
