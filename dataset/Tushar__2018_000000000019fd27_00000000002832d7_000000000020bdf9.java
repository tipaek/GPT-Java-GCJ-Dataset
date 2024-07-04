import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int cs=1;
        while(t-->0){
            int n=in.nextInt();
            Myclass[] my=new Myclass[n];
            for(int i=0;i<n;i++){
                int a=in.nextInt(),b=in.nextInt();
                my[i]=new Myclass(a,b);
            }
            HashMap<Myclass,Integer> hm=new HashMap<Myclass,Integer>();
            for(int i=0;i<n;i++)hm.put(my[i],i);
            Arrays.sort(my,new Sort());
            int cnt=0;
            for(int i=0;i<n;i++){
                if(i+2<n){
                    int s1=my[i].geta(),s2=my[i+1].geta(),s3=my[i+2].geta();
                    int e1=my[i].getb(),e2=my[i+1].getb(),e3=my[i+2].getb();
                    if(e1>s2 && e2>s3 && e1>s3){
                        cnt=1;
                        break;
                    }
                }
            }
            if(cnt==1){
                System.out.println("Case #"+cs+": IMPOSSIBLE");
                continue;
            }
            ArrayList<Myclass> ar1=new ArrayList<Myclass>();
            ArrayList<Myclass> ar2=new ArrayList<Myclass>();
            int a=0;
            for(int i=1;i<n;i++){
                if(my[a].getb()>my[i].geta()){
                    ar2.add(my[i]);
                }
                else{
                    ar1.add(my[a]);
                    a=i;
                }
            }
            ar1.add(my[a]);
            for(int i=0;i<ar1.size();i++){
                ar1.get(i).set('C');
            }
            for(int i=0;i<ar2.size();i++){
                ar2.get(i).set('J');
            }
            Myclass[] my1=new Myclass[n];
            int j=0;
            for(int i=0;i<ar1.size();i++)my1[j++]=ar1.get(i);for(int i=0;i<ar2.size();i++)my1[j++]=ar2.get(i);
            for(int i=0;i<n;i++)my1[i].setpos(hm.get(my1[i]));
            Arrays.sort(my1,new Sort1());
            System.out.print("Case #"+cs+": ");
            for(int i=0;i<n;i++)System.out.print(my1[i].getc());
            cs+=1;
            System.out.println();
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