import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++){
            int x=sc.nextInt(),y=sc.nextInt();
            int d1=x,d2=(x*y)-d1-1;int c=1,f=1;
            int steps=0;
            while(d1+d2>=x && x*y-f>y){
                  steps++;
                  c++;f++;
                  if(c%y==0){
                      d1--;d2--;c=1;f++;
                  }
                  else{
                      d2--;
                  }
                }
            System.out.println("Case #"+i+": "+steps);
            c=1;d1=x;d2=(x*y)-d1-1;f=1;
            while(d1+d2>=x && x*y-f>y){
                  System.out.println(d1+" "+d2);
                  c++;f++;
                  if(c%y==0){
                      d1--;d2--;c=1;f++;
                  }
                  else{
                      d2--;
                  }
                }
        }
    }
}