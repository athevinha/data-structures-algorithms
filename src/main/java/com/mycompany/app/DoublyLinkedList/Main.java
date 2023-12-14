package DataStructures.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Product> pList = new DoublyLinkedList<>();
        pList.insertAtHead(new Product(1, "Bralette", "Cotton", 2021, 5));
        pList.insertAtHead(new Product(2, "Hat", "Cotton", 2020, 2));
        pList.insertAtHead(new Product(3, "Watch", "Steel", 2019, 10));
        pList.insertAtHead(new Product(4, "Table", "Wood", 2015, 5));
        pList.insertAtTail(new Product(5, "Lucian", "Meat", 2001, 99999));
        pList.removeExpired();
        System.out.println(pList.getSize());
        pList.sortByName();
        pList.traverse();
        
        // Result:
        // Removed 01 element found!
        // 4
        // { id='1', name='Bralette', material='Cotton', manufacturing='2021', expiry='5'}
        // { id='2', name='Hat', material='Cotton', manufacturing='2020', expiry='2'}
        // { id='5', name='Lucian', material='Meat', manufacturing='2001', expiry='99999'}
        // { id='3', name='Watch', material='Steel', manufacturing='2019', expiry='10'}
    }
}
