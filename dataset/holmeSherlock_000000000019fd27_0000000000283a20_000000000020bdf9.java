import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        int c=0;
        while(c<t){
            c++;
            int n=sc.nextInt();
            char[] order=new char[n];
            myPair arr[]=new myPair[n];
            for (int i=0;i<n;i++){
                int start=sc.nextInt();
                int end=sc.nextInt();
                arr[i]=new myPair(start,end,i);
            }
            Arrays.sort(arr, new Comparator<myPair>() {
                @Override
                public int compare(myPair o1, myPair o2) {
                    if(o1.start<o2.start)
                        return -1;
                    if(o1.start>o2.start)
                        return 1;
                    if(o1.start==o2.start){
                        if(o1.end<o2.end)
                            return -1;
                        if(o1.end>o2.end)
                            return 1;
                    }
                    return 0;
                }
            });

            int C,J;
            C=J=0;
            boolean flag=true;
            for (int i=0;i<n;i++){
                int start=arr[i].start;
                int end=arr[i].end;
                int pos=arr[i].pos;
                if(C<=start){
                    C=end;
                    order[pos]='C';
                }
                else if(J<=start){
                    J=end;
                    order[pos]='J';
                }
                else{
                    flag=false;
                    break;
                }
            }
            if (!flag)
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            else {
                String str=new String(order);
                System.out.println("Case #" + c + ": " +str);
            }
        }
    }
}
class myPair{
    int start,end,pos;
    public myPair(int a,int b,int c){
        start=a;
        end=b;
        pos=c;
    }
}