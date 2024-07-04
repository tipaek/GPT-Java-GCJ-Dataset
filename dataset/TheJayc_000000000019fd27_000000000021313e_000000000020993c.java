import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int numTimes = Integer.parseInt(scan.next()); 
        
        for(int i = 0; i < numTimes; i++) {
            int size = Integer.parseInt(scan.next());
            int array[][] = new int[size][size];
            int sum = 0;
            int r = 0;
            int c = 0;
            
            for(int ii = 0; ii < size; ii++){
                for(int iii = 0; iii < size; iii++) {
                    array[ii][iii] = Integer.parseInt(scan.next());
                }
            }
            
            for(int ii = 0; ii < size; ii++){
                sum += array[ii][ii];
            }
            
            for(int ii = 0; ii < size; ii++) {
                for(int iii = 1; iii < size; iii++) {
                    if(array[ii][iii] == array[ii][iii-1])
                    c+=1;
                }
            }
                
            for(int ii = 0; ii < size; ii++){
                for(int iii = 1; iii < size; iii++) {
                    if(array[iii][ii] == array[iii-1][ii])
                    r+=1;
                }
            }
            
            System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
        }
    }
}