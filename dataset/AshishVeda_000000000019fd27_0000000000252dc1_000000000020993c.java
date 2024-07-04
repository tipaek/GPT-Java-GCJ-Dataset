package codejam;
import java.util.*;
import java.io.*;
public class Test {
	public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        while(n>0){
        	
        	int size=in.nextInt();
            int r=0,c=0,trace=0;
            int[][] mat=new int[size][size];
            //System.out.println(n);
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    mat[i][j]=in.nextInt();
                    if(i==j){
                        trace+=mat[i][j];
                        //System.out.println(n);
                    }
                    
                }
                
            }
            for(int i=0;i<mat.length;i++){
                //int temp=mat[i][0];
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<mat[0].length;j++){
                    set.add(mat[i][j]);
                    
                }
                if(set.size()!=mat[0].length){
                    r++;
                }
            }
            for(int j=0;j<mat[0].length;j++){
                HashSet<Integer> set=new HashSet<>();
                for(int i=0;i<mat.length;i++){
                    set.add(mat[i][j]);
                }
                if(set.size()!=mat.length){
                    c++;
                }
            }
            System.out.println(trace+" "+r+" "+c);
            n--;
        }
       // System.out.println(n);
    }
}
