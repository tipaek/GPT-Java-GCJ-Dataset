import java.util.*;
class Solution {
    static List<String> ls;
    static void compute(int current,int n,StringBuilder sb){
        if(current==n) {
            ls.add(sb.toString());
            return;
        }
        sb.append("N");
        compute(current+1,n,sb);
        sb.replace(sb.length()-1,sb.length(),"W");
        compute(current+1,n,sb);
        sb.replace(sb.length()-1,sb.length(),"S");
        compute(current+1,n,sb);
        sb.replace(sb.length()-1,sb.length(),"E");
        compute(current+1,n,sb);
        sb.replace(sb.length()-1,sb.length(),"");
        compute(current+1,n,sb);
    }
    static int findUpper(double n){
        double d=1;
        int count=0;
        while(d<=n){
            d*=2;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cn=1;
        while(cn<=t){
            cn++;
            ls=new ArrayList<>();
            ls.clear();
            long X=sc.nextLong();
            long Y=sc.nextLong();
            if((X%2!=0 && Y%2!=0)  ||  (X%2==0 && Y%2==0)) {
                System.out.println("Case #"+(cn-1)+": "+"IMPOSSIBLE");
                continue;
            }
            long x,y;
            x=y=0;
            boolean flag=false;
            long tx,ty;
            tx=ty=0;
            if(X<0)
                tx=X*-1;
            else
                tx=X;
            if(Y<0)
                ty=Y*-1;
            else
                ty=Y;
            int upper=findUpper((tx>ty)?tx:ty);
            StringBuilder ans=new StringBuilder();
            compute(0,upper+1,new StringBuilder());
            //System.out.println(ls.contains("NWS"));
            long i=0;
            for(String s:ls){
                i=0;
                x=0;
                y=0;
                char arr[]=s.toCharArray();
                for (char c:arr){
                    switch (c){
                        case 'N':
                            y+=Math.pow(2,i);
                            break;
                        case 'S':
                            y-=Math.pow(2,i);
                            break;
                        case 'E':
                            x+=Math.pow(2,i);
                            break;
                        case 'W':
                            x-=Math.pow(2,i);
                            break;
                    }
                    i++;
                }
                if(x==X && y==Y) {
                    flag = true;
                    if(ans.length()==0)
                        ans.append(s);
                    else if(s.length()<ans.length()) {
                        ans.replace(0,ans.length(),"");
                        ans.append(s);
                    }
                    //break;
                }
            }
            if (flag)
                System.out.println("Case #"+(cn-1)+": "+ans.toString());
            else
                System.out.println("Case #"+(cn-1)+": "+"IMPOSSIBLE");
        }
    }
}