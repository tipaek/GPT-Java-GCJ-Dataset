import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

class Check {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		ArrayList<Integer> al1 = new ArrayList<Integer>(); 
		String ar1[]=new String[t];

		for(int t1=0; t1<t;t1++) {
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j) {
						sum=sum+arr[i][j];
					}
				}
			
			}
			for(int i=0;i<n-1;i++) {
				int count =0;
				for(int j=0;j<n;j++) {
					if(arr[i][j]==arr[i+1][j])
						count++;
				}
			
				al.add(count);
				
				int count1=0;

				for(int j=0;j<n-1;j++) {
					if(arr[i][j]==arr[i][j+1])
						count1++;
				}
				al1.add(count1);
			}
			
			
		
		int c=0;
		for (Iterator<Integer> in = al.iterator(); in.hasNext();) {
		    int i = in.next();
		    if (i > 0) {
		    	c=Collections.max(al)+1;
		    }
		}
		int c1=0;
		for (Iterator<Integer> in = al1.iterator(); in.hasNext();) {
		    int i = in.next();
		    if (i > 0) {
		    	c1=Collections.max(al1)+1;
		    }
		}
		
		
		String m="case #"+(t1+1) + ":" +" "+ sum + " " + c1 + " " + c;
		ar1[t1]=m;
		al.clear();
		al1.clear();

	}
		for(int i=0;i<ar1.length;i++) {
			System.out.println(ar1[i]);
		}
	}

}