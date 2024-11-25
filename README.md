# Semáforos
Permite controlar o número de acessos simultâneos a um dado ou recurso

## Métodos da classe Semaphore
* Semaphore(int acessos [, boolean ordem]): construtor; parâmetros definem o número de acessos simultâneos possíveis e se a ordem de liberação de threads em espera será FIFO
* acquire(): solicita acesso a um dado ou recurso, entrando em espera se todos os direitos de acesso estiverem sendo usados
* release(): libera um direito de acesso

![image](https://github.com/user-attachments/assets/0f5e955c-dbbf-4c5d-a9bb-e148dba65800)
