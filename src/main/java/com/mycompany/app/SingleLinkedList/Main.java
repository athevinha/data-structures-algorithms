package DataStructures.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Product> pLinkedList = new SinglyLinkedList<>();
        pLinkedList.addFirst(new Product("Xoai", 20000, 150));
        pLinkedList.addFirst(new Product("Coc", 15000, 200));
        pLinkedList.addFirst(new Product("Oi", 25000, 15));
        pLinkedList.addFirst(new Product("Sau rieng", 100000, 2));
        pLinkedList.addFirst(new Product("Vai", 40000, 10));
        System.out.println(pLinkedList.getSize());
        pLinkedList.removeAtFront();
        pLinkedList.traverse();
        
        // Result:
        // 5
        // Front element deleted
        // { name='Sau rieng', price='100000.0', qty='2'}
        // { name='Oi', price='25000.0', qty='15'}
        // { name='Coc', price='15000.0', qty='200'}
        // { name='Xoai', price='20000.0', qty='150'}
    }
}
