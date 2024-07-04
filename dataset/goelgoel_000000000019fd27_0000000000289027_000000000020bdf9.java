import java.io.*;
import java.lang.*;
import java.util.*;
class Pair{
    int s=0;
    int e=0;
    int index=0;
}
class Period implements Comparator<Pair>{
     public int compare(Pair a, Pair b) 
    { 
        return a.s-b.s; 
    } 
}
class Solution{
public static void main(String args[])throws IOException{
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int k=1;
    while(t-->0){
        int n=sc.nextInt();
        ArrayList<Pair> temp=new ArrayList<>();
        ArrayList<Pair> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            Pair p=new Pair();
            p.s=a;
            p.e=b;
            p.index=i;
            arr.add(p);
            
        }
    
     
    Collections.sort(arr,new Period());
    
    int c_end=0,j_end=0;
    char c[]=new char[n];
    String ans="";
    for(int i=0;i<n;i++){
        int start=arr.get(i).s;
        if(start<c_end&&start<j_end){
            ans="IMPOSSIBLE";
            break;
        }
        if(start>=c_end){
            c[arr.get(i).index]='C';
            c_end=arr.get(i).e;
        }else if(start>=j_end){
            c[arr.get(i).index]='J';
            j_end=arr.get(i).e;
        }
    }
    if(!ans.equals("IMPOSSIBLE")){
    String st=new String(c);
    System.out.println("Case #"+k+": "+st);}
    else System.out.println("Case #"+k+": "+ans);
    k++;
    }
}    
}