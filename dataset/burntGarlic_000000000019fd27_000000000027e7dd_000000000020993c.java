import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


 class Vestigium {
	public static void main(String[] args) {
		int temp,t,n,i,j;
		long startTime=System.currentTimeMillis();
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//System.out.println("Enter number of test cases");
		temp=sc.nextInt();
		Boolean flag=(temp>=1&&temp<=100);
		t=(flag.booleanValue())?temp:0;

		int k=1;
		while(k<=t){
			//System.out.println("Enter Size of Matrix");
			n=sc.nextInt();
			if(n>=2&&n<=100){
				int arr[][]=new int[n][n];
				//System.out.println("Enter"+n*n+" elements");
				for(i=0;i<n;i++){
					for(j=0;j<n;j++){
						temp=sc.nextInt();
						Boolean flag1=(temp>=1&&temp<=n);
						arr[i][j]=(flag1.booleanValue())?temp:0;
						if(arr[i][j]==0){
							System.out.println("invalid");
							temp=sc.nextInt();
						}
					}
				}


				
				isLatinSquare(arr,n,k);
			}
			else{break;}
			k++;
		}

sc.close();
long endTime=System.currentTimeMillis();
long elaspedTime=endTime-startTime;
System.out.println(elaspedTime/1000);
	} 
	

	public static void isLatinSquare(int a[][],int len,int t){
		int i,j,comp,k,row=0,col=0,sum=0,rcount=0,ccount=0;
		int b[]= new int[2];
		b[0]=a[1][2];
		for(i=0;i<len;i++){
			row=0;col=0;
			for(j=0;j<len;j++){
               	for(k=0;k<len;k++){
					if(j!=k&&a[i][j]==a[i][k]){
						row=row+1;break;}
					if(i!=k&&a[j][i]==a[j][k]){
						col=col+1;break;
					}
                  }
				if(i==j){
					sum+=a[i][j];}
				if(col>0){ccount++;}
			}
	if(row>0){rcount++;}
}
       ccount=ccount>0?ccount-1:0;
		System.out.println("case #"+t+" : "+sum+ " "+rcount+" "+ccount);

	}
}