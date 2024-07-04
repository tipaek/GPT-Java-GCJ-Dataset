import java.util.*;
class node {
    int b;
    int e;
    int i;
    char p;
    node(int b,int e,int i) {
        this.b=b;
        this.e=e;
        this.i=i;
    }
}
class mycomp implements Comparator<node> {
    public int compare(node x,node y) {
        if(x.b==y.b) {
            return x.e-y.e;
        } 
        return x.b-y.b;
    }
}
class icomp implements Comparator<node> {
    public int compare(node x,node y) {
        return x.i-y.i;
    }
}
class Solution {
    public static void main(String[]args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t=1; t<=T; t++) {
            int n = s.nextInt();
            node[]a=new node[n];
            for(int i=0;i<n;i++) {
                a[i] = new node(s.nextInt(),s.nextInt(), i);
            }
            Arrays.sort(a, new mycomp());
            a[0].p='C';
            int  cm=a[0].e,jm=0;
            boolean p =false;
            for(int i=1;i<n;i++) {
                if(cm<=a[i].b) {
                    a[i].p='C';
                    cm=a[i].e;
                } else if (jm<=a[i].b){
                    a[i].p='J';
                    jm=a[i].e;
                } else {
                    System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                    break;
                }
            }
            if(p) continue;
            StringBuilder sb = new StringBuilder();
            Arrays.sort(a,new icomp());
            for(int i=0;i<n;i++) {
                sb.append(a[i].p);
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
           