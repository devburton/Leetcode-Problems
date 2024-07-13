import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] input = {"cat", "bat" , "tas", "rat" , "sat"};
        System.out.println(Solution.groupAnagrams(input));

    }
}

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> returnArray = new ArrayList<List<String>>();
        HashMap<String, List<String>> formattedInput = new HashMap<String, List<String>>();

        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            str = new String(charArray);

            if(formattedInput.containsKey(str)) {
                formattedInput.get(str).add(strs[i]);
                formattedInput.put(str, formattedInput.get(str));
                formattedInput.put(str, formattedInput.get(str));
            } else {
                ArrayList<String> originalStringsMatched = new ArrayList<>();
                originalStringsMatched.add(strs[i]);
                formattedInput.put(str, originalStringsMatched);
            }
        }
        for(String key : formattedInput.keySet()) {
            returnArray.add(formattedInput.get(key));
        }
        return returnArray;
    }
}
