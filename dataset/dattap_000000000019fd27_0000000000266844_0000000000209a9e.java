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
         int cnt = 0;
         int cnt1 = 0;
         int cnt2 = 0;
         int cnt3 = 0;
         for(int i=0; i < 10; i++){  
           if (b2[i] == a1[i] ){
               cnt++;
           }  
           if (b2[i] == ~a1[i]){
               cnt1++;
           }
           if (b2[i] == a1[B-i-1]){
               cnt2++;
           }
           if (b2[i] == ~a1[B-i-1])  
                    {
                        cnt3++;
                    }
         }
            if (cnt == 10 ){        
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
           
           if (cnt1 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + ~a1[i1];
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
           
           if (cnt2 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + a1[B - i1 -1];
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
           
           if (cnt3 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + ~a1[B - i1 -1];
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
           cnt = 0;
           cnt1 = 0;
           cnt2 = 0;
           cnt3 = 0;
           for(int i=0; i < 10; i++){  
           if (b2[i] == a2[i] ){
               cnt++;
           }  
           if (b2[i] == ~a2[i]){
               cnt1++;
           }
           if (b2[i] == a2[B-i-1]){
               cnt2++;
           }
           if (b2[i] == ~a2[B-i-1])  
                    {
                        cnt3++;
                    }
         }
           if (cnt == 10 ){        
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
           
           if (cnt1 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + ~a2[i1];
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
           
           if (cnt2 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + a2[B - i1 -1];
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
           
           if (cnt3 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + ~a2[B - i1 -1];
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
           
           cnt = 0;
           cnt1 = 0;
           cnt2 = 0;
           cnt3 = 0;
           for(int i=0; i < 10; i++){  
           if (b2[i] == a3[i] ){
               cnt++;
           }  
           if (b2[i] == ~a3[i]){
               cnt1++;
           }
           if (b2[i] == a3[B-i-1]){
               cnt2++;
           }
           if (b2[i] == ~a3[B-i-1])  
                    {
                        cnt3++;
                    }
         }
           
           if (cnt == 10 ){        
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
           
           if (cnt1 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + ~a3[i1];
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
           
           if (cnt2 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + a3[B - i1 -1];
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
           
           if (cnt3 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + ~a3[B - i1 -1];
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
           cnt = 0;
           cnt1 = 0;
           cnt2 = 0;
           cnt3 = 0;
           for(int i=0; i < 10; i++){  
           if (b2[i] == a4[i] ){
               cnt++;
           }  
           if (b2[i] == ~a4[i]){
               cnt1++;
           }
           if (b2[i] == a4[B-i-1]){
               cnt2++;
           }
           if (b2[i] == ~a4[B-i-1])  
                    {
                        cnt3++;
                    }
         }
           
           if (cnt == 10 ){        
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
           
           if (cnt1 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + ~a4[i1];
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
           
           if (cnt2 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + a4[B - i1 -1];
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
           
           if (cnt3 == 10 ){        
             String s1 = "";
           for(int i1=0; i1 < 10; i1++){
               s1 = s1 + ~a4[B - i1 -1];
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