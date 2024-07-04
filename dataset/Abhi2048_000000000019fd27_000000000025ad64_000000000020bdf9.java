import javax.swing.text.MutableAttributeSet;
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
            ob.end=end-1;
            ob.n=i;
            ark[i]=ob;
        }
        Arrays.sort(ark);

        int c=0;
        for(int i=1;i<cont;i++){
            arr[i]+=arr[i-1];
            if(arr[i]>2)
                c=1;
        }

        sb.append("Case #");
        sb.append(ii+": ");

        if(c==0){
        String str="";
        node temp[]=new node[n];
        int k=0;
        char ch[]={'C','J'};
        int i;
        for( i=0;i<n-1;i++){
         int st=ark[i].start;
         int en=ark[i].end;
         ark[i].c=ch[k%2];
         temp[ark[i].n]=ark[i];
             for(int j=i+1;j<n;j++){

                 if(ark[j].start<=en){
                     i=j;
                     ark[j].c=ch[(k+1)%2];
                     temp[ark[j].n]=ark[j];
                 }else
                     break;
             }

        }
        if(i<n)
        {
            ark[i].c=ch[k%2];
            temp[ark[i].n]=ark[i];
        }
        for(i=0;i<n;i++){

            str+=temp[i].c;
        }


        sb.append(str);
        }else{
            sb.append("IMPOSSIBLE");
        }

        sb.append("\n");
    }
    System.out.println(sb.toString());
}

}
class node implements Comparable<node>{
    int start=0,end=0,n=0;char c;
    public int compareTo(node n){
        return  this.start-n.start;
    }
}