import java.util.*;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        String input= scanner.nextLine();
        int T = Integer.parseInt(input);
        for(int t=0;t<T;t++){

            boolean impossible = false;
            LinkedList<Integer[]> listOfActivities = new LinkedList<>();
            input = scanner.nextLine();
            int N = Integer.parseInt(input);
            char[] schedule = new char[N];
            for(int i=0;i<N;i++){
                String[] activityInput = scanner.nextLine().split(" ");
                Integer[] activity = new Integer[3];
                activity[0]= Integer.parseInt(activityInput[0]);
                activity[1]= Integer.parseInt(activityInput[1]);
                activity[2]=i;
                addInOrderFinish(listOfActivities, activity);

            }
            //printList(listOfActivities);

            LinkedList<Integer[]> cameronActivities = new LinkedList<>();
            LinkedList<Integer[]> jamiesActivities = new LinkedList<>();
            int end= listOfActivities.size();
            for(int i=0;i < end;i++){
                Integer[] activity = listOfActivities.poll();
                if(cameronActivities.isEmpty()){
                    cameronActivities.add(activity);
                    schedule[activity[2]]='C';
                }


                else if(!areOverlapped(cameronActivities, activity)){
                    cameronActivities.add(activity);
                    schedule[activity[2]]='C';
                }
                else if(jamiesActivities.isEmpty()){
                    jamiesActivities.add(activity);
                    schedule[activity[2]]='J';
                }
                else if(!areOverlapped(jamiesActivities, activity)){
                    jamiesActivities.add(activity);
                    schedule[activity[2]]='J';
                }
                else{
                    impossible= true;
                    break;

                }


            }
            if(!impossible){
                String resul = new String(schedule);
                System.out.println("Case #"+(t+1)+": "+resul);
            }
            else{
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            }



        }
    }

    private static void addInOrder(List<Integer[]> activities, Integer[] activity){
        ListIterator<Integer[]> iterator = activities.listIterator();
        boolean added = false;
        while(iterator.hasNext() && !added){
            if(activity[0]<iterator.next()[0]){
                iterator.previous();
                iterator.add(activity);
                added=true;
            }
        }
        if(activities.isEmpty() || !added){
            activities.add(activity);
        }

    }

    private static void addInOrderFinish(List<Integer[]> activities, Integer[] activity){
        ListIterator<Integer[]> iterator = activities.listIterator();
        boolean added = false;
        while(iterator.hasNext() && !added){
            if(activity[1]<iterator.next()[1]){
                iterator.previous();
                iterator.add(activity);
                added=true;
            }
        }
        if(activities.isEmpty() || !added){
            activities.add(activity);
        }

    }

    private static void printList(List<Integer[]> activities){
        ListIterator<Integer[]> iterator = activities.listIterator();
        while (iterator.hasNext()){
            Integer[] aux = iterator.next();
            System.out.println(aux[0] +" " +aux[1]+ " "+aux[2]);
        }
    }
    private static boolean areOverlapped(LinkedList<Integer[]> listOfActivities, Integer[] activity){
        boolean overlapped = false;
        Iterator<Integer[]> iterator= listOfActivities.iterator();
        while(iterator.hasNext() && !overlapped){
            overlapped= areOverlappedAux(iterator.next(), activity);
        }
        return overlapped;

    }


    private static boolean areOverlappedAux(Integer[] act1, Integer act2[]){
        //activity 1 starts first
        if(act1[0]<act2[0]){
            if(act2[0]<act1[1]){ //if activity 2 starts before activity 1 finishes
                return true;
            }
        }
        else if(act1[0] > act2[0]){// if activity 2 starts before activity 1
            if(act1[0]<act2[1]){ // and activity 1 starts before activity 2 finishes
                return true;
            }

        }
        else if(act1[0]== act2[0]){ // if they start at the same time
            return true;
        }

        return false;
    }





}
