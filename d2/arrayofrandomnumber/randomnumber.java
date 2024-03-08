import java.util.Random;

class IntegerMinMax {
    public static void main(String args[]) {
        // Generate random array
        int[] array = generateRandomArray(1000);

        // Generate a random index within the range of the array
        Random random = new Random();
        int randomIndex = random.nextInt(array.length);

        // The number to search for is the value at the random index of the array
        int numberToSearch = array[randomIndex];

        // Measure the time taken to execute getRandomMaxMin() method
        long startTime = System.nanoTime();
        int[] maxMinValues = getRandomMaxMin(array);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        //max and min values and the time taken
        System.out.println("Max value is: " + maxMinValues[0]);
        System.out.println("Min value is: " + maxMinValues[1]);
        System.out.println("Total time taken: " + totalTime + " nanoseconds");

        // Measure the time taken to execute binarySearch
        startTime = System.nanoTime();
        int index = binarySearch(array, numberToSearch);
        endTime = System.nanoTime();
        totalTime = endTime - startTime;

        // index of the number found and the time taken
        System.out.println("Number searched for in binary search: " + numberToSearch);
        System.out.println("Total time taken for binary search: " + totalTime + " nanoseconds");

    //     if (index != -1) {
    //         System.out.println("Number " + numberToSearch + " found at index: " + index);
    //     } else {
    //         System.out.println("Number " + numberToSearch + " not found in the array.");
    //     }
    // }
    }

    // Method to generate a random array
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    // Method to find maximum and minimum values in the array
    public static int[] getRandomMaxMin(int[] array) {
        int max = array[0];
        int min = array[0];

        // Find the maximum and minimum elements in the array
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Return max and min values in an array
        return new int[]{max, min};
    }

    // Binary search method
    private static int binarySearch(int[] numArray, int number_to_search_for) {
        int low = 0;
        int high = numArray.length - 1;

        while (low <= high) {
            int middleIndex = (low + high) / 2;
            int middleIndexNumber = numArray[middleIndex];

            if (number_to_search_for == middleIndexNumber) {
                return middleIndex;
            }
            if (number_to_search_for < middleIndexNumber) {
                high = middleIndex - 1;
            }
            if (number_to_search_for > middleIndexNumber) {
                low = middleIndex + 1;
            }
        }
        return -1;

 
    }
}
