import java.util.Random;

public class MergeSort {
    public static void main(String args[]) {


        Random rand = new Random();
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100000);
        }
        System.out.println("Before");
        printArray(numbers);
        mergeSort(numbers);

        System.out.println("after");
        printArray(numbers);


    }

    private static void mergeSort(int[] inputArr) {
        int inLength = inputArr.length;
        if (inLength < 2) {
            return;
        }
        int mid = inLength / 2;
        int[] leftarr = new int[mid];
        int[] rightarr = new int[inLength - mid];

        for (int i = 0; i < mid; i++) {
            leftarr[i] = inputArr[i];

        }
        for (int i = mid; i < inLength; i++) {
            rightarr[i - mid] = inputArr[i];
        }
        mergeSort(leftarr);
        mergeSort(rightarr);

        merge(inputArr,leftarr,rightarr);
    }

    private static void merge(int[] inputArr, int[] leftarr, int[] rightarr) {
        int leftSize = leftarr.length;
        int rightSize = rightarr.length;
        int i=0, j=0, k = 0;
        while (i < leftSize && j < rightSize) {
            if(leftarr[i] <= rightarr[j]){
                inputArr[k] = leftarr[i];
                i++;
            }
            else{
                inputArr[k] = rightarr[j];
                j++;
            }
            k++;
        }
        //
        while (i < leftSize) {
            inputArr[k] = leftarr[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            inputArr[k] = rightarr[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
