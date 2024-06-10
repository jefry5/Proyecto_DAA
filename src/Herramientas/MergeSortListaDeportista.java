package Herramientas;

import Entidades.ListaDeportista;
import Entidades.NodoDeportista;
import java.io.Serializable;

public class MergeSortListaDeportista implements Serializable{

    public void mergeSort(ListaDeportista lista, int size) {
        if (lista == null || size < 2) {
            return;
        }

        int mid = size / 2;

        ListaDeportista listaIzq = new ListaDeportista();
        ListaDeportista listaDer = new ListaDeportista();

        NodoDeportista current = lista.getCabecera();
        for (int i = 0; i < mid; i++) {
            listaIzq.agregarDeportista(current.getDepor());
            current = current.getSiguiente();
        }

        while (current != null) {
            listaDer.agregarDeportista(current.getDepor());
            current = current.getSiguiente();
        }

        mergeSort(listaIzq, mid);
        mergeSort(listaDer, size - mid);

        merge(lista, listaIzq, listaDer);
    }

    public static void merge(ListaDeportista array, ListaDeportista leftArray, ListaDeportista rightArray) {
        array.setCabecera(null);
        array.setUltimo(null);

        NodoDeportista left = leftArray.getCabecera();
        NodoDeportista right = rightArray.getCabecera();

        while (left != null && right != null) {
            if (Integer.parseInt(left.getDepor().getDni_Deportista()) < Integer.parseInt(right.getDepor().getDni_Deportista())) {
                array.agregarDeportista(left.getDepor());
                left = left.getSiguiente();
            } else {
                array.agregarDeportista(right.getDepor());
                right = right.getSiguiente();
            }
        }

        while (left != null) {
            array.agregarDeportista(left.getDepor());
            left = left.getSiguiente();
        }

        while (right != null) {
            array.agregarDeportista(right.getDepor());
            right = right.getSiguiente();
        }
    }
}