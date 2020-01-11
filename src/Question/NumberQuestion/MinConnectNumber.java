package Question.NumberQuestion;

public class MinConnectNumber {

    /*
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * Attention：注意我们可以比较两个数字两种组合的字典序，生成字典序较小的数字在这种比较方式下是较小的那个数
     * */
    public String printMinNumber(int[] numbers) {
        int len = numbers.length;
        MyInteger[] values = new MyInteger[len];
        for (int i = 0; i < len; i++) {
            values[i] = new MyInteger(numbers[i]);
        }
        sort(values);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(values[i].value);
        }
        return builder.toString();
    }

    private class MyInteger implements Comparable<MyInteger> {
        private String value;

        private MyInteger(int value) {
            if (value < 1)
                value = 1;
            this.value = value + "";
        }

        public String toString() {
            return value;
        }

        @Override
        public int compareTo(MyInteger o) {
            String combine1 = value + o.value;
            String combine2 = o.value + value;
            return combine1.compareTo(combine2);
        }


    }

    private <T extends Comparable<? super T>> void sort(T[] values) {
        int len = values.length;
        for (int i = 0; i < len; i++) {
            T min = values[i];
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (values[j].compareTo(min) < 0) {
                    index = j;
                    min = values[j];
                }
            }
            values[index] = values[i];
            values[i] = min;
        }
    }

}