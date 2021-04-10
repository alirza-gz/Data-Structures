package ir.ac.urmia.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    static class TreeNode<T>{
        T value;
        TreeNode<T> parent = null;
        private List<TreeNode<T>> children = new ArrayList<>();


        public TreeNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode<T> getParent() {
            return parent;
        }

        public List<TreeNode<T>> getChildren() {
            return children;
        }

        public void addChild(TreeNode<T> child){
            getChildren().add(child);
            child.parent = this;
        }


        public TreeNode(T value, TreeNode<T> parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    private TreeNode<T> root;


    public TreeNode<T> getRoot() {
        return root;
    }

    public Tree(T rootValue) {
        this.root = new TreeNode<>(rootValue);
    }

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>("Ali");
        tree.getRoot().addChild(new TreeNode<>("Alireza"));
        tree.getRoot().addChild(new TreeNode<>("Meysam"));

        System.out.println();
    }
}
