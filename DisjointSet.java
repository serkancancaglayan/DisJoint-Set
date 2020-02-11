public class DisjointSet<T> {
	Node<T> head;
	Node<T> tail;
	
	public DisjointSet() {
		this.head = null;
		this.tail = null;
	}
	
	public void makeSet(T data) {
		Node<T> v = new Node<T>(data);
		this.head = v;
		this.tail = v;
		v.head = this.head;
		v.next = null;
	}
	
	public void makeSet(Node<T> v) {
		this.head = v;
		this.tail = v;
		v.head = this.head;
		v.next = null;
	}
	
	public void add(T data) {
		Node<T> v = new Node<T>(data);
		v.head = this.head;
		tail.next = v;
		this.tail = v;
		v.next = null;
	}
	
	public void add(Node<T> v) {
		v.head = this.head;
		tail.next = v;
		this.tail = v;
		v.next = null;
	}
	
	
	public Node<T> Find(Node<T> v) {
		return v.head;
	}
	
	
	public void union(DisjointSet<T> o) {
		Node<T> temp = o.head.next;
		this.tail.next = temp;
		while(temp != null) {
			if(temp.next == null) {
				this.tail = temp;
			}
			temp.head = this.head;
			temp = temp.next;
		}
	}
	
	public void printSet() {
		Node<T> temp = head.next;
		System.out.printf("%s: { ",head.data);
		while(temp != null) {
			System.out.printf("%s ",temp.data);
			temp = temp.next;
		}
		System.out.printf("}\n");
	}
	
	public static void main(String[] args) {
		// -1 : { 14 13 144 }
		DisjointSet<Integer> set = new DisjointSet<Integer>();
		set.makeSet(-1);
		set.add(14);
		set.add(13);
		Node<Integer> v = new Node<Integer>(144);
		set.add(v);
		
		// -2 : { -5 -4 -6 }
		DisjointSet<Integer> set2 = new DisjointSet<Integer>();
		set2.makeSet(-2);
		set2.add(-5);
		set2.add(-4);
		Node<Integer> u = new Node<Integer>(-66);
		set2.add(u);
		
		System.out.println("Before union");
		set.printSet();
		set2.printSet();
		
		
		set.union(set2);
		
		System.out.println("After union");
		set.printSet();
		
	}
}
