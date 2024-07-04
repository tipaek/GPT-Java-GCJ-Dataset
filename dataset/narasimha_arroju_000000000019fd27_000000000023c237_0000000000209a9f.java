import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine()),t1=0;
        while(t1<t){
            String s=sc.nextLine();
            String s1="";
            int ob=0,cb=0;
            for(int i=0;i<s.length();i++){
                int k=Character.getNumericValue(s.charAt(i));
                if(ob>k){
                    while(ob>k){
                        s1+=")";
                        ob--;
                        cb--;
                    }
                }
                else if(ob<k){
                    while(ob<k){
                        s1+="(";
                        ob++;
                        cb++;
                    }
                }
                s1+=""+k;
            }
            while(cb>0){
                s1+=")";
                cb--;
            }
            System.out.println("Case #"+(t1+1)+": "+s1);
            t1++;
        }
    }
}