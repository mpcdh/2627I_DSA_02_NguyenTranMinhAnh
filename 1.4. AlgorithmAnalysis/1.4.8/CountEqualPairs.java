import java.util.Arrays;

public class CountEqualPairs {
    public static int countEqualPairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        Arrays.sort(arr);

        int total = 0;
        int length = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                length++;
            } else {
                if (length > 1) {
                    total += length * (length - 1) / 2;
                }
                length = 1;
            }
        }

        if (length > 1) {
            total += length * (length - 1) / 2;
        }

        return total;
    }
}
