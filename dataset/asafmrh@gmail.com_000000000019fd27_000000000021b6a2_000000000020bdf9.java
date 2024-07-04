

import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0 ; i<t ; i++){
            int numOfActivities = Integer.parseInt(in.nextLine());
            List<AbstractMap.SimpleEntry<Integer, Integer>> activities = getActivities(in,numOfActivities);
            List<AbstractMap.SimpleEntry<Integer, Integer>> activitiesCopy = new ArrayList<>(activities);
            List<AbstractMap.SimpleEntry<Integer, Integer>> first = getPersonActivities(activitiesCopy);
            List<AbstractMap.SimpleEntry<Integer, Integer>> remains = getRemains(activities, first);
            if(isOverlap(remains)){
                System.out.println("Case #" + (i+1) +": IMPOSSIBLE");
            }
            else{
                formatOutPut(i+1,activities,first,remains);
            }

        }
    }

    public static void formatOutPut(int index, List<AbstractMap.SimpleEntry<Integer, Integer>> activities, List<AbstractMap.SimpleEntry<Integer, Integer>> first, List<AbstractMap.SimpleEntry<Integer, Integer>> second){
        System.out.print("Case #" + index + ": ");
        String res = "";
        for(int i = 0 ; i < activities.size(); i++){
            if(first.contains(activities.get(i))){
                res += "C";
            }
            else{
                res += "J";
            }
        }
        System.out.println(res);

    }

    public static boolean isOverlap(List<AbstractMap.SimpleEntry<Integer, Integer>> activities){
        for(int i = 0 ; i < activities.size(); i++){
            AbstractMap.SimpleEntry<Integer, Integer> temp = activities.get(i);
            for(int j = i+1 ; j < activities.size(); j++){
                AbstractMap.SimpleEntry<Integer, Integer> temp1 = activities.get(j);
                if(temp.getKey() < temp1.getValue() && temp.getValue() > temp1.getKey()){
                    return true;
                }
            }
        }
        return false;
    }

    public static List<AbstractMap.SimpleEntry<Integer, Integer>> getRemains(List<AbstractMap.SimpleEntry<Integer, Integer>> activities, List<AbstractMap.SimpleEntry<Integer, Integer>> first){
        List<AbstractMap.SimpleEntry<Integer, Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < activities.size() ; i++){
            if(!first.contains(activities.get(i))){
                res.add(activities.get(i));
            }
        }
        return res;
    }

    public static  List<AbstractMap.SimpleEntry<Integer, Integer>> getPersonActivities(List<AbstractMap.SimpleEntry<Integer, Integer>> activities){
        List<AbstractMap.SimpleEntry<Integer, Integer>> res = new ArrayList<>();
        while(activities.size() > 0){
            AbstractMap.SimpleEntry<Integer, Integer> chose = getEarlier(activities);
            activities.remove(chose);
            res.add(chose);
            removeAllInterrupts(activities, chose);
        }
        return res;
    }

    public static void removeAllInterrupts( List<AbstractMap.SimpleEntry<Integer, Integer>> activities, AbstractMap.SimpleEntry<Integer, Integer> choes){
        for(int i = 0; i < activities.size(); i++){
            AbstractMap.SimpleEntry<Integer, Integer> temp = activities.get(i);
            if(temp.getKey() < choes.getValue() && temp.getValue() > choes.getKey()){
                activities.remove(temp);
                i--;
            }
        }
    }

    public static AbstractMap.SimpleEntry<Integer,Integer> getEarlier(List<AbstractMap.SimpleEntry<Integer, Integer>> activities){
        int min = Integer.MAX_VALUE;
        AbstractMap.SimpleEntry<Integer, Integer> chose = activities.get(0);
        for(int i =0; i < activities.size(); i++){
            AbstractMap.SimpleEntry<Integer, Integer> temp = activities.get(i);
            if(temp.getValue() < min){
                chose =temp;
                min = temp.getValue();
            }
        }
        return chose;
    }

    public static List<AbstractMap.SimpleEntry<Integer, Integer>> getActivities(Scanner in, int numOfActivities){
        List<AbstractMap.SimpleEntry<Integer, Integer>> activities = new ArrayList<>();
        for(int i = 0 ; i < numOfActivities; i++){
            String[] line = in.nextLine().split(" ");
            activities.add(new AbstractMap.SimpleEntry<>(Integer.parseInt(line[0]),  Integer.parseInt(line[1])));
        }
        return activities;
    }


}


    