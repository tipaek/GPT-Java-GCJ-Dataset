import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=0;
        sc.nextLine();
        while(c<t){
            c++;
            StringBuilder ans=new StringBuilder();
            char[] arr=sc.nextLine().toCharArray();
            int opencount=0,closecount=0,current=0;
            for(int i=0;i<arr.length;i++){
                int x=arr[i]-48;
                current=opencount-closecount;
                if(x==current)
                    ans.append(x);
                else if(x>current){
                    while(current<x){
                        ans.append("(");
                        opencount++;
                        current=opencount-closecount;
                    }
                    ans.append(x);
                }
                else{
                    while(current>x){
                        ans.append(")");
                        closecount++;
                        current=opencount-closecount;
                    }
                    ans.append(x);
                }
            }
            while(closecount<opencount){
                ans.append(")");
                closecount++;
            }
            System.out.println("Case #"+c+": "+ans.toString());
        }
    }
}