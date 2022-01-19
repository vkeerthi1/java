package com;

import java.util.Random;

public class QuickSort {
    public static void main(String args[]) {


        Random rand = new Random();
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        System.out.println("Before");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("after");
        printArray(numbers);


    }

    private static void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = new Random().nextInt(high - low) + low;
        //int pivot = numbers[high];
        int pivot = numbers[pivotIndex];
        swap(numbers, pivotIndex, high);
        int leftpointer = partition(numbers, low, high, pivot);
        quickSort(numbers, low, leftpointer - 1);
        quickSort(numbers, leftpointer + 1, high);
    }

    private static int partition(int[] numbers, int low, int high, int pivot) {
        int leftpointer = low;
        int rightpointer = high;

        while (leftpointer < rightpointer) {
            while (numbers[leftpointer] <= pivot && leftpointer < rightpointer) {
                leftpointer++;
            }
            while (numbers[rightpointer] >= pivot && leftpointer < rightpointer) {
                rightpointer--;
            }
            swap(numbers, leftpointer, rightpointer);
        }
        swap(numbers, leftpointer, high);
        return leftpointer;
    }

    private static void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
