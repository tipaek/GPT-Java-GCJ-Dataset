import java.util.*;
import java.lang.*;
import java.io.*;
public class Ideone
{
	public static void main (String[] args) 
	{
	int T,N;
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();
        int k=1;
        while(k<=T){
            int trace=0;
            N=sc.nextInt();
            int[][] ar=new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    ar[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<N;i++)
                trace+=ar[i][i];
            HashSet<Integer> set=new HashSet<>();
            int row=0;
            for(int i=0;i<N;i++)
            {   set.clear();
                for(int j=0;j<N;j++){
                    if(set.contains(ar[i][j])){
                        row++;break;
                    }
                    set.add(ar[i][j]);
                }
            }
            int col=0;
            for(int j=0;j<N;j++)
            {   set.clear();
                for(int i=0;i<N;i++){
                    if(set.contains(ar[i][j])){
                        col++;break;
                    }
                    set.add(ar[i][j]);
                }
            }
 
            System.out.println("Case #"+k+": "+trace+" "+row+" "+col);
			k++;
 
        }
	}
}