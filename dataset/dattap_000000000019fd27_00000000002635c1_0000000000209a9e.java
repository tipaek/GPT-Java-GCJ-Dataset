import java.util.*;
public class Solution{
     public static void main(String[] args){
           //System.out.println(1);
           Scanner sc = new Scanner(System.in);
           String[] d = sc.nextLine().split(" ");
           int T = Integer.parseInt(d[0]);
           int B = Integer.parseInt(d[1]);
       forloop:    for(int ii=1; ii <= T; ii++){
           int[] a1 = new int[B];
           int[] a2 = new int[B];
           int[] a3 = new int[B];
           int[] a4 = new int[B];
           for(int i=1; i <= 10; i++){
           System.out.println(i);
           int b1 = Integer.parseInt(sc.nextLine());
           a1[i-1] = b1;
           a2[i-1] = ~b1;
           a3[i-1] = a1[B-i];
           a4[i-1] = ~a1[B-i]; 
           }
           
           int[] b2 = new int[B];
    
        for(int i=1; i <= 10; i++){       
           System.out.println(i);
           b2[i-1] = Integer.parseInt(sc.nextLine());
        }
           
         for(int i=0; i < 10; i++){  
           if ((b2[i] == a1[i] ) || (b2[i] == ~a1[i])
           || (b2[i] == a1[B-i-1])  || (b2[i] == ~a1[B-i-1]  
                    )){
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + a1[i1];
           }
            System.out.println(s1);
            String output = sc.nextLine();
            if (output.equals("Y")){
              continue forloop;
            }
            else{
                break;
            }
           }
           
           if ((b2[i] == a2[i] ) || (b2[i] == ~a2[i])
           || (b2[i] == a2[B-i-1])  || (b2[i] == ~a2[B-i-1]  
                    )){
               String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + a2[i1];
           }
            System.out.println(s1);
            String output = sc.nextLine();
            if (output.equals("Y")){
              continue forloop;
            }
            else{
                break;
            }
           }
           
           if ((b2[i] == a3[i] ) || (b2[i] == ~a3[i])
           || (b2[i] == a3[B-i-1])  || (b2[i] == ~a3[B-i-1]  
                    )){
               String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + a3[i1];
           }
            System.out.println(s1);
            String output = sc.nextLine();
            if (output.equals("Y")){
              continue forloop;
            }
            else{
                break;
            }
           }
           
           if ((b2[i] == a4[i] ) || (b2[i] == ~a4[i])
           || (b2[i] == a4[B-i-1])  || (b2[i] == ~a4[B-i-1]  
                    )){
               String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + a4[i1];
           }
            System.out.println(s1);
            String output = sc.nextLine();
            if (output.equals("Y")){
              continue forloop;
            }
            else{
                break;
            }
           }
         }
           
           
            
           }
           
     }
}