import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution
 {

    static ArrayList<Range> rangeForC = new ArrayList<>();
   static  ArrayList<Range> rangeForJ = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < t; i++) {
            count++;
            rangeForC.clear();
            rangeForJ.clear();
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
                if (isAvail(C, activity.getStart(), activity.getEnd())) {
                    activity.setAssigedTo("C");
                } else {
                    if (isAvail(J, activity.getStart(), activity.getEnd())) {
                        activity.setAssigedTo("J");
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
                    System.out.println("Case #" + count + ": " + "IMPOSSIBLE");
                    break eachFor;

                }

            }

            if(!flag)
            System.out.println("Case #" + count + ": " + ans);
            rangeForC.clear();
            rangeForJ.clear();

        }

        br.close();

    }

    private static boolean isAvail(Parent j, int start, int end) {

        boolean res = true;

        if(j.getId()==1){


            for (Range range : rangeForC) {
    
                if(end>range.getStart() && start<range.getStart()||start<range.getEnd()&& end>range.getEnd()||
                start>range.getStart()&&end<range.getEnd())
                {
                       res = false;
                }else
                res = true;
            
            }

        }
        if(j.getId() == 2)
        {
            for (Range range : rangeForJ) {
                
                if(end>range.getStart()&& start<range.getStart()||start<range.getEnd()&& end>range.getEnd()||
                start>range.getStart()&&end<range.getEnd())
                {
                        res = false;
                }else
                res = true;
            }
        }

    
        if(res == true)
        {
            if(j.getId() ==1)
            {
                Range r = new Range();
                r.setStart(start);
                r.setEnd(end);
                rangeForC.add(r);
            }
            if(j.getId() ==2)
            {
                Range r = new Range();
                r.setStart(start);
                r.setEnd(end);
                rangeForJ.add(r);
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

