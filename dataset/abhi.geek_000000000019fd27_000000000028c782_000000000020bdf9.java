import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input;
    int totalTestCases = -1, testCaseCounter = 1, totalActivities = -1, activitiesCounter = 0;
    String[] timeTokens = null;
    Activity[] activities = null;

    input = scan.nextLine().trim();
    totalTestCases = totalTestCases == -1 ? Integer.parseInt(input) : totalTestCases;

    while (testCaseCounter <= totalTestCases && scan.hasNextLine()) {
      input = scan.nextLine().trim();

      totalActivities = Integer.parseInt(input);

      activities = new Activity[totalActivities];

      while (activitiesCounter < totalActivities) {
        input = scan.nextLine().trim();

        timeTokens = input.split(" ");

        activities[activitiesCounter] = new Activity(Integer.parseInt(timeTokens[0]), Integer.parseInt(timeTokens[1]));
        ++activitiesCounter;
      }

      System.out.println("Case #" + testCaseCounter + ": " + allotActivities(activities));

      ++testCaseCounter;
      activitiesCounter = 0;
    }
  }

  private static String allotActivities(Activity[] activities) {
    StringBuilder result = new StringBuilder();
    Activity previous;
    boolean isActivityAdded = false;

    if(activities.length > 0) {
      LinkedList<Activity> jamieActivties = new LinkedList<>();
      LinkedList<Activity> cameronActivities = new LinkedList<>();

      for(Activity activity : activities) {
        if(jamieActivties.size() == 0) {
          jamieActivties.add(activity);
          result.append("J");
          isActivityAdded = true;
        } else {

          previous = jamieActivties.getFirst();
          for(int i = 1; i < jamieActivties.size(); i++) {
            if(activity.startTime < previous.startTime && activity.endTime <= previous.startTime) {
              jamieActivties.addFirst(activity);
              result.append("J");
              isActivityAdded = true;
              break;
            } else if(activity.startTime >= previous.endTime && activity.endTime <= jamieActivties.get(i).startTime) {
              jamieActivties.add(i, activity);
              result.append("J");
              isActivityAdded = true;
              break;
            } else if(activity.startTime >= jamieActivties.get(i).endTime) {
              jamieActivties.add(i+1, activity);
              result.append("J");
              isActivityAdded = true;
              break;
            }
            previous = jamieActivties.get(i);
          }

          if(!isActivityAdded && jamieActivties.size() == 1) {
            if(activity.endTime <= previous.startTime) {
              jamieActivties.addFirst(activity);
              result.append("J");
              isActivityAdded = true;
            } else if(activity.startTime >= previous.endTime) {
              jamieActivties.add(activity);
              result.append("J");
              isActivityAdded = true;
            }
          }

          if(!isActivityAdded) {
            if(cameronActivities.size() > 0) {
              previous = cameronActivities.getFirst();
              for (int i = 1; i < cameronActivities.size(); i++) {
                if (activity.startTime < previous.startTime && activity.endTime <= previous.startTime) {
                  cameronActivities.addFirst(activity);
                  result.append("C");
                  isActivityAdded = true;
                  break;
                } else if (activity.startTime >= previous.endTime && activity.endTime <= cameronActivities
                    .get(i).startTime) {
                  cameronActivities.add(i, activity);
                  result.append("C");
                  isActivityAdded = true;
                  break;
                } else if (activity.startTime >= cameronActivities.get(i).endTime) {
                  cameronActivities.add(i + 1, activity);
                  result.append("C");
                  isActivityAdded = true;
                  break;
                }
                previous = cameronActivities.get(i);
              }
            }
            if (!isActivityAdded && cameronActivities.size() == 0) {
              cameronActivities.add(activity);
              result.append("C");
              isActivityAdded = true;
            } else {
              if(activity.endTime <= previous.startTime) {
                cameronActivities.addFirst(activity);
                result.append("C");
                isActivityAdded = true;
              } else if(activity.startTime >= previous.endTime) {
                cameronActivities.add(activity);
                result.append("C");
                isActivityAdded = true;
              }
            }
          }
        }

        if(isActivityAdded) {
          isActivityAdded = false;
          previous = null;
        } else {
          result.delete(0, result.length());
          result.append("IMPOSSIBLE");
          break;
        }
      }
    }

    return result.toString();
  }

  private static class Activity {
    int startTime;
    int endTime;

    Activity(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }
}
