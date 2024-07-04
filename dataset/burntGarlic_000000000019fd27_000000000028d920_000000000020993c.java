import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class Vestigium {
    
    	public static void isLatinSquare(int a[][],int len,int t){
		int i,j,comp,row=0,col=0,sum=0,rcount=0,ccount=0;
		Set<Integer> seen = new HashSet<>();
for(int[] rowi : a) {
            // empty the set, to only check for duplicates within a single row
            seen.clear();
               row=0;
            for(int x : rowi) {
                if(seen.contains(x)) { row+=1; break; }
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
              if(seen.contains(x)) { col+=1; break;}
              seen.add(x);
          }
          if(col>0){ccount+=1;}
      }
System.out.println("case #"+t+" : "+sum+ " "+rcount+" "+ccount);

	}
	public static void main(String[] args) {
		int temp,t,n,i,j,k;
		long startTime=System.currentTimeMillis();
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//System.out.println("Enter number of test cases");
		t=sc.nextInt();
		for(k=1;k<=t;++k){
			 n=sc.nextInt();
			int a[][]=new int[n][n];
			for(i=0;i<n;i++){
				for(j=0;j<n;j++){
					temp=sc.nextInt();
					while(temp<1||temp>n){
						System.out.println("invalid");
						temp=sc.nextInt();
					}
					a[i][j]=temp;
				}
			}
			isLatinSquare(a, n, k);
		}
		sc.close();
long endTime=System.currentTimeMillis();
long elaspedTime=endTime-startTime;
System.out.println(elaspedTime/1000);
	} 

}