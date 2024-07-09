package removeOccurance;

import java.util.Scanner;

public class RemoveOccurrences {
    public static String removeOccurrences(String str, String c) {
        // Find the first occurrence of the character
        int firstIndex = str.indexOf(c);
        // Find the last occurrence of the character
        int lastIndex = str.lastIndexOf(c);

        // If the character is not found, return the original string
        if (firstIndex == -1 || lastIndex == -1) {
            return str;
        }

        // Remove the first occurrence
        str = str.substring(0, firstIndex) + str.substring(firstIndex + 1);

        // Adjust the lastIndex after removing the first occurrence
        lastIndex--;

        // Remove the last occurrence
        str = str.substring(0, lastIndex) + str.substring(lastIndex + 1);

        return str;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String c = sc.next();
        String result = removeOccurrences(str, c);
        System.out.println(result); // Output: "jvajav"
    }
}

