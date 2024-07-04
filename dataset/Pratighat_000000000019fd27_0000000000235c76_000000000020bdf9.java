import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution
 {
     public static void main(String[] args) throws IOException{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int t = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0;i<t;i++)
        {
            count++;
            ArrayList<Activity> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            int C=0,J=0;
            int cstrt = 0,jstart = 0;

            for(int j = 0;j<n;j++)
            {
                String[] line = br.readLine().split(" ");

                Activity a = new Activity();
                a.setStart(Integer.parseInt(line[0]));
                a.setEnd(Integer.parseInt(line[1]));
                list.add(a);
            }

              for(int p = 0;p<list.size()-1;p++)
            {
               if(p ==0){
                   list.get(p).setAssigedTo("C");
                   C = list.get(p).getEnd();
                   cstrt = list.get(p).getStart();
               }
               
                   if(list.get(p+1).getStart()<=list.get(p).getEnd())
                   {
                       if(C<=list.get(p+1).getStart())
                       {
                        list.get(p+1).setAssigedTo("C");
                        C = list.get(p+1).getEnd();
                       }else{
                           if(J<=list.get(p+1).getStart()){
                            list.get(p+1).setAssigedTo("J");
                            J = list.get(p+1).getEnd();
                           }
                       }

                       if(cstrt>=list.get(p+1).getStart()&&cstrt>=list.get(p+1).getEnd())
                       {
                        list.get(p+1).setAssigedTo("C");
                       }else{
                           if(jstart>=list.get(p+1).getStart()&&jstart>=list.get(p+1).getEnd())
                           {
                               list.get(p+1).setAssigedTo("J");
                           }
                       }
                      
                      
                   }
                   
                   
                   if(list.get(p+1).getStart()>=list.get(p).getEnd()){

                    if(C<=list.get(p+1).getStart())
                    {
                     list.get(p+1).setAssigedTo("C");
                     C = list.get(p+1).getEnd();
                    }else{
                        if(J<=list.get(p+1).getStart()){
                         list.get(p+1).setAssigedTo("J");
                         J = list.get(p+1).getEnd();
                        }
                    }
                   }
               
            }

            String ans = "";
            boolean flag = false;

         eachFor:   for (Activity activity : list) {

             if(activity.getAssigedTo()!=null)
             {
                ans = ans.concat(activity.getAssigedTo());
                
             }else{
                flag = true;
                System.out.println("case #"+count+": "+"IMPOSSIBLE");
                break eachFor;
                
             }
             
               
            }

            if(!flag)
            System.out.println("case #"+count+": "+ans);
           
        }

        br.close();

        
     }
 }



 class Activity
 {

    int start;
    int end;
    String assigedTo;


    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getAssigedTo() {
        return this.assigedTo;
    }

    public void setAssigedTo(String assigedTo) {
        this.assigedTo = assigedTo;
    }



 }