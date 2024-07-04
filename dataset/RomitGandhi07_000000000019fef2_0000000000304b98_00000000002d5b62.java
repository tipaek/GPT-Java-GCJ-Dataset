import java.util.*;
public class Solution{

    static int highestPowerof2(int n) 
    { 
        int p = (int)(Math.log(n)/Math.log(2)); 
        return (int)p;  
    }    

    static boolean booleanHighestPowerof2(int n) 
    { 
        double p = (Math.log(n)/Math.log(2)); 
        double t1=Math.ceil(p);
        double t2=Math.floor(p);
        if (t1==t2) {
            return true;
        }
        return false;
    }    


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); 
        int t=sc.nextInt();
        for (int z=1;z<=t;++z) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            String ans="";
            int temp=0;
            boolean flag=false,flag2=false,fflag=false;
            // w.println((x%2)+"::"+(y%2));
            if (Math.abs(x%2)==1 && Math.abs(y%2)==1) {
                ans="IMPOSSIBLE";
            }
            else if(Math.abs(x%2)==0 && Math.abs(y%2)==0){
                ans="IMPOSSIBLE";
            }
            else if (x==0) {
                if (y<0) {
                    y=Math.abs(y)+1;
                    flag=booleanHighestPowerof2(y);
                    if (!flag) {ans="IMPOSSIBLE";}
                    else{
                        // ans="S";
                        temp=highestPowerof2(y);
                        for (int i=0;i<temp;++i) {
                            ans+="S";
                        }
                    }                
                }
                else{
                    ++y;
                    flag=booleanHighestPowerof2(y);
                    if (!flag) {ans="IMPOSSIBLE";}
                    else{
                        // ans="N";
                        temp=highestPowerof2(y);
                        for (int i=0;i<temp;++i) {
                            ans+="N";
                        }
                    }
                }           
            }
            else if (y==0) {
                if (x<0) {
                    x=Math.abs(x)+1;
                    flag=booleanHighestPowerof2(x);
                    if (!flag) {ans="IMPOSSIBLE";}
                    else{
                        // ans="W";
                        temp=highestPowerof2(x);
                        for (int i=0;i<temp;++i) {
                            ans+="W";
                        }
                    }                
                }
                else{
                    ++x;
                    flag=booleanHighestPowerof2(x);
                    if (!flag) {ans="IMPOSSIBLE";}
                    else{
                        // ans="E";
                        temp=highestPowerof2(x);
                        for (int i=0;i<temp;++i) {
                            ans+="E";
                        }
                    }
                }      
            }
            else{
                if (x%2==0) {
                    if(x<0){flag=true;x=Math.abs(x);}
                    if(y<0){flag2=true;y=Math.abs(y);}
                    char[] c1=Integer.toBinaryString(x).toCharArray();
                    char[] c2=Integer.toBinaryString(y).toCharArray();
                    char[] c3=new char[Math.max(c1.length,c2.length)+1];
                    for (int i=0;i<Math.min(c1.length,c2.length)-1;++i) {
                        if (c1[i]=='1' && c2[i]=='1') {
                            c3[i+2]='N';
                            if (flag) {c3[i+1]='W';}
                            else{c3[i+1]='E';}
                            c3[i]='S';
                        }
                    }
                    ans=new String(c3);
                }
                else{
                    if(x<0){flag=true;x=Math.abs(x);}
                    if(y<0){flag2=true;y=Math.abs(y);}
                    char[] c1=Integer.toBinaryString(x).toCharArray();
                    char[] c2=Integer.toBinaryString(y).toCharArray();
                    char[] c3=new char[Math.max(c1.length,c2.length)+1];
                    for (int i=0;i<Math.min(c1.length,c2.length)-1;++i) {
                        if (c1[i]=='1' && c2[i]=='1') {
                            c3[i+2]='E';
                            if (flag2) {c3[i+1]='S';}
                            else{c3[i+1]='N';}
                            c3[i]='W';
                        }
                    }
                    ans=new String(c3);
                }
            }
            System.out.println("Case #"+z+": "+ans);
        }
    }
}
    
    