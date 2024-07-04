import java.io.*;
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
            for(int l=0; l<size; l++){
                HashSet<Integer>aa=new HashSet<Integer>();
                for(int m=0; m<size; m++){
                    if(!aa.add(mat[m][l])){row++;}
                }
            }
            int tr=0;
            for(int o=0; o<size; o++){
                tr+=mat[o][o];
            }
            
            System.out.println("Case"+"#"+i+":"+" "+tr+" "+row+" "+col);
           i++;
        }
    }
}