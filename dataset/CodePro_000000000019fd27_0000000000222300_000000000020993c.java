
import java.util.Scanner;

public class ma { 

public static void main(String[] args) {
     Scanner in =new Scanner(System.in);
		int numOfCase=in.nextInt();
		String [] arr= new String[numOfCase];
		int k=0;
		for(int i=0; i<numOfCase; i++ ) {
		     Scanner in2 =new Scanner(System.in);
				int n=in.nextInt();
			 int [][] myArray = new int[n][n];
		     Scanner sc =new Scanner(System.in);
		  
		     for(int f =0; f<n; f++) {
		 		for (int j=0; j<n; j++) {
		 			myArray[f][j]=sc.nextInt();
		 		}
		 	}
           int nrows=0;
		  for(int q=0; q<n; q++) {
           for(int e=0; e<n; e++) {
			int x=  myArray[q][e];
			int flag=0;  
			for(int r=e+1; r<n; r++) {
				  if(myArray[q][r]==x) {
					  nrows++;
                      flag=1;
					  break;
				  }
			  }
		  if (flag==1) {break;}
           
           }
           
		  
		  }
		
		
		
		  int ncol=0;
		  for(int q=0; q<n; q++) {
           for(int e=0; e<n; e++) {
			int x=  myArray[e][q];
			int flag=0;  
			for(int r=e+1; r<n; r++) {
				  if(myArray[r][q]==x) {
					  ncol++;
                      flag=1;
					  break;
				  }
			  }
		  if (flag==1) {break;}
           
           }
           
		  
		  }
		
		  
		  
		  int digSum=0;
		  for(int o=0; o<n;  o++) {
			  digSum+=myArray[o][o];
		  }
		
		
		  arr[k]="";
		  arr[k]+="Case "+"#"+(i+1)+": "+ digSum+" " + nrows+" "+ncol;
		
		
		}
		
		System.out.println(arr[0]);
		
	//	Case #3: 8 0 2

		
		
	}
}