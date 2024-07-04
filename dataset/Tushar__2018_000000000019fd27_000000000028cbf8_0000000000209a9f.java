import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        in.nextLine();
        int cs=1;
        while(t-->0){
           String s=in.nextLine();
           StringBuilder ans=new StringBuilder("");
           if(s.length()==1){
               for(int i=0;i<Integer.parseInt(s.charAt(0)+"");i++)ans.append("(");
               ans.append(s.charAt(0));
               for(int i=0;i<Integer.parseInt(s.charAt(0)+"");i++)ans.append(")");
               System.out.println("Case #"+cs+": "+ans);
               cs+=1;
               continue;
           }
           for(int i=0;i<s.length()-1;i++){
               int a=Integer.parseInt(s.charAt(i)+""),b=Integer.parseInt(s.charAt(i+1)+"");
               if(i==0){
                   for(int j=0;j<a;j++)ans.append("(");
                   ans.append(a);
                   if(a<=b){
                       for(int j=0;j<b-a;j++)ans.append("(");
                   }
                   else{
                       for(int j=0;j<a-b;j++)ans.append(")");
                   }
                   continue;
               }
               if(a<=b){
                   ans.append(a);
                   for(int j=0;j<b-a;j++)ans.append("(");
               }
               else{
                   ans.append(a);
                   for(int j=0;j<a-b;j++)ans.append(")");
               }
           }
           ans.append(s.charAt(s.length()-1));
           for(int i=0;i<Integer.parseInt(s.charAt(s.length()-1)+"");i++)ans.append(")");
           System.out.println("Case #"+cs+": "+ans);
           cs+=1;
        }
    }
}
class Sort1 implements Comparator<Myclass>{
    public int compare(Myclass a,Myclass b){
        return a.pos-b.pos;
    }
}
class Sort implements Comparator<Myclass>{
    public int compare(Myclass a,Myclass b){
        return a.a-b.a;
    }
}
class Myclass{
    int a,b,pos;
    char ch;
    Myclass(int a,int b){
        this.a=a;this.b=b;
    }
    void setpos(int p){
        pos=p;
    }
    void set(char c){
        ch=c;
    }
    int getp(){return pos;}
    char getc(){return ch;}
    int geta(){return a;}int getb(){return b;}
}