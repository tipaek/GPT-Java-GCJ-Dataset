import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;


 class Vestigium {
	public static void main(String[] args) {
		int temp,t,n,i,j;
		long startTime=System.currentTimeMillis();
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	//	System.out.println("Enter number of test cases");
		temp=sc.nextInt();
		Boolean flag=(temp>=1&&temp<=100);
		t=(flag.booleanValue())?temp:0;

		int k=1;
		while(k<=t){
		//	System.out.println("Enter Size of Matrix");
			n=sc.nextInt();
			if(n>=2&&n<=100){
				int arr[][]=new int[n][n];
			//	System.out.println("Enter"+n*n+" elements");
				for(i=0;i<n;i++){
					for(j=0;j<n;j++){
						temp=sc.nextInt();
						Boolean flag1=(temp>=1&&temp<=n);
						arr[i][j]=(flag1.booleanValue())?temp:0;
						if(arr[i][j]==0){
						//	System.out.println("invalid");
							temp=sc.nextInt();
						}
					}
				}


				for(i=0;i<n;i++){
					for(j=0;j<n;j++){
						System.out.print(arr[i][j]);
					}
					System.out.println();
				}
				isLatinSquare(arr,n,k);
			}
			else{break;}
			k++;
		}

sc.close();
long endTime=System.currentTimeMillis();
long elaspedTime=endTime-startTime;

	} 
	

	public static void isLatinSquare(int a[][],int len,int t){
		int i,j,comp,row=0,col=0,sum=0,rcount=0,ccount=0;
		

		Set<Integer> seen = new HashSet<>();

        for(int[] rowi : a) {
            // empty the set, to only check for duplicates within a single row
            seen.clear();
               row=0;
            for(int x : rowi) {
                if(seen.contains(x)) { row+=1; }
                seen.add(x);
            }
            if(row>0){rcount+=1;}
        }

    
		
      
      seen.clear();
      int temp[][]=new int[len][len];
      for (i = 0; i < a.length; i++)
          for (j = 0; j < a[0].length; j++){
        	 
        	   temp[j][i] = a[i][j];
        	   if(i==j){
         		  sum+=a[i][j];
         	  }
          }
              
      
		

      for(int[] coli : temp) {
          // empty the set, to only check for duplicates within a single row
          seen.clear();
             col=0;
          for(int x : coli) {
              if(seen.contains(x)) { col+=1; }
              seen.add(x);
          }
          if(col>0){ccount+=1;}
      }

   
		
		
		
		
     
	System.out.println("case #"+t+" : "+sum+ " "+rcount+" "+ccount);

	}
}