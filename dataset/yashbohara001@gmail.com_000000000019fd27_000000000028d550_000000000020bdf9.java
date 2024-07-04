import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
        for(int i=1;i<=t;i++)
            {
        int t2 = in.nextInt();
        int f=2*t2;
        
        
         ArrayList<Integer> arr = new ArrayList<Integer>(f);
        ArrayList<Integer> arrc = new ArrayList<Integer>(f);
        ArrayList<Integer> arrj = new ArrayList<Integer>(f);
        for(int j=0;j<f;j++)
        {
        arr.add(in.nextInt());
        
        }
        int c=0,c2=0,k=0,k2=0,tp1=0,tp2=0;
        String s="";
        for(int j=0;j<f;j++)
        {if(j%2==0){
        if(j==0){
        c=arr.get(1);
        c2=arr.get(0);
        arrc.add(c2);
        arrc.add(c);
        s=s+"C";
        continue;
        }
        if(c==0){
            c=arr.get(j+1);
            c2=arr.get(j);
        arrc.add(c2);
        arrc.add(c);
            s=s+"C";
            continue;
        }
        
        if(k==0){
            k=arr.get(j+1);
            k2=arr.get(j);
            
            //System.out.println("ll3");
        arrj.add(k2);
        arrj.add(k);
        s=s+"J";
            continue;
        }
        if(((!arrc.contains(arr.get(j))||!arrc.contains(arr.get(j+1)))&&arr.get(j)>=c)||((!arrc.contains(arr.get(j))||!arrc.contains(arr.get(j+1)))&&(arr.get(j)<c2&&arr.get(j+1)<=c2)))
        {

            c=arr.get(j+1);
            c2=arr.get(j);
        arrc.add(c2);
        arrc.add(c);
        
            s=s+"C";
            continue;
        }
        
        if(((!arrj.contains(arr.get(j))||!arrj.contains(arr.get(j+1)))&&arr.get(j)>=k)||((!arrj.contains(arr.get(j))||!arrj.contains(arr.get(j+1)))&&(arr.get(j)<k2&&arr.get(j+1)<=k2)))
        {
            k=arr.get(j+1);
            k2=arr.get(j);
            arrj.add(k2);
        arrj.add(k);
            s=s+"J";
            continue;
        }
        
        s="IMPOSSIBLE";
        break;
        }
        
        }
        System.out.println("Case #"+i+": "+s);
            }
        }
        }