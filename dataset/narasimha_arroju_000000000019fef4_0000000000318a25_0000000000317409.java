import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t-->0){
            String[] s=sc.nextLine().split(" ");
            System.out.println(s[0]+"  "+s[1]+" "+s[2]);
        }
    }
}