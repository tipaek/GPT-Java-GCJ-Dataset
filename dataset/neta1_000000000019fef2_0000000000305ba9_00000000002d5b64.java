import java.util.*;
import java.lang.Math; 

public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner sc = new Scanner(System.in); //System.in is a standard input stream  
        int T = sc.nextInt();              
        int R;
        int S;
        int r;
        int s;
        int sum;
        int ori_r;
        int ori_s;
        for(int i = 1 ; i<= T; i++){
            
            System.out.print("Case #"+i+": ");
            ori_r = sc.nextInt();
            ori_s = sc.nextInt();
            R = ori_r;
            S = ori_s;
            r = R;
            s= S;
            sum = 0;
            while(S != 1){
            while(R!= 1){
                sum = sum +1;
               R = R-1;
            }
            R = r;
            S= S-1;
            }
            System.out.print(sum);
            
            
            
            
            R = ori_r;
            S = ori_s;
            r = R;
            s= S;
            while(S != 1){
            while(R!= 1){
               System.out.println((s-S+1)*R+" "+(R-1)); 
               R = R-1;
            }
            R = r;
            S= S-1;
            }
            
            

        }
	}
	

}



