#include <iostream>
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

int contarHojas(Nodo* r) {
    if (!r) return 0;
    if (!r->izq && !r->der) return 1; // es hoja
    return contarHojas(r->izq) + contarHojas(r->der);
}

int main() {
    Nodo* raiz = nullptr;
    for (int v : {10, 5, 15, 2, 7, 12, 20})
        raiz = insertar(raiz, v);

    cout << "Hojas: " << contarHojas(raiz) << endl; // 4: nodos 2, 7, 12, 20
    return 0;
}
