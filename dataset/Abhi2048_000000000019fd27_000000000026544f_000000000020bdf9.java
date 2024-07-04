import java.util.*;
class Solution {
public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    StringBuilder sb=new StringBuilder();
    int cont=24*60+2;
    for(int ii=1;ii<=t;ii++){
       // System.out.println(ii);
        int arr[]=new int[cont];
        int n=sc.nextInt();
        node ark[]=new node[n];
        for(int i=0;i<n;i++){
            int st=sc.nextInt();
            int end=sc.nextInt();
            arr[st]=1;
            arr[end-1]=-1;
            node ob=new node();
            ob.start=st;
            ob.end=end;
            ob.n=i;
            ark[i]=ob;
        }
        Arrays.sort(ark);
        node ans[]=new node[n];
        int f=0,c=0,j=0;
        String str="";
        for(int i=0;i<n;i++){
            node p=ark[i];
           // System.out.println(c+" "+j+" "+p.start);
            if(c<=p.start){
                c=p.end;
                p.c='C';
            }else if(f<=p.start){
                f=p.end;
                p.c='J';
            }else{
                f=1;
                break;
            }
            ans[p.n]=p;
        }
        if(f==1)
            str="IMPOSSIBLE";
        else {
            for (int i = 0; i < n; i++) {
                str += ans[i].c;
            }
        }



        sb.append("Case #");
        sb.append(ii+": ");

        sb.append(str);

        sb.append("\n");
    }
    System.out.println(sb.toString());
}

}
class node implements Comparable<node>{
    int start=0,end=0,n=0;char c='C';
    public int compareTo(node n){
        return  this.start-n.start;
    }
}