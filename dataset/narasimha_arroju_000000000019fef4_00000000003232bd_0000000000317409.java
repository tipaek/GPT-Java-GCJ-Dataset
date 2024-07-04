import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine()),t1=1;
        while(t-->0){
            String[] str=sc.nextLine().split(" ");
            System.out.print("Case #"+(t1++)+": ");
            int x=Integer.parseInt(str[0]),y=Integer.parseInt(str[1]);
            int n=str[2].length(),flag=0;
            for(int i=0;i<n;i++){
                switch(str[2].charAt(i)){
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                if(Math.abs(x)+Math.abs(y)<=i+1){
                    System.out.println(i+1);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.println("IMPOSSIBLE");
        }
    }
}