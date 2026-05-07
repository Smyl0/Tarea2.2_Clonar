public class Ejercicio4 {

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

    static int contarHojas(Nodo r) {
        if (r == null) return 0;
        if (r.izq == null && r.der == null) return 1; // es hoja
        return contarHojas(r.izq) + contarHojas(r.der);
    }

    public static void main(String[] args) {
        Nodo raiz = null;
        for (int v : new int[]{10, 5, 15, 2, 7, 12, 20})
            raiz = insertar(raiz, v);

        System.out.println("Hojas: " + contarHojas(raiz)); // 4: nodos 2, 7, 12, 20
    }
}
