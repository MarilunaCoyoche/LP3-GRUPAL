
// PruebaMetodoGenerico.java
public class PruebaMetodoGenerico {

    // Método genérico para imprimir todo el arreglo
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        // Muestra los elementos del arreglo
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }

    // Sobrecarga del método imprimirArreglo
    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) throws InvalidSubscriptException {
        // Validar índices
        if (subindiceInferior < 0 || subindiceSuperior < 0 || 
            subindiceSuperior >= arregloEntrada.length || 
            subindiceSuperior < subindiceInferior) {
            throw new InvalidSubscriptException("Índices fuera de rango o inválidos.");
        }

        // Imprimir solo la parte del arreglo dentro de los índices indicados
        int count = 0;
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            count++;
        }
        System.out.println();
        return count; // Retorna la cantidad de elementos impresos
    }

    public static void main(String[] args) {
        // Crea arreglos de objetos Integer, Double y Character
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};

        // Imprime todos los arreglos
        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger); // pasa un arreglo Integer

        System.out.println("\nEl arreglo arregloDouble contiene:");
        imprimirArreglo(arregloDouble); // pasa un arreglo Double

        System.out.println("\nEl arreglo arregloCharacter contiene:");
        imprimirArreglo(arregloCharacter); // pasa un arreglo Character

        // Prueba del método sobrecargado
        try {
            System.out.println("\nImprimiendo una parte del arreglo Integer:");
            int elementosImpresos = imprimirArreglo(arregloInteger, 1, 4); // Imprime desde el índice 1 al 4
            System.out.printf("Cantidad de elementos impresos: %d\n", elementosImpresos);

            System.out.println("\nImprimiendo una parte del arreglo Double:");
            elementosImpresos = imprimirArreglo(arregloDouble, 2, 5); // Imprime desde el índice 2 al 5
            System.out.printf("Cantidad de elementos impresos: %d\n", elementosImpresos);

            // Intento con índices inválidos
            System.out.println("\nIntentando imprimir con índices inválidos:");
            imprimirArreglo(arregloCharacter, -1, 2); // Esto lanzará una excepción

            // Otro intento con índices inválidos (superior menor que inferior)
            imprimirArreglo(arregloInteger, 4, 2); // Esto también lanzará una excepción

            // Intento con índice superior fuera de rango
            imprimirArreglo(arregloDouble, 3, 10); // Esto lanzará una excepción

        } catch (InvalidSubscriptException e) {
            System.err.println(e.getMessage());
        }
    } // fin de main
} // fin de la clase PruebaMetodoGenerico