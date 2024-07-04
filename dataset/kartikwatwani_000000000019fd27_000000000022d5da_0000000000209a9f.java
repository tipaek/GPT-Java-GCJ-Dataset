import java.util.*;
import java.io.*;
public class Solution {
 private static int next(String s,int cn){
     for(int l=0;l<s.length();l++){
         int cnn=getNum(s,l);
         if(cnn!=cn)return cnn;
     }
     return 0;
 }
 private static int getNum(String s,int pos){
     return Integer.parseInt(String.valueOf(s.charAt(pos)));
 }
 public static void main(String[] args) {
  Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int t = in .nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
  for (int i = 1; i <= t; ++i) {
   String s=in.next();
   int len=s.length();
   int unbal=0;
   StringBuilder result=new StringBuilder();
   int[] ints=new int[len];
   for(int pos=0;pos<len;pos++){
    int cn=getNum(s,pos);
    int nex=pos+1==len?0:next(s.substring(pos+1),cn);
    int loop=cn-unbal;
    if(pos==0||(pos>0 && cn!=getNum(s,pos-1))){
    for(int k=0;k<loop;k++){
      result.append('(');
      unbal++;
    }
    }
    result.append(cn);
    if(pos==len-1||cn!=getNum(s,pos+1)){
        int endloop=unbal-nex;
        for(int g=0;g<endloop;g++){
            result.append(')');
            unbal--;
        }
    }
    
    
   }
   System.out.println("Case #" +i+": "+result.toString());
  }
 }
}