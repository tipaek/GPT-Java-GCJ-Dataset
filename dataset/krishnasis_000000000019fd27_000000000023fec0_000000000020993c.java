import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class Solution{
    static int num;
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        
        int tc=sc.nextInt();
        
        for(int x=0;x<tc;x++){
            int  dim=sc.nextInt();
            int[][] arr = new int[dim][dim];
            
            setArrData(sc, arr, dim);
            generateLatin(arr,dim);
        }
    }
    
    public static void setArrData(Scanner scan, int[][] arr, int dim){

          for (int i = 0; i < dim; i++)
          {
              for (int j = 0; j < dim; j++)
              {
                  arr[i][j] = scan.nextInt();
              }
          }
    }
    
    public static void generateLatin(int[][]arr,int dim){
        int trace=0;
        num++;
        int rc=0;
        int cc=0;
        for(int i = 0; i <dim;i++){
            int [] rows = arr[i];
            if(!checkRows(rows,dim)){
                rc++;
            }

            for(int j=0;j<dim;j++){
                if(i==j){
                    trace+=arr[i][j];
                }
            }
        }
        cc=getColsCount(arr,dim);
        System.out.println("Case #"+num+": "+trace+" "+rc+" "+cc);
    }
    public static boolean checkRows(int[]rows,int dim){
        Set<Integer> rset=new HashSet<>();
        for(int i=0;i<dim;i++){
            rset.add(rows[i]);
        }
        if(rset.size()==dim){
            return true;
        }
        return false;
    }
    public static int getColsCount(int [][]arr,int dim){
        int i =0;
        int count=0;
        for (int k : arr[0]){
            Set<Integer> cset=new HashSet<>();
            for (int[] row : arr) {
                cset.add(row[i]);
            }
            i++;
        if(cset.size()!=dim){
            count++;
        }
        }
        return count;
    }
}