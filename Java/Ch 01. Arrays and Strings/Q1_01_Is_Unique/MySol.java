package Q1_01_Is_Unique;

import java.util.Arrays;

/**
 * my solution to the above problem
 * time O(n2) space O(1)
 */
public class MySol {

    public static void main(String[] args) {
        String[] str = {"hello", "abcde", "americr"};
        for (String word : str) {
            System.out.println(isUnique2(word) + " " + word);
        }
        //isUnique2("Zaebra");
    }

    static boolean isUnique(String str) {
        // since there are only 128 unique ASCII characters
        if (str.length() > 128) return false;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }

    // sort the alphabetaically in asciii order
    static boolean isUnique2(String str) {
        char[] ca = str.toCharArray();
        Arrays.sort(ca);
        String sortStr = new String(ca);
        System.out.println(sortStr);
        for (int i = 0; i < sortStr.length() - 1; i++) {
            if (sortStr.charAt(i) == sortStr.charAt(i + 1)) return false;
        }
        return true;
    }
}
