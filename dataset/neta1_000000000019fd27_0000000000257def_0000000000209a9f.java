/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        int T= sc.nextInt();              
        String str;
        int[] array;
        int[] o_array;
        int[] c_array;
        int n;
        char [] array2;
        
        Scanner sc2 = new Scanner(System.in);
       
        String [] str_arr = new String[T];
        // for(int t=0; t< T; t++){
        
        //     str_arr[t] = sc2.next();
        //     System.out.print("hello: "+str_arr[t]);
        // }
        for(int t = 1 ; t<= T; t++){
            System.out.print("Case #"+t+": ");
            str = sc.next();
            //System.out.print(str);
            n = str.length();
            array = new int[n];
            o_array = new int[n];
            c_array = new int[n];
            // array[0]= 2;
            // array[1] = 2;
            // array[2] = 1;
            array2 = str.toCharArray();
            for(int i =0 ; i< n; i++){
                array[i] = Integer.parseInt(String.valueOf(array2[i]));
            }
            int flag = 1;
            int up=0;
            int sum;
            while (flag == 1){
                sum = 0;
                for(int i=0; i< n; i++){
                    if(array[i] > 0){
                        if(up ==0){
                            o_array[i]++;
                            up = 1;
                            }
                        if((i+1 == n) || array[i+1] ==0){
                                up = 0;
                                c_array[i]++;
                            }
                        array[i]--;
                        sum = sum+array[i];
                    }
                    else{
                        up = 0;
                        
                    }
                }
                
                up = 0;
                if(sum == 0){
                    flag = 0;
                }
                
            }
            // System.out.println();
            // System.out.print(o_array[0]);
            // System.out.print(o_array[1]);
            // System.out.println(o_array[2]);
            // System.out.print(c_array[0]);
            // System.out.print(c_array[1]);
            // System.out.print(c_array[2]);
            for(int i =0 ; i< n; i++){
                array[i] = Integer.parseInt(String.valueOf(array2[i]));
            }
            String ans ="";
            for(int i=0; i<n; i++){
                for(int o=0; o<o_array[i]; o++){
                    ans = ans +'(';
                }
                ans = ans + array[i];
                for(int c=0; c<c_array[i]; c++){
                    ans = ans +')';
                }
                
            }
            System.out.println(ans);

            up = 0;
            flag = 1;
            
            
            
            
           
        }
	}
}




