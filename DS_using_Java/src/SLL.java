public class SLL
{
    // make an inner class - private static class of Node.
    // private to make it inaccessible outside of SLL class.
    // static coz we don't need to create obj for it. It doesn't need access to any instance variables or methods in the SLL class.
    private static class Node
    {
        int data;
        Node next; // The next is an instance variable of type Node.
        // This means next can hold the reference to an instance of the Node class.

        // construtor
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    // create a head node (object)
    private Node head;

    //////////////////////////////////////////////
    // METHODS
    //////////////////////////////////////////////

    public void clearAll()
    {
        head = null;
    }

    public void addToStart(int data)
    {
        // create node
        Node newnode = new Node(data);
        newnode.next = head; // next points to head
        head = newnode; // new node becomes the head.
    }

    public void addToEnd(int data)
    {
        Node newnode = new Node(data);
        
        // if there is empty ll:
        if (head == null)
        {
            head = newnode;
            return; // end here
        }
        // else
        // traversal from head
        Node current = head;
        while (current.next != null)
        {
            // update current to next node
            current = current.next;
        }
        // when current node is pointing null finally,
        current.next = newnode;
    }

    public boolean remove(int data)
    {
        if (head==null) return false;

        // if head's data is to be removed:
        if (head.data==data)
        {
            head = head.next; // make next node as head
            return true;
        }

        // else:
        Node current = head;
        while (current.next != null)
        {
            // if the current's next node has that data,
            if (current.next.data == data)
            {
                // then, point the current's  pointer to next of next node.
                current.next = current.next.next;
                return true;
                // end
            }
            // update the current node to next (iterate).
            current = current.next;
        }
        return false; // if not found, return false here.
    }

    public void show()
    {
        if (head==null) return;
        // get the head
        Node current = head;
        // iterate
        while (current.next != null)
        {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print(current.data + "->");
        // at the end (or) if the current node is empty:
        System.out.println("null");
    }

    // my method to take values from array:
    public void arrToSll(int[] arr)
    {
        head = null;
        for (int val:arr)
        {
            addToEnd(val);
        }
    }

    public int len()
    {
        if (head==null) return 0;
        int cnt = 0;
        Node current = head; 
        while (current.next != null)
        {
            current = current.next;
            cnt += 1;
        }
        return cnt+1;
    }

    public void insertAt(int index, int data)
    {
        if (head==null && index != 0)
        {
            throw new NullPointerException("Invalid index for empty list");
        }
        int len = len()+1;
        if (index > len)
        {
            throw new IndexOutOfBoundsException("Index " +index + "is out of bound for the list size" + len);
        }
        if (index==len)
        {
            addToEnd(data);
            return;
        }
        if (index==0) 
        {
            addToStart(data);
            return;
        }
        else
        {
            Node previous = head;
            for (int i=0; i<index-1; i++)
            {
                previous = previous.next;
            }
            Node newnode = new Node(data);
            Node after = previous.next; 
            previous.next = newnode;
            newnode.next = after;
        }
    }

    public boolean contains(int data)
    {
        if (head==null) return false;
        Node current = head;
        while (current.next != null)
        {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;

    }

    public int indexOf(int data)
    {
        if (contains(data))
        {
            int cnt = 0;
            Node current = head;
            while (current.next != null)
            {
                if (current.data == data) return cnt;
                cnt += 1;
                current = current.next;
            }
        }
        return -1;
    }

    public void addAfter(int key, int data)
    {
        int index = indexOf(key);
        if (index!=-1)
        {
            insertAt(index+1, data);
        }
    }

    public void addBefore(int key, int data)
    {
        int index = indexOf(key);
        if (index!=-1)
        {
            insertAt(index, data);
        }
    }

    public int dataAt(int index)
    {
        if (index > len() || head == null)
        {
            throw new IndexOutOfBoundsException("Out of bound");
        }
        Node current = head;
        for (int i=0; i<index; i++)
        {
            current = current.next;
        }
        return current.data;
    }

    public void deleteFirst()
    {
        if(head!=null)
        {
            head = head.next;
        }
    }

    public void deleteLast()
    {
        if (head == null || head.next == null) 
        {
            head = null;
        } 
        else 
        {
            Node current = head;
            while (current.next.next != null) 
            {
                current = current.next;
            }
            current.next = null;
        }
    }

    public static void main(String args[])
    {
        SLL sll = new SLL();
        sll.addToStart(3);
        sll.addToStart(4);
        sll.addToEnd(2);
        sll.addToEnd(1);
        sll.show();
        sll.clearAll();
        sll.show();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        sll.arrToSll(arr);
        sll.show();
        System.out.println(sll.len());
        sll.insertAt(3, 100);
        sll.show();
        System.out.println(sll.indexOf(100));
        sll.addAfter(100, 200);
        sll.show();
        sll.addBefore(6, 99);
        sll.show();
        sll.insertAt(0, 0);
        sll.show();
        sll.insertAt(15, 1000);
        sll.show();
        sll.clearAll();
        int[] arr1 = {1,2,3,4,5};
        sll.arrToSll(arr1);
        sll.show();
        System.out.println(sll.dataAt(4));
        sll.deleteFirst();
        sll.show();
        sll.deleteLast();
        sll.show();
        System.out.println("The END");

    }

}