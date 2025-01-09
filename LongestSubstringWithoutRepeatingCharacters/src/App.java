import java.util.LinkedHashSet;
class App {
    public static void main(String[] args) {
        String s = "xyzx";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
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
    }
}

