import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test=sc.nextInt();
		for(int k=1;k<test+1;k++){
		int n=sc.nextInt();
		int [][] arr=new int[n][n];
		int t=0;
		int r=0;
		int c=0;
		for(int i=0;i<n;i++){
		    for(int j=0;j<n;j++){
		        int a=sc.nextInt();
		        arr[i][j]=a;
		        if(i==j){
		            t+=a;
		        }
		        
		    }
		}
		for(int i=0;i<n;i++){
		    Set<Integer> s=new HashSet<>();
		    for(int j=0;j<n;j++){
		        s.add(arr[i][j]);
		        }
		        if(s.size()!=n){
		            r++;
		        }
		        s.clear();
		        
		    }
		    for(int i=0;i<n;i++){
		    Set<Integer> s=new HashSet<>();
		    for(int j=0;j<n;j++){
		        s.add(arr[j][i]);
		        }
		        if(s.size()!=n){
		            c++;
		        }
		        s.clear();
		        
		    }
		
		
		System.out.println("Case #"+k+": "+t+" "+r+" "+c);
		}
	}
}
