public class App {
    public static void main(String[] args) throws Exception {
        int input = 4;
        int[] output = countBits(input);
        for(int n : output)  {
            System.out.println(n);
        }
    }

    public static int[] countBits(int n) {
        int sig = 1;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(i == sig * 2) sig = i;
            dp[i] = 1 + dp[i - sig];
        }
        return dp;
    }
}


// public class App {
//     public static void main(String[] args) throws Exception {
//         int input = 4;
//         int[] output = countBits(input);
//         for(int n : output)  {
//             System.out.println(n);
//         }
//     }

//     public static int[] countBits(int n) {
        
//         int[] output = new int[n + 1];
//         for(int i = 0; i <= n; i++) {
//             output[i] = countBinary1s(i);
//         }
//         return output;
//     }

//     public static int countBinary1s(int n) {
//         int ones = 0;
//         while(n > 0) {
//             if(n % 2 == 1) ones += 1; 
//             n /= 2;
//         }
//         return ones;
//     }
// }
