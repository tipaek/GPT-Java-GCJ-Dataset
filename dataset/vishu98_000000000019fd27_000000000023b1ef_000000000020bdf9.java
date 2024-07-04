import java.lang.*;
import java.util.*;
import java.io.*;
 class sch {


    public static void main(String[] args){
        BufferedReader br = new BufferedReader( 
            new InputStreamReader(System.in)); 
            try{

            
                    int tc=Integer.parseInt(br.readLine());        
                    int f=0;
                    int c=0;
                    int j=0;
                    int strt=0,end=0,prev_e=0;
                    for(int k=0;k<tc;k++){
                        f=0;
                        System.out.println("e");
                        String rs="";
                        int n = Integer.parseInt(br.readLine()); 
                        for(int i=0;i<n;i++){
                            String s[]=br.readLine().split(" ");
                            strt=Integer.parseInt(s[0]);
                            end=Integer.parseInt(s[1]);
                            if(f==0){
                                f=1;

                                c++;
                                rs=rs+"C";

                            }
                            else{
                                if(strt<prev_e){
                                    j++;
                                    rs=rs+"J";
                                }
                                else{
                                    c++;
                                    rs=rs+"C";

                                }
                            }
                            prev_e=end;

                        }
                       //// if(c!=2||j!=2){
                         //   System.out.println("IMP");

                        //}/
                       // else{
                            System.out.println("Case #"+rs);

                        //}
                    }
            }
            catch(Exception e){
                System.out.println(e);
            }
    }
       

}
        

  