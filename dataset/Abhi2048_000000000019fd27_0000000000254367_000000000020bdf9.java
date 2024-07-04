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
        for(int i=0;i<n;i++){
            int st=sc.nextInt();
            int end=sc.nextInt();
            arr[st]=1;
            arr[end-1]=-1;
        }
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
        for(int i=0;i<n;i++){
            if(i%2==0)
            str+='J';
            else
            str+='C';
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