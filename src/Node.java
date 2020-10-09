/*  SOFE2715U | 2020
    Final Project: Galton Board
    Node.java
    Massimo Albanese - 100616057
    © 2020 ALL RIGHTS RESERVED  */

class Node{
    private int index;
    int level, left, right, bin;

    Node(int index, int level, int left, int right){                                                                    // for nodes in inner layer, has info on its children and its level
        this.index = index;
        this.level = level;
        this.left = left;
        this.right = right;
    }
    Node(int index, int level, int bin){                                                                                // uses overloading, for nodes on the final layer, has a reference to its bin
        this.index = index;
        this.level = level;
        this.bin = bin;
    }
}


