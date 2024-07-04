import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	    int t=Integer.parseInt(br.readLine());
	    int x=1;
	    while(t-->0){
	        int n=Integer.parseInt(br.readLine());
	        int na=n;
	        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	        int a[][]=new int[n][n];
	        int k=0;
	        while(n-->0){
	            String s[]=br.readLine().split(" ");
	            for(int i=0;i<na;i++)
	            a[k][i]=Integer.parseInt(s[i]);
	            k++;
	        }
	        int rows=0,col=0,sum=0;
	        for(int i=0;i<na;i++)
	        sum+=a[i][i];
	        for(int i=0;i<na;i++){
	            ArrayList<Integer> ar=new ArrayList<>();
	            for(int j=0;j<na;j++){
	                if(!ar.contains(a[i][j]))
	                ar.add(a[i][j]);
	            }
	            if(ar.size()<na)
	            rows++;
	        }
	    for(int i=0;i<na;i++){
	            ArrayList<Integer> ar=new ArrayList<>();
	            for(int j=0;j<na;j++){
	                if(!ar.contains(a[j][i]))
	                ar.add(a[j][i]);
	            }
	            if(ar.size()<na)
	            col++;
	        }
		System.out.println("Case"+" "+"#"+x+":"+" "+sum+" "+rows+" "+col);
        x++;
	    }
	}
}
