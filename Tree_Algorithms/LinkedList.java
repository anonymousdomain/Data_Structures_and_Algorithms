public class LinkedList{
	private SLNode head; // head node
	private SLNode tail; // tail node
	public LinkedList(){
		this.head = null;
		this.tail = null;
	}
	// add to head
	public void  addToHead(BSTNode el){
		// write your implementation here
		SLNode node = new SLNode(el,this.head);
		this.head = node;
		if(this.tail==null) this.tail = this.head;
	}
	// add to tail
	public void addToTail(BSTNode el){
		// write your implementation here
		if(!isEmpty()){	
			this.tail.next = new SLNode(el,null);
			this.tail = this.tail.next;
		}
		else this.head=this.tail= new SLNode(el,null);
	}
	// remove from head
	public BSTNode removeFromHead(){
		BSTNode info = this.head.info;
		if(this.head==this.tail) this.head = this.tail = null;
		else this.head = this.head.next;
		return info;
	}
	// remove from tail
	public BSTNode removeFromTail(){
		BSTNode info = this.tail.info;
		if(this.head == this.tail) this.head=this.tail=null;
		else{
			SLNode tmp= this.head;
			for(;tmp.next!=this.tail;tmp=tmp.next);
			this.tail = tmp;
			this.tail.next = null;
		}
		return info;
	}
	// remove from anywhere
	public BSTNode remove(BSTNode info){
		if(!this.isEmpty()){
			if(this.head==this.tail&&info==this.head.info) this.head=this.tail=null;
			else if(info==this.head.info) this.head = this.head.next;
			else {
				SLNode pred = this.head;
				SLNode tmp = this.head.next;
				for(;tmp!=null&&tmp.info!=info;pred=pred.next,tmp=tmp.next);
				if(tmp!=null){
					pred.next = tmp.next;
					if(tmp==this.tail) this.tail=pred;
				}
			}
			return info;
		}
		return null;
	}
	// search node
	public boolean search(BSTNode info){
		SLNode tmp = this.head;
		for(;tmp!=null&&tmp.info!=info;tmp=tmp.next);
		return tmp!=null;
	}
	//print list
	public void printList(){
		for(SLNode temp = this.head;temp!=null;temp=temp.next)
			System.out.println(temp.info);
	}
	//
	public boolean isEmpty(){
		return this.head==null;
	}

	public BSTNode  getHead(){
		return this.head.info;
	}

	public BSTNode getTail(){
		return this.tail.info;
	}
	
	
}
