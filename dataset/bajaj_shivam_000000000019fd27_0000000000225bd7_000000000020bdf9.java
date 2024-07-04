import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Triple{
    int si;
    int ei;
    int index;
    public  Triple(int si,int ei, int index){
        this.si=si;
        this.ei=ei;
        this.index=index;
    }
}
class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            int n=sc.nextInt();
            Triple arr[]=new Triple[n];
            for(int i=0;i<n;i++){
                int f=sc.nextInt();
                int s=sc.nextInt();
                int in=i;
                arr[i]=new Triple(f,s,in);
            }
            Arrays.sort(arr, new Comparator<Triple>() {
                @Override
                public int compare(Triple a, Triple b) {
                    if(a.si<b.si)
                        return -1;
                    else if(a.si>b.si)
                        return 1;
                    else{
                        if(a.ei<b.ei)
                            return -1;
                        else if(a.ei>b.ei)
                            return 1;
                        else
                            return 0;
                    }
                }
            });

            char ans[]=new char[n];
            boolean isPossible=true;
            int c=0,j=0;
            for(int i=0;i<n;i++){

                if((arr[i].si<c && arr[i].si<j)){
                    isPossible=false;
                    break;
                }

                if(arr[i].si>=c){
                    c=arr[i].ei;
                    ans[arr[i].index]='C';
                }else if(arr[i].si>=j){
                    j=arr[i].ei;
                    ans[arr[i].index]='J';
                }
            }
            if(isPossible){
                StringBuilder sb=new StringBuilder("");
                for(char ch:ans)
                    sb.append(ch);
                System.out.println("Case #"+tt+": "+sb);
            }else
                System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
        }
    }
}
