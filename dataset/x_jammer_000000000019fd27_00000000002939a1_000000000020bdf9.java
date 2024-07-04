/* package codechef; // don't place package name! */
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution{
    private static Scanner s;
    static int t=1;
    public static void main(String[] args){
    s=new Scanner(System.in);
    int t1=s.nextInt();
    s.nextLine();
    while(t1-->0){
        harsh();
    }
}
private static void harsh()
{
    int n1=s.nextInt();
    int[][] mama=new int[n1][2];
    int[][] mamas=mama.clone();
    char child='J';
    char[] choas=new char[n1];
    Stack<int[]>joos=new Stack<>();
    Stack<int[]>coos=new Stack<>();
    boolean ans=false;
    Map<int[],Integer>mapa=new HashMap<>();
    for(int i=0;i<mama.length;i++)
    {
        for(int j=0;j<mama[i].length;j++){
            mama[i][j]=s.nextInt();
        }
        mapa.put(mama[i],i);
    }
    Arrays.sort(mamas,new Comparator<int[]>(){
        
        public int compare(int[]a,int[] b){
            return a[0]-b[0];
        }
    });
    for(int i=0;i<mamas.length;i++){
        choas[mapa.get(mamas[i])]=child;
     if(i<mamas.length-1&&two(mamas[i],mamas[i+1])){
         if(child=='J'){
             joos.push(mamas[i]);
             child=getchild(child);
             if(!coos.isEmpty()&&two(coos.peek(),mamas[i+1])){
                 ans=true;
                 break;
             }
         }else{
             coos.push(mamas[i]);
             child=getchild(child);
             if(!joos.isEmpty()&&two(joos.peek(),mamas[i+1])){
                 ans=true;
                 break;
             }
         }
     }else{
         if(child=='J'){
             joos.push(mamas[i]);
         }else{
             coos.push(mamas[i]);
         }
     }
    }
    System.out.println("Case #"+(t++)+":"+" "+(ans?"IMPOSSIBLE":new String(choas)));
}
    private static char getchild(char p){
        return p=='J'?'C':'J';
    }
    private static boolean two(int[] a,int[] b){
        return a[1]>b[0];
    }
}
