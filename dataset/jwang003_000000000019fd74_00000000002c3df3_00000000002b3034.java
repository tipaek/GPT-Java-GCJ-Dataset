import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());
        boolean possible = true;
        for (int i = 0; i < cases; i++) {
            boolean one = true;
            int patterns = Integer.parseInt(in.nextLine());
            String[] pattern = new String[patterns];
            for (int j = 0; j < patterns; j++) {
                pattern[j] = in.nextLine();
            }
            for (int j = 0; j < patterns; j++) {
                if (pattern[j].indexOf("*") == 0) {

                } else {
                    one = false;
                    break;
                }
            }
            if (one) {
                Arrays.sort(pattern, new java.util.Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        return s.length() - t1.length();
                    }
                });

                for (int j = 0; j < patterns - 1; j++) {
                    StringBuilder str = new StringBuilder();
                    str.append(pattern[j]); str.delete(0,1);
                    if (pattern[patterns - 1].contains(str)) {
                        continue;
                    } else {
                        possible = false;
                        break;
                    }
                }
                int caseNum = i + 1;
                if (possible) {
                    StringBuilder ans = new StringBuilder(); ans.append(pattern[pattern.length - 1]); ans.delete(0, 1);
                    System.out.println("Case #" + caseNum + ": " + ans.toString());
                } else {
                    System.out.println("Case #" + caseNum + ": *");
                }
            } else {
                LinkedList<String> name = new LinkedList<>();
                String[] characters = pattern[0].split("");
                for (int k = 0; k < characters.length; k++) {
                    if (k > 0) {
                        if (characters[k].equals("*") && characters[k-1].equals("*")) continue;
                    }
                    name.add(characters[k]);
                }

                for (int j = 1; j < pattern.length; j++) {
                    characters = pattern[j].split("");
                    boolean found = false;
                    if (characters[0].equals("*") && characters[characters.length - 1].equals("*")) {
                        for (int k = 0; k < name.size(); k++) {
                            if (name.get(k).equals("*")) {
                                found = true;
                                insert(name, characters, k, 0, 0);
                                break;
                            }
                        }
                        if (!found) possible = false;
                        if (!possible) break;
                    } else if (characters[0].equals("*") && !characters[characters.length - 1].equals("*")){
                        int counter = 1;
                        while (possible) {
                            if (characters[characters.length - counter].equals("*") && !name.get(name.size() - counter).equals("*")) {
                                //continue;
                            } else if (characters[characters.length - counter].equals("*") && name.get(name.size() - counter).equals("*")) {
                                insert(name, characters, name.size() - counter, counter, 0);
                            } else if (!characters[characters.length - counter].equals("*") && name.get(name.size() - counter).equals("*")) {
                                insert(name, characters, name.size() - counter, counter, 0);
                            } else if (characters[characters.length - counter].equals(name.get(name.size() - counter))) {
                                //continue;
                            } else {
                                possible = false;
                            }
                            counter--;
                            if (counter > characters.length) {
                                break;
                            }
                        }
                    } else if (!characters[0].equals("*") && characters[characters.length - 1].equals("*")) {
                        int counter = 0;
                        while (possible) {
                            if (characters[counter].equals("*") && !name.get(counter).equals("*")) {
                                //continue;
                            } else if (characters[counter].equals("*") && name.get(counter).equals("*")) {
                                insert(name, characters, counter, 0, counter);
                            } else if (!characters[counter].equals("*") && name.get(counter).equals("*")) {
                                insert(name, characters, counter, 0, counter);
                            } else if (characters[counter].equals(name.get(counter))) {
                                //continue;
                            } else {
                                possible = false;
                            }
                            counter++;
                            if (counter > characters.length) {
                                break;
                            }
                        }
                    } else {
                        if (characters[0].equals(name.get(0)) && characters[characters.length - 1].equals(name.get(name.size() - 1))) {

                            for (int k = 0; k < characters.length/2+1; k++) {
                                if (k == characters.length/2) {
                                    if (!characters[k].equals("*") && !name.get(k).equals("*") && !name.get(name.size()-k).equals("*")
                                            && !characters[k].equals(name.get(k)) && !characters[k].equals(name.get(name.size() - k))) possible = false;
                                } else {
                                    if (characters[k].equals(name.get(k))) {
                                        if (characters[k].equals("*")) {
                                            insert(name, characters, k, k, k);
                                        } else {
                                            continue;
                                        }
                                    }
                                    if (characters[k].equals("*") && !name.get(k).equals("*")) {
                                        continue;
                                    } else if (name.get(k).equals("*")) {
                                        insert(name, characters, k, k, k);
                                    } else {
                                        if (characters[characters.length - k].equals(name.get(name.size() - k))) {
                                            if (characters[characters.length - k].equals("*")) {
                                                insert(name, characters, name.size()-k, k, k+1);
                                            } else {
                                                continue;
                                            }
                                        }
                                        if (characters[characters.length - k].equals("*") && !name.get(name.size() - k).equals("*")) {
                                            continue;
                                        } else if (name.get(name.size() - k).equals("*")) {
                                            insert(name, characters, name.size()-k, k, k+1);
                                        } else {
                                            possible = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        } else {
                            possible = false;
                            break;
                        }
                    }
                }
                int caseNum = i + 1;
                if (possible) {
                    StringBuilder ans = new StringBuilder();
                    for (int j = 0; j < name.size(); j++) {
                        if (name.get(j).equals("*")) {
                            continue;
                        } else {
                            ans.append(name.get(j));
                        }
                    }
                    System.out.println("Case #" + caseNum + ": " + ans.toString());
                } else {
                    System.out.println("Case #" + caseNum + ": *");
                }
            }
        }
    }

    static LinkedList<String> insert(LinkedList<String> a, String[] b, int index, int counter, int start)
    {
        for (int m = start; m < b.length - counter; m++) {
            if (a.get(index+m-start).equals("*") && b[m].equals("*")) continue;

            a.add(index+m-start, b[m]);
        }
        return a;
    }


}
