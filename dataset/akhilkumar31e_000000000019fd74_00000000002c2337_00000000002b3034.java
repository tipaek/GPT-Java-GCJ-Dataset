import java.io.*;
import java.util.*;

public class Solution {
    public static class Trie{
         Trie[] c;
         int count;
         int max;
         Trie(){
             c=new Trie[26];
             count=0;
             max=0;
         }
     }
     static void insert(Trie root,String w){
         for(int i=0;i<w.length();i++){
             int idx=w.charAt(i)-'A';
             if(root.c[idx]==null){
                 root.c[idx]=new Trie();
             }
             root=root.c[idx];
             root.max=Math.max(root.max,w.length());
             root.count++;
         }
     }
    static boolean insertOther(Trie root,String w){
         for(int i=0;i<w.length();i++){
             int idx=w.charAt(i)-'A';
             if(root.c[idx]==null){
                 return false;
             }
             root=root.c[idx];
             root.max=Math.max(root.max,w.length());
             root.count++;
         }
        return true;
     }
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        for(int tes=1;tes<=test;tes++){
            int n=Integer.parseInt(br.readLine());
            ArrayList<String> arr=new ArrayList<String>();
            int maxLeft=0;
            int maxRight=0;
            StringBuilder left=new StringBuilder(""),right=new StringBuilder("");
            for(int i=0;i<n;i++){
                String st=br.readLine();
                String str=st.replace('*',' ');
               // System.out.println(str);
                String temp[]=str.split(" ");
                String l=temp[0];
                
                arr.add(str);
                if(maxLeft<l.length()){
                    left=new StringBuilder(l);
                 maxLeft=l.length();
                }
                if(temp.length==2){
                    String r=temp[1];
                if(maxRight<r.length()){
                    right=new StringBuilder(r);
                 maxRight=r.length();
                }
                }
            }
            Trie lt=new Trie();
            insert(lt,left.toString());
            Trie rt=new Trie();
            insert(rt,right.reverse().toString());
            int i=0;
           // System.out.println(arr+" "+left.toString()+" "+right.toString());
            for( i=0;i<n;i++){
                StringBuilder LS=new StringBuilder("");
                StringBuilder RS=new StringBuilder("");
                
                String temp[]=arr.get(i).split(" ");
                 LS=new StringBuilder(temp[0]);
                 if(temp.length==2) RS=new StringBuilder(temp[1]);
                
                boolean flag1=insertOther(lt,LS.toString());
                boolean flag2=insertOther(rt,RS.reverse().toString());
               // System.out.println(flag1+" "+flag2+" "+RS.toString());
                if(flag1==false||flag2==false){
                    System.out.println("Case #"+tes+": *");
                    break;
                }
            }
            
            if(i==n) System.out.println("Case #"+tes+": "+left.toString()+right.reverse().toString());
        }
    }
}