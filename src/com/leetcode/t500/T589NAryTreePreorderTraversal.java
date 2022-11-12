package com.leetcode.t500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenjianyin
 */
public class T589NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {

        List<Integer> objects = new ArrayList<>();
        int val = root.val;
        objects.add(val);
        List<Node> children = root.children;
//        children.


        return null;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};