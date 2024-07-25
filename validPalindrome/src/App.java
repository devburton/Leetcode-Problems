public class App {
    public static void main(String[] args) throws Exception {
        String exampleStirng = "race a car";
        System.out.println(isPalindrome(exampleStirng));
    }

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int start = 0;
        int end = str.length() - 1;

        char[] strCharArray = str.toCharArray();
        for (; start < end; start++, end--) {
            while (!Character.isLetterOrDigit(strCharArray[start])) {
                if (start == strCharArray.length - 1) {
                    return true;
                }
                start++;
            }
            while (!Character.isLetterOrDigit(strCharArray[end])) {
                if (end == 0)
                    return true;
                end--;
            }
            if (strCharArray.length < 2)
                return true;
            if (strCharArray[start] != (strCharArray[end])) {
                return false;
            }

        }
        return true;
    }

    // public static boolean validPalindrome(String str) {
    // String cleanedStr = "";

    // for(char c : str.toCharArray()) {
    // if(Character.isLetterOrDigit(c)) {
    // cleanedStr += c;
    // }
    // }
    // int start = 0;
    // int end = cleanedStr.length() - 1;
    // for(; start < cleanedStr.length() - 1; start++, end--) {
    // if(cleanedStr.substring(start, start +
    // 1).equalsIgnoreCase(cleanedStr.substring(end, end + 1))) {
    // continue;
    // } else return false;
    // }
    // return true;
    // }

    // public static boolean validPalindrome(String str) {
    // str = str.replaceAll("[\\p{Punct}| ]", "");
    // int start = 0;
    // int end = str.length() - 1;

    // for(;start < str.length() - 1; start++, end--) {
    // String firstCharacter = str.substring(start, start + 1);
    // String lastCharacter = str.substring(end, end + 1);
    // if(str.substring(start, start + 1).equalsIgnoreCase(str.substring(end, end +
    // 1))) {
    // continue;
    // }
    // else {
    // return false;
    // }
    // }
    // return true;
    // }
}

// for odd go to length / 2 -

// start < lengh /2 - 1

// 9 check till 3
// 8 check till 3
// str.lenth - 1

// start >= str.length - 1