import java.util.Scanner;
public class competion{
public static void main(String[]args) {
	
	

	Scanner input=new Scanner(System.in);
	    int rows=0;
	   int columns=0;
	    int sum=0;
	 int size;
	int  testcases=input.nextInt();
	int output [][]=new int [testcases][3];
	 for(int i=0;i<testcases;i++){
	        sum=0;  rows=0;   columns=0;
	    size=input.nextInt();
	    int x[][]=new int [size][size];
	    for(int t=0;t<size;t++){
	        for(int j=0;j<size;j++){
	        x[t][j]=input.nextInt();
	    }
	    }
	    int k=0;   int h=0;
	    for(int p=0;p<size;p++){
	        sum+=x[k++][h++];
	    }
	 for(int u=0;u<size;u++){
	Lbl:    for(int g=0;g<size-1;g++){
	        for(int q=g+1;q<size;q++){
	            if(x[g][u]==x[q][u]){
	                   columns++;
	                      break Lbl;
	            }

	        }
	    }
	 }

	          for(int u=0;u<size;u++){
			Lbl:    for(int g=0;g<size-1;g++){
			        for(int q=g+1;q<size;q++){
			            if(x[u][g]==x[u][q]){
			                   rows++;
			                      break Lbl;
			            }

			        }
			    }
			 }
	    output[i][0]=sum;
	    output[i][1]=rows;
	    output[i][2]=columns;
	 }

	for(int i=0;i<testcases;i++) {
		for(int j=0;j<3;j++) {
			System.out.println(output[i][j]);
		}
	}
	
}
}