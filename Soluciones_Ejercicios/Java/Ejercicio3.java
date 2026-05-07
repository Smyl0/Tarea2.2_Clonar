public class Ejercicio3 {

    static class Nodo {
        int dato;
        Nodo izq, der;
        Nodo(int v) { dato = v; }
    }

    static Nodo insertar(Nodo raiz, int val) {
        if (raiz == null) return new Nodo(val);
        if (val < raiz.dato) raiz.izq = insertar(raiz.izq, val);
        else                 raiz.der = insertar(raiz.der, val);
        return raiz;
    }

    static int contarNodos(Nodo r) {
        if (r == null) return 0;
        return 1 + contarNodos(r.izq) + contarNodos(r.der);
    }

    public static void main(String[] args) {
        Nodo raiz = null;
        for (int v : new int[]{10, 5, 15, 2, 7, 12, 20})
            raiz = insertar(raiz, v);

        System.out.println("Total de nodos: " + contarNodos(raiz)); // 7
    }
}
