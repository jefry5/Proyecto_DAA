package Herramientas;

import java.util.Random;

public class NumeroAleatorioRango {
    private int valorMinimo;
    private int valorMaximo;
    private Random random;
    private boolean[] hashTable;
    
    public NumeroAleatorioRango(int _valorMinimo, int _valorMaximo){
        this.valorMinimo = _valorMinimo;
        this.valorMaximo = _valorMaximo;
        this.random = new Random();
        this.hashTable = new boolean[_valorMaximo - _valorMinimo + 1];
    }
    
    public int generarAleatorio(){
        if (valorMinimo > valorMaximo) {
            throw new IllegalArgumentException("El valor mínimo no puede ser mayor que el valor máximo.");
        }
        return valorMinimo + random.nextInt(valorMaximo - valorMinimo + 1);
    }
    
    public int[] generarAleatoriosSinRepetir(int cantidad){
        if (cantidad > (valorMaximo - valorMinimo + 1)) {
            throw new IllegalArgumentException("La cantidad solicitada excede el rango de números únicos disponibles.");
        }
        
        // Reiniciar la tabla de dispersión para asegurar que esté vacía
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = false;
        }
        
        int[] arregloNumerosInt = new int[cantidad];
        int count = 0;
        
        while (count < cantidad) {
            int numeroAleatorio = valorMinimo + random.nextInt(valorMaximo - valorMinimo + 1);
            int index = numeroAleatorio - valorMinimo;
            
            if (!hashTable[index]) {
                hashTable[index] = true;
                arregloNumerosInt[count++] = numeroAleatorio;
            }
        }
      
        return arregloNumerosInt;
    }
}