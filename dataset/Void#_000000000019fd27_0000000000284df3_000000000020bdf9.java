import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;
class matt{
    public void opp(int[][] A, int Nsize,int num){
	  String strr =new String("");
          num=num+1;
	  int flag=0;
	  int count=0;
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
	  	if(JI[i] ==1){count=count+1;}
	  }
	  if(count ==1){flag=0;}
	  else{
		  for(int ii=0;ii<JI.length;ii++){
			for(int jj=ii+1;jj<JI.length;jj++){
				if(JI[ii] ==1 && JI[jj] == 1 ){
					if(A[ii][1]-A[jj][0]<=0 && A[ii][0]-A[jj][1]<=0){int x=0;}
					else if	(A[ii][1]-A[jj][0]>=0 && A[ii][0]-A[jj][1]>=0){int x=0;}
					else{
						flag=1;
									
					}
				}

			}
		  }
	  }
	 
	  if (flag==1){
		System.out.println("Case #"+num+": IMPOSSIBLE");
	  }
	  else{
		for(int i=0;i<Nsize;i++){
			if (JI[i] != 0){strr=strr+"J";}
			if (CI[i] != 0){strr=strr+"C";}
	  	}
		System.out.println("Case #"+num+": "+strr);
	  }
	  
    }



}
public class Solution {
     public static void main(String args[]) throws Exception {
      Scanner sc =new Scanner(System.in);
      int test_cases = Integer.parseInt(sc.nextLine());
      for(int i=0;i<test_cases;i++){
          int Nsize = Integer.parseInt(sc.nextLine());
	  int [][] A = new int[Nsize][2];
	  for(int j=0;j<Nsize;j++){
		String[] line = sc.nextLine().trim().split(" ");
            	for (int k=0; k<line.length; k++) {
               	     A[j][k] = Integer.parseInt(line[k]);
                }	  

          }
          matt mat=new matt();
          mat.opp(A,Nsize,i);
      }
      
   }
}
