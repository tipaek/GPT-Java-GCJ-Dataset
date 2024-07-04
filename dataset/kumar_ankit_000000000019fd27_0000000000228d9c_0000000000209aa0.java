import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		sc.nextLine();
		for(int t=1;t<=test;t++){
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int dia=0;
		    for(int i=1;i<=n;i++){
		        if(i*n==k){
		            dia=i;
		        }
		    }
		    if(dia==0){
		        System.out.println("Case #"+t+": IMPOSSIBLE");
		    }
		    else{
		        System.out.println("Case #"+t+": POSSIBLE");
		        int a[][]=new int[n][n];
		        for(int i=0;i<n;i++){
		            a[i][i]=dia;
		        }
		        
		        int b[]=new int[n-1];
		        for(int i=1;i<=n-1;i++){
		            b[i-1]=i;
		            if(b[i-1]==dia){
		                b[i-1]=n;
		            }
		        }
		        
		        for(int i=0;i<n;i++){
		            int count=0;
		            for(int j=i+1;j<n;j++){
		                    a[i][j]=b[count];
		                    count++;
		            }
		            for(int j=0;j<i;j++){
		                a[i][j]=b[count];
		                count++;
		            }
		        }
		        
		        
		        for(int i=0;i<n;i++){
		            for(int j=0;j<n;j++){
		                System.out.print(""+a[i][j]+" ");
		            }
		            System.out.println();
		        }
		    }
		    
		}
    }
}