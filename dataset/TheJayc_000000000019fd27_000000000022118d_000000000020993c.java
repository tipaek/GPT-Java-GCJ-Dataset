import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int numTimes = scan.nextInt(); 
    
        for(int i = 0; i < numTimes; i++) {
            int size = scan.nextInt();
            int array[][] = new int[size][size];
            int sum = 0;
            int r= 0;
            int c = 0;
            for(int ii = 0; ii < size; ii++){
                for(int iii = 0; iii < size; iii++) {
                    array[ii][iii] = scan.nextInt();
                }
            }
            
            for(int ii = 0; ii < size; ii++){
                sum += array[ii][ii];
            }
            
            for(int row=0;row<size;row++){
                boolean yes = false;
                
                for (int bb = 0; bb < size; bb++){ 
                    for (int j = bb + 1; j < size; j++){ 
                        if (array[row][bb] == array[row][j])  
                            yes=true;
                     } 
                 } 
                
                if(yes==true){
                    r+=1;
                }
            }
            
            
            for(int col=0;col<size;col++){
                boolean yes = false;
                
                for (int cc = 0; cc < size; cc++){ 
                    for (int j = cc + 1; j < size; j++){ 
                        if (array[cc][col] == array[j][col])  
                            yes=true;
                     } 
                 } 
                
                if(yes==true){
                    c+=1;
                }
            }
            
            System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
        }
    }
}