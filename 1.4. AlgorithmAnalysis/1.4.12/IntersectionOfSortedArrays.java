public class IntersectionOfSortedArrays {
    public static void intersection(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 =  arr2.length;
        int i = 0;
        int j = 0;

        boolean found = false;

        while (i < length1 && j < length2) {
            if (arr1[i] == arr2[j]) {
                int val = arr1[i];
                System.out.println(val + " ");
                found = true;

                while (i < length1 && arr1[i] == val) {
                    i++;
                }
                while (j < length2 && arr2[j] == val) {
                    j++;
                }
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        if (!found) {
            System.out.println("Không có giá trị trùng.");
        }
    }
}
