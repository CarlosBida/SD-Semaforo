# Semáforos
Permite controlar o número de acessos simultâneos a um dado ou recurso

## Métodos da classe Semaphore
* Semaphore(int acessos [, boolean ordem]): construtor; parâmetros definem o número de acessos simultâneos possíveis e se a ordem de liberação de threads em espera será FIFO
* acquire(): solicita acesso a um dado ou recurso, entrando em espera se todos os direitos de acesso estiverem sendo usados
* release(): libera um direito de acesso

![image](https://github.com/user-attachments/assets/0f5e955c-dbbf-4c5d-a9bb-e148dba65800)

# Concorrência na API Java
Algumas classes da API Java controlam a concorrência internamente  thread safe. Ex.: Vector, Hashtable, ...
Outras classes não fazem o controle são thread unsafe, ou seja, não garantem a sua consistência se usadas por várias threads. Estas classes são em geral mais rápidas, pois controle de concorrência reduz o desempenho. Classes thread unsafe devem ser protegidas se forem usadas por mais de uma thread. Ex.: componentes do Swing, LinkedList, ...
Para evitar acesso concorrente a classes thread unsafe, podemos criar novas classes protegidas que as encapsulem

```java
public class SynchronizedLinkedList {
  LinkedList lista = new LinkedList();
  public synchronized void add(Object o) {
    lista.add(o);
  }

  public synchronized Object get(int index) {
    return lista.get(index);
    }
    // idem para os demais métodos de LinkedList
}
```

