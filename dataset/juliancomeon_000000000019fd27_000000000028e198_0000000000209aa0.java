import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int numberofcase=input.nextInt();
        
        for (int i=1;i<=numberofcase;i++){
            int size=input.nextInt();
            int[] matrix=new int[size*size];
            int val=input.nextInt();
            
            if (!dfs(matrix,0,val,size)){
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            }
            else{
                System.out.println("Case #"+i+": "+"POSSIBLE");
                for (int l=0;l<size;l++){
                    StringBuilder sb=new StringBuilder();
                    for (int m=0;m<size;m++){
                        sb.append(matrix[l*size+m]).append(" ");
                    }
                    System.out.println(sb.delete(sb.length()-1,sb.length()).toString());
                }
            }
            
        }
    }
    
    public static boolean dfs(int[] matrix,int index,int val,int size){
        if (index==matrix.length){
            return val==0;
        }
        if (val<=0){
            return false;
        }
        for (int i=1;i<=size;i++){
            if (!contains(matrix,index/size,index%size,i,size)){
                matrix[index]=i;
                if (index/size==index%size){
                    if (dfs(matrix,index+1,val-i,size)){
                        return true;
                    }
                }
                else {
                    if (dfs(matrix,index+1,val,size)){
                        return true;
                    }
                }
                matrix[index]=0;
            }
        }
        return false;
    }
    
    public static boolean contains(int[] matrix,int row,int col,int val,int size){
        for (int i=row*size;i<=row*size+col;i++){
            if (matrix[i]==val){
                return true;
            }
        }
        for (int i=col;i<=row*size+col;i+=size){
            if (matrix[i]==val){
                return true;
            }
        }
        return false;
    }
}
