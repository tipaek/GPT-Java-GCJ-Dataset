import java.util.Scanner;
// import java.io.*;

class Solution{
   	public static void main (String[] ar) throws Exception{
	  	//FileInputStream fi =new FileInputStream(ar[0]);
      	Scanner sc=new Scanner(System.in);
      	int T=sc.nextInt();
      	sc.nextLine();
		for(int i=1;i<=T;i++){
			System.out.println("Case #"+i+": "+ans(sc));
		}
 	}

	static String ans(Scanner sc){
        int n = sc.nextInt();
        int count = 0;
        int k = 0;
        int r = 0;
        int c = 0;
        int[][] C = new int[n][n+1];
        int[][] R = new int[n][n+1];
        int rN = 0;
        int cN = 0;
        for(int i = 0 ; i < n*n ; i++){
            rN = count/n;
            cN = count%n;
            int I = sc.nextInt();
            C[cN][I] += 1;
            R[rN][I] += 1;
            if( C[cN][I] > 1 && C[cN][0] == 0 ){
                c++;
                C[cN][0] = 1;
            }
            if( R[rN][I] > 1 && R[rN][0] == 0 ){
                r++;
                R[rN][0] = 1;
            }
            if( cN == rN ){
                k+=I;
            }

            count++;
        }
        return k+" "+r+" "+c;
	}
}