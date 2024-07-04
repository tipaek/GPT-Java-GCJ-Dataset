import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        int y=1;
         while(t-->0){
           
        String s=br.readLine();
            int a[]=new int[s.length()];
        for(int i=0; i<s.length(); i++) {
          a[i] = ((int)s.charAt(i))-48;
         // bw.write(a[i]+" ");
        }
        ArrayList<Integer> q=new ArrayList<>();
        
      
       int op=0,cl=0,p,qw;
        for(int i=0;i<s.length();i++){ 
            if(a[i]!=0){
            if(i==0){
                 p=a[i];
            
           //  System.out.print(p+"*");
            while(p>0){
                q.add(100);
                op++;
                p--;
            }
            // q.add(a[i]);
            }
            else{
              if(a[i]<a[i-1]){
                p=a[i-1]-a[i];
              // p=op-cl;
            while(p>0){
                q.add(200);
                cl++;
                p--;
            }
        }
            else if(a[i]==a[i-1]){}
              //  q.add(a[i]);
                
               else if(a[i]>a[i-1]){
              //else{
                    p=a[i]-a[i-1];
                     while(p>0){
                q.add(100);
                op++;
                p--;
            }
               }
            
            }
            // if(a[i+1]<a[i]){
               
              q.add(a[i]);   
            }
            else{
                if(i!=0){
                    p=op-cl;
                     while(p>0){
                q.add(200);
                cl++;
                p--;
                   }
                }
            q.add(a[i]);
           // System.out.println(q.get(q.size()-1)+"@");
            
        }
        }
       
        p=a[s.length()-1];
    //  p=op-cl;
         //System.out.println(p+"@");
                   while(p>0){
                q.add(200);
                p--;
                   }
        System.out.print("Case #"+y+":"+" ");
           // y++;
           int g=q.size();
        //  System.out.print("g "+g+"\n");
        for(int i=0;i<q.size();i++){
           int qp=q.get(i);
           if(qp==100){
           System.out.print("(");
           }
            else if(qp==200){
            System.out.print(")");
            }
            else{
            System.out.print(qp);
            }
        }
         System.out.print("\n");
           y++;          

        }
        bw.flush();
    }
}
        
