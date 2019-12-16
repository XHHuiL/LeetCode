package Questions.FibonacciQuestions;

public class JumpFloor {

    /**
     * you can go up one or two steps at a time
     *
     * @param target the steps you want to climb
     * @return the number of ways to get this target
     */
    public static int jumpFloor(int target) {
        if (target < 1)
            return -1;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int a1 = 1;
        int a2 = 2;
        int temp = 0;
        for (int i = 3; i <= target; i++) {
            temp = a2;
            a2 = a1 + a2;
            a1 = temp;
        }
        return a2;
    }

    /**
     * you can go up one, two, ..., n steps at a time
     * @param target the steps you want to climb
     * @return the number of ways to get this target
     */
    public static int jumpFloorAbnormally(int target){
        // attention: we can get this formula: f(n) = f(n-1) + f(n-2) + ... + f(1) easily
        // attention: and we can see f(n-1) = f(n-2) + ... + f(1), so f(n) = 2f(n-1)
        // attention: due f(1) = 1, so f(n) = 2^(n-1), the question is calculate 2^(n-1)
        if (target < 1)
            return 0;
        return powPositiveExponent(2, target-1);
    }

    private static double pow(int base, int exponent){
        double result = powPositiveExponent(base, Math.abs(exponent));
        if (exponent < 0)
            result = 1 / result;
        return result;
    }

    private static int powPositiveExponent(int base, int exponent){
        // attention: you don't to judge the base, because the rate of base is 0 or 1 is very small
        // attention: so, if you add this judgement blow, the cost of other bases will increase
//        if (base == 0)
//            return 0;
//        if (base == 1)
//            return 1;
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        // attention: a^n = a^(n/2) * a^(n/2), n % 2 = 0
        // attention: a^n = a^(n/2) * a^(n/2) * a, n % 2 = 1
        // attention: you can use this formula and bit operations to simplify the calculation process
        int result = powPositiveExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1)
            result *= base;
        return result;
    }

}