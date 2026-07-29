
class Node{
    
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }

    public int hashCode(){
        return Objects.hashCode(value);
    }

      public boolean equals(Object a){
        return this.value == (((Node)a).value);
    }
}


class LRUCache {

    Map<Integer, Node> lookup;
    int capacity;
    Node head, tail;
    int curr = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lookup = new HashMap<>();

        head = new Node(-1 , -1);
        tail = new Node(-1 , -1);

        head.next = tail;
        tail.prev = head;

    }
    

    public int get(int key) {

        if(lookup.containsKey(key)){
            removeNode(lookup.get(key));
            moveToTop(lookup.get(key));
            return lookup.get(key).value;
        }
        return -1;    

    }
    
    public void put(int key, int value) {
        
        if(lookup.containsKey(key)){
            removeNode(lookup.get(key));
            this.curr--;
        }
        if(this.capacity == this.curr){
            print();
            evictLast();
            print();
            this.curr --;
        }
        Node n = new Node(key, value);
        lookup.put(key, n);
        moveToTop(n);
        this.curr++;
  
    }

   // head <-> 2
   // 1
   
    public void moveToTop(Node n){
        Node temp = head.next; // 2
        head.next = n; // h-> 1 -> 2
        n.next = temp; 
        n.prev = head;
        temp.prev = n;
    }


    public void evictLast(){
        lookup.remove(tail.prev.key);
        removeNode(tail.prev);
    }


    // 1 <-> 2 <-> 3.  1 <-> 3
    public void removeNode(Node n){
        Node temp = n.prev;
        temp.next = n.next;
        temp.next.prev = temp;
    }

    public void print(){
        Node t = head;
        System.out.println();
        while(t!=tail){
            System.out.print(t.value + " ");
            t = t.next;
        }
    }
}
