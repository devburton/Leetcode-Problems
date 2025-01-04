class App {
    int[] values = new int[46];
    public int climbStairs(int n) {
        int returnValue = 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(values[n - 1] != 0) returnValue += values[n - 1];
        else returnValue += climbStairs(n - 1);
        if(values[n - 2] != 0) returnValue += values[n - 2];
        else returnValue += climbStairs(n - 2);
        values[n] = returnValue;
        return returnValue;
    }
}

// class App {
//     public int climbStairs(int n) {
//         if(n == 1) return 1;
//         if(n == 2) return 2;
//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }
// }