package LinkedLists;
public class DLL 
{
    private class Node
    {
        int data;
        Node next;
        Node prev;

        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head = null;

    ////////////////////////////////////
    // METHODS
    ////////////////////////////////////

    public void clearAll()
    {
        head = null;
        return;
    }

    public void insertAtStart(int data)
    {
        Node newnode = new Node(data);
        if (head != null)
        {
            // set newnode as head
            head.prev = newnode;
            newnode.next = head;
        }
        // next, and also in any other condition,
        head = newnode;
    }

    public void insertAtEnd(int data)
    {
        Node newnode = new Node(data);
        if (head == null)
        {
            head = newnode;
            return;
        }
        Node curr = head;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = newnode;
        newnode.prev = curr;
        newnode.next = null;
    }

    public void display()
    {
        Node curr = head;
        while (curr.next != null)
        {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.print(curr.data + "->null" + "\n");
    }

    public boolean remove(int data)
    {
        // if list is empty
        if (head == null) return false;
        
        // if head contains the data
        if (head.data == data)
        {
            head = head.next;
            return true;
        }

        // if data is in middle of the list
        Node curr = head;
        while (curr.next != null)
        {
            // check for the data match in every single node.
            if (curr.data == data)
            {
                Node before = curr.prev;
                Node after = curr.next;
                before.next = after;
                after.prev = before;
                return true;
            }
            curr = curr.next;
        }

        // last node case
        if (curr.next == null)
        {
            Node before = curr.prev;
            before.next = null;
            curr.prev = null;
            return true;
        }
        return false;
    }

    public Node arrToDll(int[] arr)
    {
        for (int i:arr)
        {
            insertAtEnd(i);
        }
        return head;
    }

    public void sortInsert(int data)
    {
        Node newnode = new Node(data);
        if (head == null)
        {
            head = newnode;
            return;
        }
        Node curr = head;
        while (curr.next != null && data > curr.data )
        {
            curr = curr.next;
        }
        if (data <= curr.data)
        {
            Node before = curr.prev;
            if (before != null)
            {
                before.next = newnode;
            }
            else  // insert at head
            {
                head = newnode;
            }
            // pointers
            newnode.prev = before;
            newnode.next = curr;
            curr.prev = newnode;
        }
        else // insert at the end
        {
            curr.next = newnode;
            newnode.prev = curr;
        }
    }

    public Node reverse()
    {
        Node before = null;
        Node curr = head;
        Node after = curr.next;

        while (curr != null)
        {
            after = curr.next;
            curr.next = before;
            curr.prev = after;
            before = curr;
            curr = after; 
        }
        // at the end
        head = before;
        return head;
    }

    public static void main(String args[])
    {

        DLL dll = new DLL();
        dll.insertAtEnd(2);
        dll.insertAtStart(3);
        int[] arr = {22,33,44,55,66};
        dll.arrToDll(arr);
        dll.display();
        dll.remove(22);
        dll.remove(66);
        dll.remove(99); // 99 not in list
        dll.display();
        dll.reverse();
        dll.display();
        dll.clearAll();
        dll.sortInsert(0);
        dll.sortInsert(8);
        dll.sortInsert(77);
        dll.sortInsert(4);
        dll.sortInsert(60);
        dll.sortInsert(67);
        dll.display();
        dll.reverse();
        dll.display();
    }
    
}
