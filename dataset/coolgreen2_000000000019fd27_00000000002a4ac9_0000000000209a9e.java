import java.util.*;
import java.io.*;

public class Solution {

   static BufferedReader br;

   public static void main(String[] args) throws IOException {
      br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int T = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      for (int cases = 1; cases <= T; cases++) {
         int counter = 0;
         LinkedList<Pairs> same = new LinkedList<Pairs>();
         LinkedList<Pairs> different = new LinkedList<Pairs>();
         for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            int x = Integer.parseInt(br.readLine());
            System.out.println(B-i+1);
            int y = Integer.parseInt(br.readLine());
            if (x == y) same.add(new Pairs(x, y, i));
            else different.add(new Pairs(x,y,i));
            counter+=2;
         }
         if (counter >= B) {
            printAns(same, different, B);
            continue;
         }
         for (int i = 6; i <= B/2; i++) {
            if ((i-2)%4 == 0) {
               if (!same.isEmpty()) {
                  System.out.println(same.peek().init);
                  int temp = Integer.parseInt(br.readLine());
                  if (temp != same.peek().first) {
                     for (Pairs p : same) {
                        p.update();
                     }
                  }
               } 
               else {
                  System.out.println(different.peek().init);
                  int temp = Integer.parseInt(br.readLine());
               }
               
               if (!different.isEmpty()) {
                  System.out.println(different.peek().init);
                  int temp = Integer.parseInt(br.readLine());
                  if (temp != different.peek().first) {
                     for (Pairs p : different) {
                        p.update();
                     }
                  }
               } 
               else {
                  System.out.println(same.peek().init);
                  int temp = Integer.parseInt(br.readLine());
               }
            }
            System.out.println(i);
            int x = Integer.parseInt(br.readLine());
            System.out.println(B-i+1);
            int y = Integer.parseInt(br.readLine());
            if (x == y) same.add(new Pairs(x, y, i));
            else different.add(new Pairs(x,y,i));
            counter+=2;
            if (counter >= B)
               break;
         }
         printAns(same, different, B);  
         
      
      }  
   
   }
   
   public static void printAns(LinkedList<Pairs> same, LinkedList<Pairs> different, int B) throws IOException{
      int[] ans = new int[B+1];
      for (Pairs p: same) {
         ans[p.init] = p.first;
         ans[B-p.init+1]=p.second;
      }
      for (Pairs p: different) {
         ans[p.init] = p.first;
         ans[B-p.init+1]=p.second;
      }
      String answer = "";
      for (int i = 1; i <= B; i++) {
         answer += ans[i];
      }
      System.out.println(answer);
      char result = br.readLine().charAt(0);
      if (result == 'Y')
         return;
      else
         System.exit(0);
   }
   
   
   static class Pairs {
      int first;
      int second;
      int init; 
      
      public Pairs(int a, int b, int c) {
         first = a;
         second = b;
         init = c;
      }  
      
      public void update() {
         if (first == second) {
            first = 1 - first;
            second = first;
         } 
         else {
            first = second;
            second = 1-first;
         }
      }
   
   }



}