import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution
 {

    static ArrayList<Range> rangeForC = new ArrayList<>();
    static  ArrayList<Range> rangeForJ = new ArrayList<>();
    static ArrayList<String> anslist = new ArrayList<>();
    static int diffC = 100000;
    static int diffJ = 100000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        
        anslist.clear();

        for (int i = 0; i < t; i++) {
            
            rangeForC.clear();
            rangeForJ.clear();
            diffC = 100000;
            diffJ = 100000;
            
            ArrayList<Activity> list = new ArrayList<>();
            
            int n = Integer.parseInt(br.readLine());

            Parent C = new Parent();
            Parent J = new Parent();
            C.setId(1);
            J.setId(2);

            for (int k = 0; k < n; k++) {
                String[] line = br.readLine().split(" ");

                Activity a = new Activity();
                a.setStart(Integer.parseInt(line[0]));
                a.setEnd(Integer.parseInt(line[1]));
                list.add(a);
            }

            
            for (Activity activity : list) {
                if (isAvail(C, activity.getStart(), activity.getEnd())){

                //    if((canBeOfj(activity.getStart(), activity.getEnd()))&&diffJ==0||diffJ<diffC){
                //      updateRangeV(activity.getStart(), activity.getEnd());
                //      activity.setAssigedTo("J*");

                //    }else{
                //     updateRangeC(activity.getStart(), activity.getEnd());
                //     activity.setAssigedTo("C");
                //    }
                updateRangeC(activity.getStart(), activity.getEnd());
                    activity.setAssigedTo("C");

                    
                } else {
                    if (isAvail(J, activity.getStart(), activity.getEnd())) {

                        if((canBeOfc(activity.getStart(), activity.getEnd()))&&diffC==0||diffC<diffJ){
                            updateRangeC(activity.getStart(), activity.getEnd());
                            activity.setAssigedTo("C");
                        }else{
                            updateRangeV(activity.getStart(), activity.getEnd());
                            activity.setAssigedTo("J");
                        }
                        
                    }
                }
            }

            String ans = "";
            boolean flag = false;

            eachFor: for (Activity activity : list) {

                if (activity.getAssigedTo() != null) {
                    ans = ans.concat(activity.getAssigedTo());

                } else {
                    flag = true;
                    anslist.add("IMPOSSIBLE");
                    break eachFor;

                }

            }

            if(!flag){
            anslist.add(ans);
            }

        }

        for (int r = 0;r<anslist.size();r++) {
            int next = r+1;
            System.out.println("Case #" +next+ ": " + anslist.get(r));    
        }

        // for(Range r :rangeForC)
        // {
        //     System.out.println("Start ="+r.getStart()+" End = "+r.getEnd());
        // }

        // System.out.println("Got J >>>>>>");
        // for(Range r :rangeForJ)
        // {
        //     System.out.println("Start ="+r.getStart()+" End = "+r.getEnd());
        // }


        br.close();

    }
    
    private static boolean canBeOfc(int start, int end) {
        boolean res = true;

        for (Range range : rangeForC) {
                
            if(start<range.getStart()&& end<=range.getStart()||start>=range.getEnd()&&end>range.getEnd())
           {
               res = true;
           }else{
               res = false;
               break;
           }
        }
        if(res&&rangeForC.size()>0){
          
            int max = 0;
            for (Range r: rangeForC) {
                if(max<r.getStart()-end)
                max = r.getStart()-end;
            }
            diffJ = max;
        }
        return res;
    }

    private static void updateRangeV(int start, int end) {
        Range r = new Range();
                r.setStart(start);
                r.setEnd(end);
                rangeForJ.add(r);
    }

    private static void updateRangeC(int start, int end) {
        Range r = new Range();
                 r.setStart(start);
                 r.setEnd(end);
                rangeForC.add(r);
    }

    private static boolean canBeOfj(int start, int end) {
        boolean res = true;

        for (Range range : rangeForJ) {
                
            if(start<range.getStart()&& end<=range.getStart()||start>=range.getEnd()&&end>range.getEnd())
           {
               res = true;
           }else{
               res = false;
               break;
           }
        }
        if(res&&rangeForJ.size()>0){//&&rangeForJ.size()>0
            int max = 0;
            for (Range r: rangeForJ) {
                if(max<r.getStart()-end)
                max = r.getStart()-end;
            }
            diffJ = max;
        }
        return res;
    }

    

    private static boolean isAvail(Parent j, int start, int end) {

        boolean res = true;

        if(j.getId()==1){


            for (Range range : rangeForC) {
    
               if(start<range.getStart()&& end<=range.getStart()||start>=range.getEnd()&&end>range.getEnd())
               {
                   res = true;
               }else{
                   res = false;
                   break;
               }
            
            }

        }
        if(j.getId() == 2)
        {
            for (Range range : rangeForJ) {
                
                if(start<range.getStart()&& end<=range.getStart()||start>=range.getEnd()&&end>range.getEnd())
               {
                   res = true;
               }else{
                   res = false;
                   break;
               }
            }
        }

    
        return res;
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

 class Parent{
     int id;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

 }

class Range{

    int start;
    int end;

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

 }

