import java.util.*;
import java.io.*;
import java.lang.Math; 


public class Solution {
    
     public static void solve(int n, int d,ArrayList<Double> arr,int t)
     {
         
         Collections.sort(arr);
         
         int i=0;
         int freq=0;
         int  maxfreq=0;
         double fu=0;
         int condition=0;
         while (i<n){
             
             double val=arr.get(i);
             freq=Collections.frequency(arr,val);
             
             if (freq>=d){
                 System.out.println("Case #" + t + ": " + "0");
                 condition=1;
                 break;
             }
             
             if (freq>maxfreq){
                 maxfreq=freq;
                 fu=arr.get(i);
             }
             if(freq==maxfreq){
                 if (arr.get(i)<fu){
                     fu=arr.get(i);
                 }
             }
             
             i=i+freq;
             
         }
         int res=0;
         int cuts=0;
         if (condition==0){
             
             if (maxfreq>1){
                 res=maxfreq;
                 
                 for (int j=0;j<n;j++){
                     if (arr.get(j)!=fu){
                         if (arr.get(j)>fu){
                             int aa = (int)(arr.get(j)/fu);
                             if (((arr.get(j)%fu)==0)&&(aa<=(d-res))){
                                 
                                     res=res+aa;
                                     cuts=aa-1+cuts;
                                 
                             }
                             
                             if(d==res){
                                 System.out.println("Case #" + t + ": " + cuts);
                             }
                         }
                     }
                 }
                 
                 if (d>res){
                     
                     
                     for (int j=0;j<n;j++){
                        if (arr.get(j)!=fu){
                          if (arr.get(j)>fu){
                             int aa = (int)(arr.get(j)/fu);
                             if (((arr.get(j)%fu)==0)&&(aa>(d-res))){
                                 
                                     res=d;
                                     cuts=aa+cuts;
                                 
                             }
                             
                             if(d==res){
                                 System.out.println("Case #" + t + ": " + cuts);
                             }
                         }
                     }
                    }
                 
                 }
                 
                 if (d>res){
                     
                     for (int j=0;j<n;j++){
                        if (arr.get(j)!=fu){
                          if (arr.get(j)>fu){
                             int aa =(int) (arr.get(j)/fu);
                             if ((arr.get(j)%fu)!=0){
                                    if (aa>(d-res)){
                                        cuts=cuts+(d-res);
                                        res=d;
                                    }
                                    else{
                                       res=res+aa;
                                       cuts=aa+cuts; 
                                    }
                                     
                                 
                             }
                             
                             if(d==res){
                                 System.out.println("Case #" + t + ": " + cuts);
                             }
                         }
                     }
                    }
                     
                 }
                 
                 
                
                 
             }
             
             else if ((maxfreq==1)||(d>res)){
				 fu = arr.get(0);
				 
				 
				 res=maxfreq;
                 
                 for (int j=0;j<n;j++){
                     if (arr.get(j)!=fu){
                         if (arr.get(j)>fu){
                             int aa = (int)(arr.get(j)/fu);
                             if (((arr.get(j)%fu)==0)&&(aa<=(d-res))){
                                 
                                     res=res+aa;
                                     cuts=aa-1+cuts;
                                 
                             }
                             
                             if(d==res){
                                 System.out.println("Case #" + t + ": " + cuts);
                             }
                         }
                     }
                 }
                 
                 if (d>res){
                     
                     
                     for (int j=0;j<n;j++){
                        if (arr.get(j)!=fu){
                          if (arr.get(j)>fu){
                             int aa = (int)(arr.get(j)/fu);
                             if (((arr.get(j)%fu)==0)&&(aa>(d-res))){
                                 
                                     res=d;
                                     cuts=aa+cuts;
                                 
                             }
                             
                             if(d==res){
                                 System.out.println("Case #" + t + ": " + cuts);
                             }
                         }
                     }
                    }
                 
                 }
                 
                 if (d>res){
                     
                     for (int j=0;j<n;j++){
                        if (arr.get(j)!=fu){
                          if (arr.get(j)>fu){
                             int aa = (int)(arr.get(j)/fu);
                             if ((arr.get(j)%fu)!=0){
                                    if (aa>(d-res)){
                                        cuts=cuts+(d-res);
                                        res=d;
                                    }
                                    else{
                                       res=res+aa;
                                       cuts=aa+cuts; 
                                    }
                                     
                                 
                             }
                             
                             if(d==res){
                                 System.out.println("Case #" + t + ": " + cuts);
                             }
                         }
                     }
                    }
                     
                 }
					 
					 
			 }
             
             
         }
        
            
     }
    
     public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); 
            int d = in.nextInt(); 
            
            ArrayList<Double> a=new ArrayList<Double>();
            
            for (int j=0;j<n;j++){
                double p1 = in.nextDouble(); 
                a.add(p1);
            }
            
            solve(n,d,a,i);
          
        }
      }
}
