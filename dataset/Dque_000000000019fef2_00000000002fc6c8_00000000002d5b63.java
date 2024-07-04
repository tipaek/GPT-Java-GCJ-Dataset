//make sure to make new file!
import java.io.*;
import java.util.*;

public class P2{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      
      StringTokenizer st = new StringTokenizer(f.readLine());
      int t = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      int e92 = 1000000000/2;
      for(int q = 1; q <= t; q++){

         int curx = -1;
         int cury = -1;
         
         out.println("0 " + e92);
         out.flush();
         
         String p1 = f.readLine();
         
         if(p1.equals("CENTER")){
            continue;
         }
         
         if(p1.equals("HIT")){
            curx = 0;
            cury = e92;
         }
         
         out.println("0 " + (-1*e92));
         out.flush();
         
         String p2 = f.readLine();
         
         if(p2.equals("CENTER")){
            continue;
         }
         
         if(p2.equals("HIT")){
            curx = 0;
            cury = -1*e92;
         }
         
         out.println(e92 + " 0");
         out.flush();
         
         String p3 = f.readLine();
         
         if(p3.equals("CENTER")){
            continue;
         }
         
         if(p3.equals("HIT")){
            curx = e92;
            cury = 0;
         }
         
         out.println((-1*e92) + " 0");
         out.flush();
         
         String p4 = f.readLine();
         
         if(p4.equals("CENTER")){
            continue;
         }
         
         if(p4.equals("HIT")){
            curx = -1*e92;
            cury = 0;
         }
         
         
         //binary search up down left right
         
         boolean found = false;
         
         //up
         int l = cury;
         int r = 1000000000;
         int mid;
         int ansup = cury;
         while(l != r){
            mid = l + (r-l)/2;
            
            out.println(curx + " " + mid);
            out.flush();
            String s = f.readLine();
            
            if(s.equals("CENTER")){
               found = true;
               break;
            } else if(s.equals("HIT")){
               //go up
               l = mid+1;
               ansup = mid;
            } else {
               r = mid-1;
            }
         }
         
         if(found){
            continue;
         }
         
         //down
         l = -1000000000;
         r = cury;
         
         int ansdown = cury;
         while(l != r){
            mid = l + (r-l)/2;
            
            out.println(curx + " " + mid);
            out.flush();
            String s = f.readLine();
            
            if(s.equals("CENTER")){
               found = true;
               break;
            } else if(s.equals("HIT")){
               //go down
               r = mid-1;
               ansdown = mid;
            } else {
               l = mid+1;
            }
         }
         
         if(found){
            continue;
         }
         
         //left
         l = -1000000000;
         r = curx;
         
         int ansleft = curx;
         
         while(l != r){
            mid = l + (r-l)/2;
            
            out.println(mid + " " + cury);
            out.flush();
            String s = f.readLine();
            
            if(s.equals("CENTER")){
               found = true;
               break;
            } else if(s.equals("HIT")){
               //go down
               r = mid-1;
               ansleft = mid;
            } else {
               l = mid+1;
            }
         }
         
         if(found){
            continue;
         }
         
         
         //right
         l = curx;
         r = 1000000000;
         
         int ansright = curx;
         
         while(l != r){
            mid = l + (r-l)/2;
            
            out.println(mid + " " + cury);
            out.flush();
            String s = f.readLine();
            
            if(s.equals("CENTER")){
               found = true;
               break;
            } else if(s.equals("HIT")){
               //go up
               l = mid+1;
               ansright = mid;
            } else {
               r = mid-1;
            }
         }
         
         if(found){
            continue;
         }
         
         
         int ansy = (ansup + ansdown)/2;
         int ansx = (ansleft+ansright)/2;
         
         int BUF = 5;
         for(int k = ansx-BUF; k <= ansx+BUF; k++){
            if(found) break;
            for(int j = ansy-BUF; j <= ansy+BUF; j++){
               if(!in(k,j)) continue;
               out.println(k + " " + j);
               out.flush();
               
               String s = f.readLine();
               
               if(s.equals("CENTER")){
                  found = true;
                  break;
               }
            }
         }
         
         if(!found){
            out.close();
            return;
         }
         
      }
      
      
      
      
      out.close();
   }
   
   public static boolean in(int x, int y){
      return x >= -1000000000 && x <= 1000000000 && y >= -1000000000 && y <= 1000000000;
   }
      
}