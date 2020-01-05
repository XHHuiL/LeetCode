package Algorithm.SortAlgorithm.ExternalSort;

import Algorithm.Util.RandomNumberGenerator;
import org.junit.Test;

import java.io.IOException;

public class BucketSortTest {

    @Test
    public void testSort() throws IOException {
        RandomNumberGenerator.generatePositiveNumber("data/bucket.in", 0, 10000, 200000);
        BucketSort.sort("data/bucket.in", "data/bucket.out", 10000, 1000);
    }
}