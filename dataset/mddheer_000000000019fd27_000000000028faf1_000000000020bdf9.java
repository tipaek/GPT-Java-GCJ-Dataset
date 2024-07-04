
import java.util.*;

class activity
{
    int starttime;
    int finishtime;
    int pos;
    public activity(int a,int b,int pos)
    {
        this.starttime=a;
        this.finishtime=b;
        this.pos=pos;
    }
    
}

public class Solution {

    static private Comparator<activity> sortingActvities;
    static {
        sortingActvities = new Comparator<activity>(){
            @Override
            public int compare(activity b1, activity b2){
             
                return Integer.compare(b1.finishtime,b2.finishtime);
            }
        };
    }
   
    
    
    public static ArrayList<activity> get_activities(activity activities[],int n)
    {
        Arrays.sort(activities,sortingActvities);
        int i=0;
        ArrayList<activity> resultarr=new ArrayList<>();
        resultarr.add(activities[i]);
        for (int j = 1; j < n; j++) 
        { 
            if (activities[j].starttime>= activities[i].finishtime) 
            {	
		resultarr.add(activities[j]);
		i = j; 
            }
        }
        return resultarr;
    }
    
    public static boolean confirmactivites(activity[] activities,ArrayList<activity> resultactivities)
    {
        ArrayList<activity> leftactvities=new ArrayList<>();
        
        for(activity act:activities)
        {
            if(!resultactivities.contains(act))
            {
                leftactvities.add(act);
            }
        }
        if(leftactvities.size()==0)
        {
            return true;
        }
        int finishtime=leftactvities.get(0).finishtime;
        for(int i=1;i<leftactvities.size();i++)
        {
            if(leftactvities.get(i).starttime<finishtime)
            {
                return false;
            }
            else
            {
                finishtime=leftactvities.get(i).starttime;
            }
            
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int numoftest=scan.nextInt();
        ArrayList<String> resultfinal=new ArrayList<>();
        for(int k=0;k<numoftest;k++)
        {   int n=scan.nextInt();
            activity activities[]=new activity[n];
            for(int i=0;i<n;i++)
            {
                int start=scan.nextInt();
                int finish=scan.nextInt();
                activities[i]=new activity(start,finish,i);
            }
            ArrayList<activity> answer= get_activities(activities,n);
            char resultarr[]=new char[n];
            for(activity act:answer)
            {
                resultarr[act.pos]='C';
            }
            for(int i=0;i<n;i++)
            {
                if(resultarr[i]!='C')
                {
                    resultarr[i]='J';
                }
            }
            boolean test=confirmactivites(activities,answer);
            if(test==false)
            {
                String testString="Case #"+Integer.toString(k+1)+": IMPOSSIBLE";
                resultfinal.add(testString);
            }
            else
            {    
                String resultString=String.valueOf(resultarr);
                String testString1="Case #"+Integer.toString(k+1)+":"+" "+resultString;
                resultfinal.add(testString1);
            }
        }
        for(String answertext:resultfinal)
        {
            System.out.println(answertext);
        }
    }
        
        
    }
    
