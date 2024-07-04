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
            Busy c = new Busy();
            Busy j = new Busy();
            // int C=0,J=0;
            // int cstrt = 0,jstart = 0;

            for(int k = 0;k<n;k++)
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
                   c.setBusyFrom(list.get(p).getStart());
                   c.setBusyTo(list.get(p).getEnd());
                //    C = list.get(p).getEnd();
                //    cstrt = list.get(p).getStart();
               }
               
                   if(list.get(p+1).getStart()<=list.get(p).getEnd())
                   {
                       if(c.getBusyTo()<=list.get(p+1).getStart())
                       {
                        list.get(p+1).setAssigedTo("C");
                        c.setBusyTo(list.get(p+1).getEnd());
                       }else{
                           if(j.getBusyTo()<=list.get(p+1).getStart()){
                            list.get(p+1).setAssigedTo("J");
                            j.setBusyTo(list.get(p+1).getEnd()); 
                           }
                       }

                       if(c.getBusyFrom()>=list.get(p+1).getStart()&&c.getBusyFrom()>=list.get(p+1).getEnd() &&
                        c.isAvalable(list.get(p+1).getStart(),list.get(p+1).getEnd()) )
                       {
                        list.get(p+1).setAssigedTo("C");
                        
                       }else{
                           if(j.getBusyFrom()>=list.get(p+1).getStart()&&j.getBusyFrom()>=list.get(p+1).getEnd()&& 
                           j.isAvalable(list.get(p+1).getStart(),list.get(p+1).getEnd()))
                           {
                               list.get(p+1).setAssigedTo("J");
                           }
                       }
                      
                      
                   }
                   
                   
                   if(list.get(p+1).getStart()>=list.get(p).getEnd()){

                    if(c.getBusyTo()<=list.get(p+1).getStart())
                    {
                     list.get(p+1).setAssigedTo("C");
                     c.setBusyTo(list.get(p+1).getEnd());
                    }else{
                        if(j.getBusyTo()<=list.get(p+1).getStart()){
                         list.get(p+1).setAssigedTo("J");
                         j.setBusyTo(list.get(p+1).getEnd()); 
                        }
                    }

                    if(c.getBusyFrom()>=list.get(p+1).getStart()&&c.getBusyFrom()>=list.get(p+1).getEnd() &&
                        c.isAvalable(list.get(p+1).getStart(),list.get(p+1).getEnd()) )
                       {
                        list.get(p+1).setAssigedTo("C");
                        
                       }else{
                           if(j.getBusyFrom()>=list.get(p+1).getStart()&&j.getBusyFrom()>=list.get(p+1).getEnd()&& 
                           j.isAvalable(list.get(p+1).getStart(),list.get(p+1).getEnd()))
                           {
                               list.get(p+1).setAssigedTo("J");
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
                System.out.println("Case #"+count+": "+"IMPOSSIBLE");
                break eachFor;
                
             }
             
               
            }

            if(!flag)
            System.out.println("Case #"+count+": "+ans);
           
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

 class Busy{

    int busyFrom;
    int busyTo;

    public int getBusyFrom() {
        return this.busyFrom;
    }

    public void setBusyFrom(int busyFrom) {
        this.busyFrom = busyFrom;
    }

    public int getBusyTo() {
        return this.busyTo;
    }

    public void setBusyTo(int busyTo) {
        this.busyTo = busyTo;
    }

    public boolean isAvalable(int start,int end)
    {
        if(busyFrom<=start && busyTo<= end)
        return true;
        else
        return false;
    }


 }

