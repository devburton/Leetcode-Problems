import java.util.HashMap;

class App {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        int windowSize = s1.length();

        // Initialize the first window
        for (int i = 0; i < windowSize; i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // Check first window
        if (map.equals(map2)) return true;

        // Sliding window
        for (int i = windowSize; i < s2.length(); i++) {
            char newChar = s2.charAt(i);
            char oldChar = s2.charAt(i - windowSize);

            // Add new character
            map2.put(newChar, map2.getOrDefault(newChar, 0) + 1);

            // Remove old character
            if (!map2.remove(oldChar, 1)) {
                map2.put(oldChar, map2.get(oldChar) - 1);
            }

            // Check if maps are equal
            if (map.equals(map2)) return true;
        }
        return false;
    }
}
