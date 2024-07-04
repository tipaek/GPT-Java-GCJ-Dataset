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
            for(int j=0; j<size; j++){
                HashSet<Integer>a=new HashSet<Integer>();
                for(int k=0; k<size; k++){
                    mat[j][k]=in.nextInt();
                }
            }
            int col=0;
            for(int x=0; x<size; x++){
                HashSet<Integer>a=new HashSet<Integer>();
                for(int y=0; y<size; y++){
                    if(!a.add(mat[y][x])){col++; break;}
                }
            }
 
            int row=0;
            for(int l=0; l<size; l++){
                HashSet<Integer>aa=new HashSet<Integer>();
                for(int m=0; m<size; m++){
                    if(!aa.add(mat[m][l])){row++; break;}
                }
            }
            int tr=0;
            for(int o=0; o<size; o++){
                tr+=mat[o][o];
            }
            
            System.out.println("Case #" + i + ": "+tr+" "+row+" "+col);
           i++;
        }
    }
}