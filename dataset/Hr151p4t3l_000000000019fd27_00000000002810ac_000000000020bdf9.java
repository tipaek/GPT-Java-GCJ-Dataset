package com.noobCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        
        // if(input.hasNextInt()) {
        //     T = input.nextInt();
        // }

        outer :
            for(int i = 0; i < T; i++) {
                int N = input.nextInt();
                // if(input.hasNextInt()) {
                //     N = input.nextInt();
                // }

                int startTime = 0;
                int endTime = 0;
                List<Activity> activities = new ArrayList<>();
                Person J = new Person('J');
                Person C = new Person('C');

                for (int j = 0; j < N; j++) {
                    // if (input.hasNextInt()) {
                    //     startTime = input.nextInt();
                    // }
                    // if (input.hasNextInt()) {
                    //     endTime = input.nextInt();
                    // }
                    startTime = input.nextInt();
                    endTime = input.nextInt();
                    if(startTime > endTime) {
                        // break outer;
                        throw new Exception("D");
                    }
                    Activity newAct = new Activity(startTime, endTime);
                    // try {
                    //      newAct = new Activity(startTime, endTime);
                    // } catch (Exception e) {
                    //     System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
                    // }

                    if(j == 0) {
                        newAct.setPerson((i % 2 == 0 ? J : C));
                        J.assignedActivities.add(newAct);
                    }
                    else {
                        if(!newAct.doesConflictWithActivitiesOf(J)) {
                            newAct.setPerson(J);
                            J.assignedActivities.add(newAct);
                        }
                        else if(!newAct.doesConflictWithActivitiesOf(C)){
                            newAct.setPerson(C);
                            C.assignedActivities.add(newAct);
                        }
                        else if(newAct.doesConflictWithActivitiesOf(J) && newAct.doesConflictWithActivitiesOf(C)) {
                            System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
                            continue outer;
                        }
                    }
                    activities.add(newAct);
                }
                StringBuilder s = new StringBuilder();
                for(Activity act : activities) {
                    s.append(act.getPerson().getName());
                }
                System.out.println("Case #" + (i+1) + ": " + s);
            }
    }
}

class Person {
    private char name;
    List<Activity> assignedActivities;

    public Person(char name) {
        this.name = name;
        this.assignedActivities = new ArrayList<>();
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public List<Activity> getAssignedActivities() {
        return assignedActivities;
    }

    public void setAssignedActivities(List<Activity> assignedActivities) {
        this.assignedActivities = assignedActivities;
    }

    public boolean equals(Person p) {
        return (this.name == p.getName());
    }
}

class Activity {
    private int startTime;
    private int endTime;
    private Person person;

    public Activity(int startTime, int endTime) { // throws Exception {
        // if(startTime > endTime) {
        //     throw new Exception("EventStartingAfterItEnds");
        // }
        // if(startTime > (24*60) || endTime > (24*60)) {
        //     throw new Exception("ActivityStartOrEndTimeGreaterThan24hrs");
        // }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean doesConflictWithActivitiesOf(Person p) {
        if(p == null) {
            return false;
        }

        List<Activity> activitiesOfP = p.getAssignedActivities();
        for(Activity act : activitiesOfP) {
            if(this.doesConflictWith(act)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesConflictWith(Activity a) {
        if(a == null) {
            return false;
        }
        if(a.startTime > this.startTime && a.startTime < this.endTime) {
            return true;
        }
        if(a.startTime < this.startTime && a.startTime > this.endTime) {
            return false;
        }
        if(a.endTime < this.endTime && a.endTime > this.startTime) {
            return true;
        }
        if(a.endTime > this.endTime && a.endTime < this.startTime) {
            return false;
        }
        if(a.startTime < this.startTime && a.endTime > this.startTime) {
            return true;
        }
        if(a.startTime > this.startTime && a.endTime < this.startTime) {
            return true;
        }
        return false;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}