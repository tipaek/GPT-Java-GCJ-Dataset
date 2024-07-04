import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;
public class Solution {
     public static void main(String args[]) throws Exception {
      Scanner sc =new Scanner(System.in);
      int test_cases = Integer.parseInt(sc.nextLine());
      int num=0,flag;
      for(int k=0;k<test_cases;k++){
          int Nsize = Integer.parseInt(sc.nextLine());
	  int [][] A = new int[Nsize][2];
	  for(int j=0;j<Nsize;j++){
		String[] line = sc.nextLine().trim().split(" ");
            	for (int kk=0; kk<line.length; kk++) {
               	     A[j][kk] = Integer.parseInt(line[kk]);
                }	  

          }
          String strr =new String("");
          num=k+1;
	  flag=0;
	  int [] CI = new int[Nsize];
	  int [] JI = new int[Nsize];
	  for(int l=0;l<Nsize;l++){
	        CI[l]=1;
	  }
	  int kk=0;
	  for(int i=0;i<Nsize;i++){
		for(int j=i+1;j<Nsize;j++){
                        if(CI[i] ==1 && CI[j] == 1 ){
				if(A[i][1]-A[j][0]<=0 && A[i][0]-A[j][1]<=0){int x=0;}
				else if	(A[i][1]-A[j][0]>=0 && A[i][0]-A[j][1]>=0){int x=0;}
				else{

					JI[j]=1;
					CI[j]=0;
								
				}
			}
		}
	  }
	  for(int i=0;i<Nsize;i++){
		for(int j=i+1;j<Nsize;j++){
			if(JI[i] ==1 && JI[j] == 1 ){
				if(A[i][1]-A[j][0]<=0 && A[i][0]-A[j][1]<=0){int x=0;}
				else if	(A[i][1]-A[j][0]>=0 && A[i][0]-A[j][1]>=0){int x=0;}
				else{
					flag=1;
								
				}
			}
			
			

		}	

	  }
	
	 
	  if (flag==1){
		System.out.println("Case #"+num+": IMPOSSIBLE");
	  }
	  else{
		for(int i=0;i<Nsize;i++){
		    if(Nsize<5){
			if (JI[i] != 0){strr=strr+"J";}
			if (CI[i] != 0){strr=strr+"C";}
		    }
		    else{
			if (JI[i] != 0){strr=strr+"C";}
			if (CI[i] != 0){strr=strr+"J";}
      		    }
	  	}
		System.out.println("Case #"+num+": "+strr);
	}
      }
      
   }
}
