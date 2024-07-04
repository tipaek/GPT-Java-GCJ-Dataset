import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cp
{ 

        public static void main(String [] args) 
        { 
            Scanner input=new Scanner(System.in);
            int test=input.nextInt();
            for(int i=0;i<test;i++) {
            	int n=input.nextInt();
            	int[][] matrix=new int[n][n];
            	int rows=0;
            	int columns=0;
            	int trace=0;
            	for(int j=0;j<matrix.length;j++) {
            		int[] temp=new int[n];
            		for(int k=0;k<matrix.length;k++) {
            			int x=input.nextInt();
            			matrix[j][k]=x;
            			if(j==k) {
            				trace+=x;
            			}
            			temp[x-1]+=1;
            		}
            		int rowflag=0;
            		for(int k=0;k<temp.length;k++) {
            			if(temp[k]>1) {
            				rowflag=1;
            				//columns++;
            				break;
            			}
            		}
            		if(rowflag==1) {
            			rows++;
            		}
            	}
            	for(int j=0;j<matrix.length;j++) {
            		int[] temp=new int[n];
            		for(int k=0;k<matrix.length;k++) {
            			temp[matrix[k][j]-1]+=1;
            		}
            		for(int k=0;k<temp.length;k++) {
            			if(temp[k]>1) {
            				columns++;
            				break;
            			}
            		}
            	}
            	System.out.println("Case #"+(i+1)+": "+trace+" "+rows+" "+columns);
            }
        }

}
 