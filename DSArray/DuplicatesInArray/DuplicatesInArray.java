package DSArray.DuplicatesInArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicatesInArray {

    /**
     * Console output of below program
         -------Test Data------------
         Array elements::: 1 4 4 1 5 7 8 9 7
         Any Duplicates present?::: true
         The Duplicates are:: 1 4 7
         --------------Test Data ------------
         Array elements::: Alpha Beta Gamma Delta Set Alpha
         Any Duplicates present?::: true
         The Duplicates are:: Alpha
         -------Test Data ------------
         Array elements::: Ram Sita Rama
         Any Duplicates present?::: false
     * @param args: not in use
     */
    public static void main(String[] args) {

        System.out.println("-------Test Data------------");
        Object[] arr = {1, 4, 4, 1, 5,7,8,9,7};
        printArray(arr);
        System.out.println("Any Duplicates present?::: " + isDuplicatesPresent(arr));
        getDuplicates(arr);

        System.out.println("--------------Test Data ------------");
        Object[] arrString = {"Alpha", "Beta", "Gamma", "Delta", "Set", "Alpha"};
        printArray(arrString);
        System.out.println("Any Duplicates present?::: "+ isDuplicatesPresent(arrString));
        getDuplicates(arrString);

        System.out.println("-------Test Data ------------");
        Object[] arrStringUnique = {"Ram", "Sita", "Rama"};
        printArray(arrStringUnique);
        System.out.println("Any Duplicates present?::: "+ isDuplicatesPresent(arrStringUnique));
        getDuplicates(arrStringUnique);

    }

    private static void printArray(Object[] arrayToPrint) {
        System.out.print("Array elements::: ");
        for(Object obj: arrayToPrint) {
            System.out.print(obj+ " ");
        }
        System.out.println(" ");
    }
    /**
     * The method check if any duplicates present in an array of objects
     * Prints true if present
     * Prints false if not present
     * @param arrayToCheck: input array
     */
    public static boolean isDuplicatesPresent(Object[] arrayToCheck) {
        Set<Object> uniqueSet = new HashSet<>();
        for (Object o : arrayToCheck) {
            if (uniqueSet.contains(o)) return true;
            uniqueSet.add(o);
        }
        return false;
    }

    /**
     * The methods return the duplicates in an array
     * @param arrayToCheck : input array
     */
    public static void getDuplicates(Object[] arrayToCheck) {
        Map<Object, Integer> mapOfDuplicates = new HashMap<>();
        for (Object o : arrayToCheck) {
            mapOfDuplicates.put(o,
                    mapOfDuplicates.containsKey(o) ? mapOfDuplicates.get(o) + 1 : 0);
        }

        //Retain the duplicates in map and remove the unique elements
        mapOfDuplicates.entrySet().removeIf(entry-> entry.getValue() == 0);
        if(mapOfDuplicates.size()>0) {
            System.out.print("The Duplicates are:: ");
            for (Object s1 : mapOfDuplicates.keySet()) {
                System.out.print(s1+ " ");
            }
            System.out.println(" ");
        }

    }
}
