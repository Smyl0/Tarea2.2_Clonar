import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio1 {

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

    static void preorden(Nodo r) {
        if (r == null) return;
        System.out.print(r.dato + " ");
        preorden(r.izq);
        preorden(r.der);
    }

    static void inorden(Nodo r) {
        if (r == null) return;
        inorden(r.izq);
        System.out.print(r.dato + " ");
        inorden(r.der);
    }

    static void postorden(Nodo r) {
        if (r == null) return;
        postorden(r.izq);
        postorden(r.der);
        System.out.print(r.dato + " ");
    }

    static void bfs(Nodo raiz) {
        if (raiz == null) return;
        Queue<Nodo> q = new LinkedList<>();
        q.add(raiz);
        while (!q.isEmpty()) {
            Nodo act = q.poll();
            System.out.print(act.dato + " ");
            if (act.izq != null) q.add(act.izq);
            if (act.der != null) q.add(act.der);
        }
    }

    public static void main(String[] args) {
        Nodo raiz = null;
        int[] vals = {10, 5, 15, 2, 7, 12, 20};
        for (int v : vals) raiz = insertar(raiz, v);

        System.out.print("Preorden:  "); preorden(raiz);  System.out.println();
        System.out.print("Inorden:   "); inorden(raiz);   System.out.println();
        System.out.print("Postorden: "); postorden(raiz); System.out.println();
        System.out.print("BFS:       "); bfs(raiz);       System.out.println();
    }
}
