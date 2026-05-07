#include <iostream>
#include <queue>
#include <string>
using namespace std;

struct Nodo {
    string dato;
    Nodo* izq;
    Nodo* der;
    Nodo(string v) : dato(v), izq(nullptr), der(nullptr) {}
};

// 1. PREORDEN — muestra menu principal primero (raiz -> izq -> der)
void preorden(Nodo* r) {
    if (!r) return;
    cout << r->dato << endl;
    preorden(r->izq);
    preorden(r->der);
}

// 2. POSTORDEN — procesa modulos internos antes que sus padres (izq -> der -> raiz)
void postorden(Nodo* r) {
    if (!r) return;
    postorden(r->izq);
    postorden(r->der);
    cout << r->dato << endl;
}

// 3. BFS — muestra modulos nivel por nivel
void bfs(Nodo* raiz) {
    if (!raiz) return;
    queue<Nodo*> q;
    q.push(raiz);
    while (!q.empty()) {
        Nodo* a = q.front(); q.pop();
        cout << a->dato << endl;
        if (a->izq) q.push(a->izq);
        if (a->der) q.push(a->der);
    }
}

int main() {
    // Construir arbol del sistema web
    Nodo* raiz       = new Nodo("Sistema Web");
    raiz->izq        = new Nodo("Usuarios");
    raiz->der        = new Nodo("Inventario");
    raiz->izq->izq   = new Nodo("Registrar");
    raiz->izq->der   = new Nodo("Buscar");
    raiz->der->izq   = new Nodo("Productos");
    raiz->der->der   = new Nodo("Reportes");

    cout << "=== 1. Menu principal (Preorden) ===" << endl;
    preorden(raiz);

    cout << "\n=== 2. Modulos internos primero (Postorden) ===" << endl;
    postorden(raiz);

    cout << "\n=== 3. Nivel por nivel (BFS) ===" << endl;
    bfs(raiz);

    return 0;
}
/*
Explicacion de recorridos:
  Preorden  -> imprime "Sistema Web" primero (util para mostrar menu principal)
  Postorden -> imprime hojas (Registrar, Buscar...) antes que sus padres
  BFS       -> nivel 0: Sistema Web | nivel 1: Usuarios, Inventario | nivel 2: Registrar, Buscar, Productos, Reportes
*/
