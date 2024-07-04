import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    Integer startTime;
    Integer finishTime;
    
    Time(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Time other) {
        return this.finishTime.compareTo(other.finishTime);
    }
}

class Person {
    String name;
    Time time;
    
    Person(String name, Time time) {
        this.name = name;
        this.time = time;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            System.out.println("Enter the number of intervals:");
            int intervals = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Time> timeObjects = new ArrayList<>();
            
            for (int j = 0; j < intervals; j++) {
                String[] input = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(input[0]);
                int finishTime = Integer.parseInt(input[1]);
                timeObjects.add(new Time(startTime, finishTime));
            }
            
            processInput(timeObjects, i + 1);
        }
        
        scanner.close();
    }

    private static void processInput(ArrayList<Time> timeObjects, int caseNumber) {
        Person personC = new Person("C", new Time(0, 0));
        Person personJ = new Person("J", new Time(0, 0));
        
        Collections.sort(timeObjects);
        
        StringBuilder result = new StringBuilder();
        int assignedTasks = 0;
        int totalTasks = timeObjects.size();
        
        for (Time currentTime : timeObjects) {
            if (currentTime.startTime >= personC.time.finishTime) {
                personC.time = currentTime;
                result.append("C");
                assignedTasks++;
            } else if (currentTime.startTime >= personJ.time.finishTime) {
                personJ.time = currentTime;
                result.append("J");
                assignedTasks++;
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}