import java.io.*;
import java.util.*;
class a{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int i=0;
        while(i<n){
             int size=in.nextInt();
            int[][]mat= new int[size][size];
            int col=0;
            for(int j=0; j<size; j++){
                HashSet<Integer>a=new HashSet<Integer>();
                for(int k=0; k<size; k++){
                    mat[j][k]=in.nextInt();
                    if(!a.add(mat[j][k])){col++;}
                }
            }
            int row=0;
            for(int j=0; j<size; j++){
                HashSet<Integer>a=new HashSet<Integer>();
                for(int k=0; k<size; k++){
                    if(!a.add(mat[k][j])){row++;}
                }
            }
            int tr=0;
            for(int j=0; j<size; j++){
                tr+=mat[j][j];
            }
            
            System.out.println("Case"+"#"+i+":"+" "+tr+" "+row+" "+col);
           i++;
        }
    }
}