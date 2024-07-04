import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[])throws IOException{
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int k=1;
    while(t-->0){
    String s=sc.next();
    String st="";
    char prev='0';
    for(int i=0;i<s.length();i++){
        char x=s.charAt(i);
        int p=x-prev;
        if(p>0){
        for(int j=1;j<=p;j++)
        st=st+'(';
    }else{
    for(int j=1;j<=Math.abs(p);j++)
    st=st+')';
    }
    st=st+x;
    prev=x;
    }
    int y=prev-'0';
    for(int i=1;i<=y;i++)
    st=st+')';
    System.out.println("Case #"+k+": "+st);
}
}
}