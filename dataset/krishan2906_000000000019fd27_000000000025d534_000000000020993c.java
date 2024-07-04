import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        for(int te=1;te<=t;te++){
            int n=sc.nextInt();
            int tr=0;
            int[][] M=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    M[i][j]=sc.nextInt();
                    if(i==j){
                        tr+=M[i][j];
                    }
                }
            }
            //for row
            int cntr=0;
            for(int i=0;i<n;i++){
                boolean[] mrk=new boolean[n];
                for(int j=0;j<n;j++){
                    mrk[M[i][j]-1]=true;
                }
                for(int j=0;j<n;j++){
                    if(!mrk[j]){
                        cntr++;
                        break;
                    }
                }
            }

            //for col
            int cntc=0;
            for(int i=0;i<n;i++){
                boolean[] mrk=new boolean[n];
                for(int j=0;j<n;j++){
                    mrk[M[j][i]-1]=true;
                }
                for(int j=0;j<n;j++){
                    if(!mrk[j]){
                        cntc++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+te+": "+tr+" "+cntr+" "+cntc);
        }
    }


    public static boolean prime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }


    static int gcd(int a, int b) 
	{ 
	if (b == 0) 
		return a; 
	return gcd(b, a % b); 
	} 
}