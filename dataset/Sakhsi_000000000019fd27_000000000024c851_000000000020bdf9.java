import java.lang.*;
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]){

		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int test=0;
		test=scan.nextInt();

		if(test>=1 && test<=100){
			int x=0;
			for(x=1;x<=test;x++){

				int n;
				n=scan.nextInt();
				if(n>=2 && n<=1000){

					int sTime[]= new int[n];
					int eTime[]= new int[n];

					int i;

					//scanning and storing the start and end time of all the tasks
					for (i=0;i<n;i++){
						int temp;
						temp=scan.nextInt();
						if(temp>=0 && temp<=1440){
							sTime[i]=temp;
						}
						temp=scan.nextInt();
						if(temp>=0 && temp<=1440){
							if(temp>sTime[i]){
								eTime[i]=temp;
							}
						}
					}

					//sorting the tasks according to time in ascending order
					//using bubble sort
					i=0;
					int m=0;
					for (i=0;i<n-1;i++){
            			for (m=0;m<n-i-1;m++){

                			if (sTime[m]>sTime[m+1]){
                    			// swaping start time
                    			int temp1=sTime[m]; 
                    			sTime[m]=sTime[m+1]; 
                    			sTime[m+1]=temp1; 

                    			//swaping end time according tho start time swaps
                    			int temp2=eTime[m]; 
                    			eTime[m]=eTime[m+1]; 
                    			eTime[m+1]=temp2;
                			}
                		}
					}

					//variables to store the state of cameron and Jamie
					//initially both will be zero

					int c=0, j=0;

					// variable to store the final string
					String str="";
					//if the tast is impossible value will be 1 else 0
					int imp=0;

					int k=0;
					while(k<n){
						int t=sTime[k];
						//if bote are free for the task
						if(t>=c && t>=j){

							int y=eTime[k]-sTime[k];
							int z1=c+y, z2=j+y;

							if(z1<1440){
								c=eTime[k];
								k++;
								str=str.concat("C");
							}
							else if(z2<1440){
								j=eTime[k];
								str=str.concat("J");
								k++;
							}
							else{
								imp=1;
								break;
							}

						}
						//only Cameron is free
						else if(t>=c){

							int y=eTime[k]-sTime[k];
							int z1=c+y;

							if(z1<1440){
								c=eTime[k];
								str=str.concat("C");
								k++;
							}
							else{
								imp=1;
								break;
							}
							
						}
						//only Janie is free
						else if(t>=j){

							int y=eTime[k]-sTime[k];
							int z2=j+y;

							if(z2<1440){
								j=eTime[k];
								str=str.concat("J");
								k++;
							}
							else{
								imp=1;
								break;
							}
							
						}
						else if(t<c && t<j){
							imp=1;
							break;
						}

					}

					if(imp==1){
						System.out.println("IMPOSSIBLE");
					}
					else{
						System.out.println(str);
					}

				}
			}
		}
	}
}