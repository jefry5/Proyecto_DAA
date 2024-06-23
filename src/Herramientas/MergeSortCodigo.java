package Herramientas;

import java.io.Serializable;

public class MergeSortCodigo implements Serializable{

    public void mergeSort(int[] array, int size) {
        if (array == null) {
            return;
        }
        if (size > 1) {
            int mid = size / 2;
            
            int indexIzq, indexDer;
            
            if(size%2==0){
                indexIzq = mid;
                indexDer = mid;
            }else{
                indexIzq = mid;
                indexDer = mid+1;
            }
            
            int[] leftArray = new int[mid];
            int[] rightArray = new int[size - mid];

            // Divide el array en dos partes
            System.arraycopy(array, 0, leftArray, 0, mid);
            System.arraycopy(array, mid, rightArray, 0, size - mid);

            // Llama recursivamente a mergeSort para ambas mitades
            mergeSort(leftArray,indexIzq);
            mergeSort(rightArray,indexDer);

            // Combina las mitades ordenadas
            merge(array, leftArray, rightArray);
        }
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = 0;

        // Combina los elementos de leftArray y rightArray en el array original
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                array[arrayIndex++] = leftArray[leftIndex++];
            } else {
                array[arrayIndex++] = rightArray[rightIndex++];
            }
        }

        // Copia los elementos restantes de leftArray (si los hay)
        while (leftIndex < leftArray.length) {
            array[arrayIndex++] = leftArray[leftIndex++];
        }

        // Copia los elementos restantes de rightArray (si los hay)
        while (rightIndex < rightArray.length) {
            array[arrayIndex++] = rightArray[rightIndex++];
        }
    }
}
