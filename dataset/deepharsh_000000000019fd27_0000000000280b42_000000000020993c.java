
import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int T=s.nextInt();
	for(int k=1;k<=T;k++){
	    int N=s.nextInt();
	    int[][] num=new int[N][N];
	     for(int i=0;i<N;i++){
	        for(int j=0;j<num[i].length;j++){
	         num[i][j]=s.nextInt();
	        }
	    }
	    Vestigium(num,N,k);
	}
	}
	public static void Vestigium(int[][] num,int row,int a){
	    int r=0;
	    int c=0;
	    int k=0;
	    for(int i=0;i<row;i++){
	        for(int j=0;j<num[i].length;j++){
	          for(int z=0;z<num[i].length;z++){
	              if(num[i][j]==num[i][z]&&j!=z){
	                  r++;
                      j=row;
                      break;
	              }
	          }
	        }
	    }
	     for(int i=0;i<row;i++){
	        for(int j=0;j<num[i].length;j++){
	          for(int z=0;z<num[i].length;z++){
	              if(num[z][i]==num[j][i]&&j!=z){
	                  c++;
                      j=row;
                      break;
	              }
	          }
	        }
	    }
	    for(int i=0,j=0;i<row&&j<row;i++,j++){
	        k=k+num[i][j];
	    }
		    System.out.println("Case #"+a+": "+k+" "+r+" "+c);
	}
}
