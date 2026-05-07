import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio5 {

    static class Nodo {
        String dato;
        Nodo izq, der;
        Nodo(String v) { dato = v; }
    }

    // 1. PREORDEN — muestra menu principal primero (raiz -> izq -> der)
    static void preorden(Nodo r) {
        if (r == null) return;
        System.out.println(r.dato);
        preorden(r.izq);
        preorden(r.der);
    }

    // 2. POSTORDEN — procesa modulos internos antes que sus padres (izq -> der -> raiz)
    static void postorden(Nodo r) {
        if (r == null) return;
        postorden(r.izq);
        postorden(r.der);
        System.out.println(r.dato);
    }

    // 3. BFS — muestra modulos nivel por nivel
    static void bfs(Nodo raiz) {
        if (raiz == null) return;
        Queue<Nodo> q = new LinkedList<>();
        q.add(raiz);
        while (!q.isEmpty()) {
            Nodo a = q.poll();
            System.out.println(a.dato);
            if (a.izq != null) q.add(a.izq);
            if (a.der != null) q.add(a.der);
        }
    }

    public static void main(String[] args) {
        // Construir arbol del sistema web
        Nodo raiz      = new Nodo("Sistema Web");
        raiz.izq       = new Nodo("Usuarios");
        raiz.der       = new Nodo("Inventario");
        raiz.izq.izq   = new Nodo("Registrar");
        raiz.izq.der   = new Nodo("Buscar");
        raiz.der.izq   = new Nodo("Productos");
        raiz.der.der   = new Nodo("Reportes");

        System.out.println("=== 1. Menu principal (Preorden) ===");
        preorden(raiz);

        System.out.println("\n=== 2. Modulos internos primero (Postorden) ===");
        postorden(raiz);

        System.out.println("\n=== 3. Nivel por nivel (BFS) ===");
        bfs(raiz);
    }
}
/*
Explicacion de recorridos:
  Preorden  -> imprime "Sistema Web" primero (util para mostrar menu principal)
  Postorden -> imprime hojas (Registrar, Buscar...) antes que sus padres
  BFS       -> nivel 0: Sistema Web | nivel 1: Usuarios, Inventario | nivel 2: Registrar, Buscar, Productos, Reportes
*/
