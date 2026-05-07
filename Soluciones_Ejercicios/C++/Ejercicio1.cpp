#include <iostream>
#include <queue>
using namespace std;

struct Nodo {
    int dato;
    Nodo* izq;
    Nodo* der;
    Nodo(int v) : dato(v), izq(nullptr), der(nullptr) {}
};

Nodo* insertar(Nodo* raiz, int val) {
    if (!raiz) return new Nodo(val);
    if (val < raiz->dato) raiz->izq = insertar(raiz->izq, val);
    else                  raiz->der = insertar(raiz->der, val);
    return raiz;
}

void preorden(Nodo* r) {
    if (!r) return;
    cout << r->dato << " ";
    preorden(r->izq);
    preorden(r->der);
}

void inorden(Nodo* r) {
    if (!r) return;
    inorden(r->izq);
    cout << r->dato << " ";
    inorden(r->der);
}

void postorden(Nodo* r) {
    if (!r) return;
    postorden(r->izq);
    postorden(r->der);
    cout << r->dato << " ";
}

void bfs(Nodo* raiz) {
    if (!raiz) return;
    queue<Nodo*> q;
    q.push(raiz);
    while (!q.empty()) {
        Nodo* act = q.front(); q.pop();
        cout << act->dato << " ";
        if (act->izq) q.push(act->izq);
        if (act->der) q.push(act->der);
    }
}

int main() {
    Nodo* raiz = nullptr;
    for (int v : {10, 5, 15, 2, 7, 12, 20})
        raiz = insertar(raiz, v);

    cout << "Preorden:  "; preorden(raiz);  cout << endl;
    cout << "Inorden:   "; inorden(raiz);   cout << endl;
    cout << "Postorden: "; postorden(raiz); cout << endl;
    cout << "BFS:       "; bfs(raiz);       cout << endl;
    return 0;
}
