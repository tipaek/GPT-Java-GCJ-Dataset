package com.company;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
public class Activities {
    String name=null;
    Time timeToStart=null;
    Time timeToEnd=null;
    Person person=null;
}

public class PossibleErrorsSolutions {
    public static int hourInsertions(){
        Scanner scanner=new Scanner(System.in);
        int hour;
        try{
         hour=scanner.nextInt();}
        catch (Exception e){
            System.out.println("please insert a number");
            hour =hourInsertions();
        }
        return hour;
    }
    public static String stringInserations(){
        Scanner scanner=new Scanner(System.in);
        String string;
            try{
                string=scanner.nextLine();
            }
            catch (Exception e){
                System.out.println("please insert a String");
                string =stringInserations();
            }
            if(string.equals(null)){
                System.out.println("please insert a String");
                string =stringInserations();
            }
            return string;
    }
    public static boolean reconsider(int a ,int b ,Activities activities){
        Boolean verification=false;
        if(a>b){
            activities.timeToEnd=new Time(a,0,0);
            activities.timeToStart=new Time(b,0,0);
            verification=true;
        }
        else{
            System.out.println("Please check again if the hours are corect");
            a=PossibleErrorsSolutions.reintroducingHours(a);
            b=PossibleErrorsSolutions.reintroducingHours(b);
            verification=PossibleErrorsSolutions.reconsider(a,b,activities);
        }
        return verification;
    }
    public static int reintroducingHours(int a){
        System.out.println("When do you want to start this activity?  ");
        a= PossibleErrorsSolutions.hourInsertions();
        return a;
    }
    public static boolean personAssigment(ArrayList<Activities> activitiesArrayList,Person person,Activities activities){
        boolean ver=false;
        int cursor=0;
        for(int i=0;i<activitiesArrayList.size();i++) {
        if(activitiesArrayList.get(i).name.equals(person.name)){
            if((activitiesArrayList.get(i).timeToStart.before(activities.timeToStart)&&activitiesArrayList.get(i).
                    timeToEnd.after(activities.timeToStart))||(activitiesArrayList.get(i).timeToStart.before(activities.
                    timeToEnd)&&activitiesArrayList.get(i).
                    timeToEnd.after(activities.timeToEnd))){
                cursor++;
            }
        }
        }
        if (cursor==0){
            ver=true;
        }
        return ver;
    }

public class Person {
     String name;
    public Person(String name){
        this.name=name;
    }
}

    }
    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("Please insert the number of activities for today: ");
    int N=scanner.nextInt();
    ArrayList<Activities> activityList=new ArrayList<>();
	Person Cameron=new Person("Cameron");
	Person Jamie=new Person("Jamie");
    for(int i=0;i<N;i++){
        Activities activities = new Activities();
        System.out.println("Please insert the name of the activity:");
        activities.name=PossibleErrorsSolutions.stringInserations();
        int hourToStart=0;
        int hourToEnd=0;

         System.out.println("When do you want to start this activity?  ");
         hourToStart= PossibleErrorsSolutions.hourInsertions();
         System.out.println("When do you want to end this activity? ");
         hourToEnd= PossibleErrorsSolutions.hourInsertions();
         Boolean reconsider=PossibleErrorsSolutions.reconsider(hourToEnd,hourToStart,activities);


        activityList.add(activities);
    }
    for(int i=0;i<activityList.size();i++) {
        System.out.println("Your '"+ i +"' activity "+"'" +activityList.get(i).name+ "' starts at "
                +activityList.get(i).timeToStart+" and ends at " +activityList.get(i).timeToEnd);
    }
        for(int i=0;i<activityList.size();i++) {
            System.out.println("You have to decide which person does the activity");
            System.out.println("Your '"+ i +"' activity "+"'" +activityList.get(i).name+ "' starts at "
                    +activityList.get(i).timeToStart+" and ends at " +activityList.get(i).timeToEnd);
            System.out.print("You can assign this avtivity to : ");
            boolean cameron=PossibleErrorsSolutions.personAssigment(activityList,Cameron,activityList.get(i));
            boolean jamie=PossibleErrorsSolutions.personAssigment(activityList,Jamie,activityList.get(i));
            if(cameron==true&&jamie==true){
                System.out.println("Cameron and Jamie");
                String personName=scanner.nextLine();
                if(Cameron.name.equals(personName)){
                activityList.get(i).person=Cameron;
                }
                else{
                    activityList.get(i).person=Jamie;
                }
            } else if(cameron==true&&jamie==false){
                System.out.println("Jamie");
                activityList.get(i).person=Cameron;
            }
            else if(cameron==false&&jamie==true){
                System.out.println("Jamie");
                activityList.get(i).person=Jamie;
            }
            else if(cameron==false&&jamie==false){
                System.out.println("you have no person to do this activity");
                activityList.get(i).person=null;
            }
        }
        for (int i=0;i<activityList.size();i++){
            System.out.println("Your '"+ i +"' activity "+"'" +activityList.get(i).name+ "' starts at "
                    +activityList.get(i).timeToStart+" and ends at " +activityList.get(i).timeToEnd+ " and is done by "+activityList.get(i).person.name);
        }
    }
    
}
