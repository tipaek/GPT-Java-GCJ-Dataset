/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;


// 3
// 360 480
// 420 540
// 600 660
public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        int T= sc.nextInt();              
        int[] start;
        int[] end;
        int n;
        char[] ans;
        String str_ans = "";
        
        for(int t = 1 ; t<= T; t++){
            
           // System.out.print("Case #"+t+": ");
            n = sc.nextInt();
            ans = new char[n];
            start = new int[n];
            end = new int[n];
            for(int i = 0; i< n ;i++){
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            
        //sorting the arrays:
         int temp1;
         int temp2;
           for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
             if (start[j] < start [j - 1]) {
              temp1 = start[j];
              start[j] = start[j - 1];
              start[j - 1] = temp1;
              temp2 = end[j];
              end[j] = end[j - 1];
              end[j - 1] = temp2;
              
             }
            }
           }
        int s = 0;
        for(int i = 0; i<n; i++){
            if((start[i] != -1) && (start[i] >= s)){
                ans[i] ='C';
                s = end[i];
                start[i] = -1;
            }
        }
        s=0;
        for(int i = 0; i<n; i++){
            if((start[i] != -1) && (start[i] >= s)){
                ans[i] ='J';
                s = end[i];
                start[i] = -1;
            }
        }
        for(int i = 0; i<n; i++){
            if(start[i] != -1){
                str_ans = "IMPOSSIBLE";
            }
            else{
                str_ans = new String(ans);}
        }
        System.out.println("Case #"+t+": "+str_ans);
           
        }
	}
}


