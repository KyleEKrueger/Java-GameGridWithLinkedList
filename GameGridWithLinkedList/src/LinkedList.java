public class LinkedList {
    Node headNode;

    public void addHeadNode(int x,int y){
        Node tempNode = new Node();
        tempNode.xPosition = x;
        tempNode.yPosition = y;
        tempNode.nextNode = headNode;
        headNode = tempNode;
    }
    public Node removeNode(){
        Node tempNode;
        tempNode = headNode;
        if(headNode == null){
            System.out.println("End of List");
        }
        else{
            headNode = headNode.nextNode;
        }
        return tempNode;
    }
}
