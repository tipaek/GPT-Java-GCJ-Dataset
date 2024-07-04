import java.util.*;
import java.io.*;
public class Solution{
   public static void main(String[] main) throws Exception{
      BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
      //StringTokenizer st = new StringTokenizer(b.readLine());
      int t = Integer.parseInt(b.readLine());
      for(int trial = 1; trial <= t; trial++){
         int N = Integer.parseInt(b.readLine());
         String[] words = new String[N];
         String longpre = "";
         String longpost = "";
         boolean works = true;
         String mid = "";
         for(int i = 0; i < N; i++){
            words[i] = b.readLine();
            int first = words[i].indexOf('*');
            String prefix = words[i].substring(0,first);
            if(longpre.length() >= prefix.length()){
               if(!longpre.substring(0,prefix.length()).equals(prefix)){
                  works = false;
                  //break;
               }
            }
            else{
               if(!prefix.substring(0,longpre.length()).equals(longpre)){
                  works = false;
                  //break;
               }
               else
                  longpre = prefix;
            }
            int last = words[i].lastIndexOf('*');
            String postfix = words[i].substring(last+1);
            if(longpost.length() >= postfix.length()){
               if(!longpost.substring(longpost.length()-postfix.length()).equals(postfix)){
                  works = false;
                  //break;
               }
            }
            else{
               if(!postfix.substring(postfix.length()-longpost.length()).equals(longpost)){
                  works = false;
                  //break;
               }
               else
                  longpost = postfix;
            }
            if(first != last){
               String[] stuff = words[i].substring(first+1,last).split("\\*");
               for(int j = 0; j < stuff.length; j++)
                  mid += stuff[j];
            }
         }
         if(works){
            System.out.println("Case #" + trial + ": " + longpre + mid + longpost);
         }
         else
            System.out.println("Case #" + trial + ": *");
      }
   }
}