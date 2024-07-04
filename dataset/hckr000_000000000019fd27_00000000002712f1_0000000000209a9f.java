// "static void main" must be defined in a public class.
import java.util.*;
import java.lang.String;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       for(int i=0;i<t;i++){
           String s = sc.next();
            String p = "(";
           String q = ")";
            String h = "";
           if(s.length()==1){h=h+repeat(p,Integer.parseInt(String.valueOf(s.charAt(0))))+s.charAt(0)+repeat(q,Integer.parseInt(String.valueOf(s.charAt(0))));}
           else if(s.length()==2){
               h=h+repeat(p,Integer.parseInt(String.valueOf(s.charAt(0))))+s.charAt(0);
               if(Integer.parseInt(String.valueOf(s.charAt(0)))>Integer.parseInt(String.valueOf(s.charAt(1)))){
                   h=h+repeat(q,Math.abs(Integer.parseInt(String.valueOf(s.charAt(0)))-Integer.parseInt(String.valueOf(s.charAt(1)))))+s.charAt(1);
               }else{
                   h=h+repeat(p,Math.abs(Integer.parseInt(String.valueOf(s.charAt(0)))-Integer.parseInt(String.valueOf(s.charAt(1)))))+s.charAt(1);
               }
               h=h+repeat(q,Integer.parseInt(String.valueOf(s.charAt(1))));
           }
           
           
           else{
           
           if(s.charAt(0)!=0){
           h=h+repeat(p,Integer.parseInt(String.valueOf(s.charAt(0))));
            h=h+s.charAt(0);}
           else{h=h+s.charAt(0);}
            int[] b = new int[s.length()-1];int k=0;
            for(int j=0;j<s.length()-1;j++){
                b[k++] = Math.abs(Integer.parseInt(String.valueOf(s.charAt(j)))-Integer.parseInt(String.valueOf(s.charAt(j+1)))); 
            }int h1=1;
           
           for(int g=0;g<b.length-1;g++){
               if(b[g]<b[g+1]){h=h+repeat(p,b[g]);h=h+s.charAt(h1++);}
               else{h=h+repeat(q,b[g]);h=h+s.charAt(h1++);}
               
           }
           if(b[b.length-1]>b[b.length-2]){h=h+repeat(q,b[b.length-1]);h=h+s.charAt(s.length()-1);}
           else{h=h+repeat(p,b[b.length-2]);h=h+s.charAt(s.length()-1);}
           h=h+repeat(q,Integer.parseInt(String.valueOf(s.charAt(s.length()-1))));}
        System.out.println(h);}
    }
    public static String repeat(String l,int n){
        String v = "";
        for(int i=0;i<n;i++){
            v=v+l;
        }
    return v;}
}