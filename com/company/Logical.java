package com.company;

public class Logical {

    private static <T> void swap(int[] arr, int index1, int index2) { // обмен элементов
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static int partition(int[] arr, int from, int to) { //разделение массива

        int leftIndex = from;
        int rightIndex = to;
        int pilot = arr[from]; // опорный элемент (первый элемент массива)
        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pilot) {
                leftIndex++;
            }
            while (arr[rightIndex] > pilot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                /** если не выполнятся два условия выше, то есть если элемент слева больше опорного,
                 а элемент справа меньше опрного, то мы меняем их местами и сдвигаем указатели */
                swap(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static int select(int[] arr, int left, int right, int k){
      int part = partition(arr, left, right);
      if(part == k-1){
          return arr[part];
      }
      if(part < k-1){
          return select(arr, part+1, left, k);
      }
      return select(arr, left, part -1, k);
    }

}
