package Herramientas;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumeroAleatorioRango {
    private int valorMinimo;
    private int valorMaximo;
    private Set<Integer> numerosUnicos;
    private Random random;
    
    public NumeroAleatorioRango(int _valorMinimo, int _valorMaximo){
        this.valorMinimo = _valorMinimo;
        this.valorMaximo = _valorMaximo;
        this.numerosUnicos = new HashSet();
        this.random = new Random();
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
        while (numerosUnicos.size() < cantidad) {
            int numeroAleatorio = valorMinimo + random.nextInt(valorMaximo - valorMinimo + 1);
            numerosUnicos.add(numeroAleatorio);
        }
        Integer[] arregloNumeros = numerosUnicos.toArray(new Integer[0]);
        System.out.println("ARREGLONUYMERO: "+arregloNumeros.length);
        
        int[] arregloNumerosInt = new int[arregloNumeros.length];
        for (int i = 0; i < arregloNumeros.length; i++) {
            arregloNumerosInt[i] = arregloNumeros[i];
        }    
      
        return arregloNumerosInt;
    }
}
