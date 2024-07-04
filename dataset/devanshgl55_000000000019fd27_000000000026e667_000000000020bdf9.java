import java.util.*;
import java.io.*;
class par{
    int x,y,no,r;
    // par(int a,int b,int c){
    //     x=a;
    //     y=b;
    //     no=c;
    //     r=0;
    // }
}
class Sortbyx implements Comparator<par> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(par a, par b) 
    { 
        int x=a.x - b.x; 
        if(x!=0)
            return x;
        else
            return a.y-b.y;
    } 
} 
class Sortbyno implements Comparator<par> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(par a, par b) 
    { 
        return a.no-b.no;
    } 
} 
class Solution{
    public static void main(String arf[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int q=0;
        
        while(q++<t){
            int i;
            String ans="";
            System.out.print("Case #"+q+": ");
            int n=sc.nextInt();
            ArrayList<par> arr=new ArrayList<par> (); 
            for(int k=0;k<n;k++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                par s=new par();
                s.x=x;
                s.y=y;
                s.no=k;
                s.r=0;
                arr.add(s);
            }
            Collections.sort(arr,new Sortbyx());
            int a=0,b=0;
            for(i=0;i<n;i++){
                if(arr.get(i).x>=a){
                    a=arr.get(i).y;
                    arr.get(i).r=1;
                }
                else if(arr.get(i).x>=b){
                    b=arr.get(i).y;
                    arr.get(i).r=2;
                }
                else
                    break;
            }
            if(i!=n)
                System.out.println("Impossible");
            else{
                Collections.sort(arr,new Sortbyno());
                for(i=0;i<n;i++)
                    if(arr.get(i).r==1)
                        System.out.print("C");
                    else
                        System.out.print("J");
                System.out.println();
            }
            
        }
    }
}