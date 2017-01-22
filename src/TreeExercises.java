import static java.lang.System.out;


public class TreeExercises {

    public static void main(String[] args){
        Node  n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n2.left = n1;
        n2.right = n3;

        out.println(n2.preorder());
        out.println(n2.postorder());
        out.println(n2.inorder());
    }

}

class Node{

    Node left;
    int data;
    Node right;

    public Node(int data){
        this.data = data;
    }

    public String inorder(){
        StringBuilder res = new StringBuilder();
        if(this.left != null) res.append(this.left.inorder());
        res.append(this.data);
        if(this.right != null) res.append(this.right.inorder());
        return res.toString();
    }

    public String preorder(){
        StringBuilder res = new StringBuilder();
        res.append(this.data);
        if(this.left != null) res.append(this.left.preorder());
        if(this.right != null) res.append(this.right.preorder());
        return res.toString();
     }

    public String postorder(){
        StringBuilder res = new StringBuilder();
        if(this.left != null) res.append(this.left.postorder());
        if(this.right != null) res.append(this.right.postorder());
        res.append(this.data);
        return res.toString();
    }
}
