import java.util.Scanner;
import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int tcCount = in.nextInt();
        //System.out.println("tcCount= "+tcCount);
        
        for(int x=1;x<=tcCount;x++){
            in.nextLine();
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int i=0;i<n;i++){
                in.nextLine();
                matrix[i]=new int[n];
                for(int j=0;j<n;j++){
                    matrix[i][j]=in.nextInt();
                }
            }
            
            //String str = in.next();
            //System.out.println(Arrays.deepToString(matrix));
            solveMatrix(x,n,matrix);
        }
        
    }
    
    
    public static void solveMatrix(int x,int n, int[][] matrix){
        
        //calculate trace
        int trace=0;
        for(int i=0;i<n;i++)
           trace+=matrix[i][i];
        
        //get number of row repeats
        int rowRepeats=0;
        boolean[] tracker=new boolean[n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(tracker,false);
            for(int j=0;j<n;j++){
                if(tracker[matrix[i][j]]){
                    rowRepeats++;
                    break;
                }else{
                    tracker[matrix[i][j]]=true;
                }
            }
        }
        
        //get number of col repeats
        int colRepeats=0;
        //boolean[] tracker=new boolean[n+1];
        for(int j=0;j<n;j++){
            Arrays.fill(tracker,false);
            for(int i=0;i<n;i++){
                if(tracker[matrix[i][j]]){
                    colRepeats++;
                    break;
                }else{
                    tracker[matrix[i][j]]=true;
                }
            }
        }
        
        System.out.println("Case #"+x+": "+trace+" "+rowRepeats+" "+colRepeats);
        
        
        
        
    }
    
    
}