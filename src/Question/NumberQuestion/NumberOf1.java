package Question.NumberQuestion;

public class NumberOf1 {

    /**
     * @param n the input
     * @return the number of 1 of the input number's binary representation
     */
    public static int numberOf1(int n) {
        // attention: n may be a positive ot a negative, so you shouldn't move this number right
        // attention: you can use a flag, and move this flag left to count the number of 1 of input number
        int count = 0;
        // attention: you should use "!= 0" instead of "> 0" in java when refers to binary operations in Java
        // method 1: Time Complexity O(32)
//        int flag = 1;
//        while (flag != 0){
//            if ((n & flag) != 0)
//                count++;
//            flag = flag << 1;
//        }

        // method 2: Time Complexity O(count)
        while (n != 0) {
            count++;
            // attention: remove the most right 1 of n's binary representation
            n = (n - 1) & n;
        }

        return count;
    }

    public static void main(String[] args) {

    }

}