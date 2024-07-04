import java.util.*;
import java.lang.Math; 
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.*;


public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner sc = new Scanner(System.in); //System.in is a standard input stream 
        int T = sc.nextInt();              
        int x;
        int y;
        int s;
        String str;
        for(int i = 1 ; i<= T; i++){
            s =0;
            System.out.print("Case #"+i+": ");
            x = sc.nextInt();
            y = sc.nextInt();
            str = sc.next();
            //System.out.print("x: "+x+"y: "+y);

            int ans = -1;
            while(s < str.length()){
                //System.out.println("* s:"+s+"x: "+x+"y: "+y);

                
                if(s >= Math.abs(x)+Math.abs(y)){
                    ans =  s;
                    s = str.length();
                }
                else{
                    char c = str.charAt(s);
                    //System.out.print("c: "+c);

                    if(c == 'N'){
                        y++;
                    }
                    if(c == 'S'){
                        y--;
                    }
                    if(c == 'E'){
                        x++;
                    }
                    if(c == 'W'){
                        x--;
                    }
                    s++;
                }
            }
            if((ans == -1) &&s >= Math.abs(x)+Math.abs(y)){
                    ans =  s;
                }

            if(ans != -1){
                System.out.println(ans);
            }
            else{
                System.out.println("IMPOSSIBLE");

            }
            
	}
	}
	

}




