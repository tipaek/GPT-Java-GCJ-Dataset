import java.util.*;
import java.io.*;
class Solution{
	public static void main(String[] args){
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=in.nextInt();
        int xyz=1;
        while(n>0){
        	
        	int size=in.nextInt();
            int r=0,c=0,trace=0;
            int[][] mat=new int[size][size];
            //System.out.println(n);
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                	
                    mat[i][j]=in.nextInt();
                    //System.out.println(i+"-"+j);
                    if(i==j){
                        trace+=mat[i][j];
                        //System.out.println(n);
                    }
                    //System.out.println(i+"-"+j);
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
            System.out.println("Case #"+xyz+": "+trace+" "+r+" "+c);
            xyz++;
            n--;
        }
       // System.out.println(n);
        in.close();
    }
}