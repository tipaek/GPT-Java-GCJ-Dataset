import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int tc=1;
        while(t>0){
            t--;
            int n=sc.nextInt();
            int[][] mat=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {
                	mat[i][j]=sc.nextInt();//Integer.parseInt(st[j]);
                }
            }
            //print(mat,n);
            int trace=0,c=0,r=0;
            boolean[] row=new boolean[n];
            boolean[] col=new boolean[n];
            for(int i=0;i<n;i++) {
            	for(int j=0;j<n;j++) {
            		int num=Math.abs(mat[i][j]);
            		if(i==j) {
            			trace+=num;
            		}
            		int ind=num-1;
            		if(!row[i]) {
            			if(mat[i][ind]<0) {
            				row[i]=true;
            				r++;
            			}else {
            				mat[i][ind]=-1*mat[i][ind];
            			}
            		}
            	}
            }
            
            modify(mat,n);
            for(int i=0;i<n;i++) {
            	for(int j=0;j<n;j++) {
            		int num=Math.abs(mat[i][j]);
            		int ind=num-1;
            		if(!col[j]) {
            			if(mat[ind][j]<0) {
            				col[j]=true;
            				c++;
            			}else {
            				mat[ind][j]= -1* mat[ind][j];
            			}
            		}
            	}
            }
            System.out.println("#"+tc+" "+trace+" "+r+" "+c);
            tc++;
            
        }
    }
    
    static void modify(int[][] mat, int n) {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			if(mat[i][j]<0) {
    				mat[i][j]=mat[i][j]*-1;
    			}
    		}
    	}
    }
    
    static void print(int[][] mat, int n) {
    	for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		System.out.print(mat[i][j]+" ");
        	}
        	System.out.println();
        }
    }
}