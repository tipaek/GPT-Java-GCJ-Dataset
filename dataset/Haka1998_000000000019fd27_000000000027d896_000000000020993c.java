import java.util.ArrayList;
import java.util.Collections; 
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ASUS
 */
public class solution {
    
        

    public static void run(){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for( int i=0 ; i < Case ; i++ ){       
            int LenthMT=sc.nextInt();
            int[][] newB=new int[LenthMT][LenthMT];
            int c=0,k=0,r=0;
           
            for(int n = 0;n<LenthMT;n++){
                ArrayList<Integer> listR = new ArrayList<>();
                for(int j =0;j<LenthMT;j++){
                    newB[n][j] = sc.nextInt();
                    listR.add(newB[n][j]);
                }
                Set<Integer> set = new HashSet<Integer>(listR);
                if(set.size() < listR.size()){
                    r +=1;
                }
                k += newB[n][n];
                
            }
            for(int n = 0;n<LenthMT;n++){
                ArrayList<Integer> listC = new ArrayList<>();
                for(int j =0;j<LenthMT;j++){
                    listC.add(newB[j][n]);
                }
                Set<Integer> set = new HashSet<Integer>(listC);
                if(set.size() < listC.size()){
                    c +=1;
                }
      
                
            }
            System.out.println("Case #"+i+": "+k+" "+r+" "+c);
            
            
        }
        
        
        
        
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           run();
    }
    
}