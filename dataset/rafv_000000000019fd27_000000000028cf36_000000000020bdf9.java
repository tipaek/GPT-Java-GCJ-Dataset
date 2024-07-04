/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 *
 * @author Roger Flores Vargas
 */
class ppr {
    public static void main(String[] args) throws IOException {
        long t;
        int a, b, n, l, ll;
        String[] ab;
        char[] resp;
        boolean seguir, posible;
        Par[] c = new Par[1001];
        Par[] j = new Par[1001];
        int tamC, tamJ;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wff = new PrintWriter(System.out);
        t = Integer.parseInt(entrada.readLine());

        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(entrada.readLine());
            tamC = 0; tamJ = 0;
            seguir = true;
            posible = true;
            resp = new char[1001];
            for (int k = 0; k < n; k++) {
                ab = entrada.readLine().split(" ");
                a = Integer.parseInt(ab[0]);
                b = Integer.parseInt(ab[1]);
                l = 0; ll = 0;
                seguir = true;
                while(l < tamC && seguir){
                    //wff.println(" c = " + c[l].x + " " + c[l].y);
                    if((a > c[l].x && a < c[l].y) || (b > c[l].x && b < c[l].y)){                        
                        while(ll < tamJ && seguir){
                            if((a > j[ll].x && a < j[ll].y) || (b > j[ll].x && b < j[ll].y)){
                                seguir = false;
                                posible = false;
                            }
                            //wff.println(" j = " + j[ll].x + " " + j[ll].y);
                            
                            ll++;
                        }
                        if(seguir){
                            j[tamJ] = new Par(a,b);
                            tamJ ++;
                            resp[k] = 'J';
                            seguir = false;
                        }
                    }
                    l++;
                }
                if(seguir){
                    c[tamC] = new Par(a,b);
                    tamC ++;
                    resp[k] = 'C';
                }
            }
            wff.print("Case #" + i + ": ");             
            if(posible){
                for(int ii = 0; ii < n; ii++){
                    wff.print(resp[ii]);
                }
            }
            else{
                    wff.print("IMPOSSIBLE");
            }
             wff.println();
        }
        wff.close();   
    } 
}


class Par{
    int x, y;
    Par(int x, int y){
        this.x = x;
        this.y = y;
    }
}