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
         for(int i=0;i<w.length()-1;i++){
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
         for(int i=0;i<w.length()-1;i++){
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
            int max=0;
            int maxi=0;
            for(int i=0;i<n;i++){
                StringBuilder st=new StringBuilder(br.readLine());
                String temp=st.reverse().toString();
                arr.add(temp);
                if(max<temp.length()){
                    maxi=i;
                 max=temp.length();
                }
            }
            Trie t=new Trie();
            insert(t,arr.get(maxi));
            int i=0;
            for( i=0;i<n;i++){
                if(i!=maxi){
                    boolean flag=insertOther(t,arr.get(i));
                    if(!flag){
                        System.out.println("Case #"+tes+": *");
                        break;
                    }
                }
            }
            StringBuilder temp=new StringBuilder(arr.get(maxi));
            if(i==n) System.out.println("Case #"+tes+": "+temp.reverse().substring(1));
        }
    }
}