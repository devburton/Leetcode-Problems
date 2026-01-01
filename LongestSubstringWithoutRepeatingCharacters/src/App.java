import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
class App {
    public static void main(String[] args) {
        String s = "xyztysykts";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int longestLengthSubstring = 0;
        int left = 0;
        if(s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            if(set.contains(c)) {
                while(set.contains(c)) {
                    set.remove(s.charAt(left));
                    left += 1;
                }
            } else {
                set.add(c);
                longestLengthSubstring = Math.max(longestLengthSubstring, right - left);
            }
        }
        return longestLengthSubstring;
    }

    /*public static int lengthOfLongestSubstring(String s) {
        int longestLengthSubstring = 1;
        LinkedHashSet<String> substring = new LinkedHashSet<>();
        int left = 0; 
        int right = 1;
        substring.add(s.substring(left, right));
        while(right <= s.length() + 1) {
            if(substring.add(s.substring(right, right + 1))) {
                right += 1;
            } else {
                String[] setAsArray = substring.toArray(new String[0]);
                int i = 0;
                while(!substring.add(s.substring(right, right + 1))) {
                    substring.remove(setAsArray[i]);
                    i++;
                }
                right += 1;
            }
                
            longestLengthSubstring = Math.max(longestLengthSubstring, right - left);
        }
        return longestLengthSubstring;
    }*/
}

