import javafx.util.Pair;

import java.util.*;
import java.io.*;

class Solution {
    
    public class Pair<K, V> {

    private final K element0;
    private final V element1;

    public static <K, V> Pair<K, V> createPair(K element0, V element1) {
        return new Pair<K, V>(element0, element1);
    }

    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public K getKey() {
        return element0;
    }

    public V getValue() {
        return element1;
    }

}
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0 ; i<t ; i++){
            int numOfActivities = Integer.parseInt(in.nextLine());
            List<Pair<Integer, Integer>> activities = getActivities(in,numOfActivities);
            List<Pair<Integer, Integer>> activitiesCopy = new ArrayList<>(activities);
            List<Pair<Integer, Integer>> first = getPersonActivities(activitiesCopy);
            List<Pair<Integer, Integer>> remains = getRemains(activities, first);
            if(isOverlap(remains)){
                System.out.println("Case #" + (i+1) +": IMPOSSIBLE");
            }
            else{
                formatOutPut(i+1,activities,first,remains);
            }

        }
    }

    public static void formatOutPut(int index, List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> first, List<Pair<Integer, Integer>> second){
        System.out.print("Case #" + index + ": ");
        String res = "";
        for(int i = 0 ; i < activities.size(); i++){
            if(first.contains(activities.get(i))){
                res += "J";
            }
            else{
                res += "C";
            }
        }
        System.out.println(res);

    }

    public static boolean isOverlap(List<Pair<Integer, Integer>> activities){
        for(int i = 0 ; i < activities.size(); i++){
            Pair<Integer, Integer> temp = activities.get(i);
            for(int j = i+1 ; j < activities.size(); j++){
                Pair<Integer, Integer> temp1 = activities.get(j);
                if(temp.getKey() < temp1.getValue() && temp.getValue() > temp1.getKey()){
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Pair<Integer, Integer>> getRemains(List<Pair<Integer, Integer>> activities, List<Pair<Integer, Integer>> first){
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < activities.size() ; i++){
            if(!first.contains(activities.get(i))){
                res.add(activities.get(i));
            }
        }
        return res;
    }

    public static  List<Pair<Integer, Integer>> getPersonActivities(List<Pair<Integer, Integer>> activities){
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        while(activities.size() > 0){
            Pair<Integer, Integer> chose = getEarlier(activities);
            activities.remove(chose);
            res.add(chose);
            removeAllInterrupts(activities, chose);
        }
        return res;
    }

    public static void removeAllInterrupts( List<Pair<Integer, Integer>> activities, Pair<Integer, Integer> choes){
        for(int i = 0; i < activities.size(); i++){
            Pair<Integer, Integer> temp = activities.get(i);
            if(temp.getKey() < choes.getValue() && temp.getValue() > choes.getKey()){
                activities.remove(temp);
                i--;
            }
        }
    }

    public static Pair<Integer,Integer> getEarlier(List<Pair<Integer, Integer>> activities){
        int min = Integer.MAX_VALUE;
        Pair<Integer, Integer> chose = activities.get(0);
        for(int i =0; i < activities.size(); i++){
            Pair<Integer, Integer> temp = activities.get(i);
            if(temp.getValue() < min){
                chose =temp;
                min = temp.getValue();
            }
        }
        return chose;
    }

    public static List<Pair<Integer, Integer>> getActivities(Scanner in, int numOfActivities){
        List<Pair<Integer, Integer>> activities = new ArrayList<>();
        for(int i = 0 ; i < numOfActivities; i++){
            String[] line = in.nextLine().split(" ");
            activities.add(new Pair<>(Integer.parseInt(line[0]),  Integer.parseInt(line[1])));
        }
        return activities;
    }


}


    