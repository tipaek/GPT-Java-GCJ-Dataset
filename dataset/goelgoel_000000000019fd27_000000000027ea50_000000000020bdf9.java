import java.io.*;
import java.lang.*;
import java.util.*;
class Pair{
    int s=0;
    int e=0;
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
        ArrayList<Pair> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            Pair p=new Pair();
            p.s=a;
            p.e=b;
            arr.add(p);
        }
    ArrayList<Pair> temp=arr;
     
    Collections.sort(arr,new Period());
    HashMap<Pair,Integer> map=new HashMap<>();
     for(int i=0;i<n;i++){
         map.put(arr.get(i),i);
     }
    int c_end=0,j_end=0;
    String ans="";
    for(int i=0;i<n;i++){
        int start=arr.get(i).s;
        if(start<c_end&&start<j_end){
            ans="IMPOSSIBLE";
            break;
        }
        if(start>=c_end){
            ans=ans+'C';
            c_end=arr.get(i).e;
        }else if(start>=j_end){
            ans=ans+'J';
            j_end=arr.get(i).e;
        }
    }
    if(!ans.equals("IMPOSSIBLE")){
    String st="";
    for(int i=0;i<n;i++){
        Pair p=temp.get(i);
        int x=map.get(p);
        st=st+ans.charAt(x);
    }
    System.out.println("Case #"+k+": "+st);}
    else System.out.println("Case #"+k+": "+ans);
    k++;
    }
}    
}