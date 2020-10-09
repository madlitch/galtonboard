/*  SOFE2715U | 2020
    Final Project: Galton Board
    PinGraph.java
    Massimo Albanese - 100616057
    © 2020 ALL RIGHTS RESERVED  */

class PinGraph{

    private Node[] graph;

    PinGraph(int size){
        graph = fill(size);
    }

    private Node[] fill(int size){                                                                                      // fills an array of node classes, with relational data to each other node in the array
        int index = 0;
        Node[] graph = new Node[sum(size,0)];
        for(int i = 1; i <= size; i++){                                                                                 // goes through each layer of the graph
            for(int j = 1; j <= i; j++)
                if(i == size)                                                                                           // case for when it reaches the bottom layer, when i reaches the input size
                    graph[index] = new Node(index++, i, j);
                else
                    graph[index] = new Node(index, i,index + i, ++index + i);                                // creates a node with indexes of its children stored
        }
        return graph;
    }

    private int sum(int size, int sum){                                                                                 // recursive function to determine how many nodes there should be in the graph
        if (size == 0)                                                                                                  // in other words, how big the array should be
            return sum;
        else{
            sum = sum + size;
            size--;
            return sum(size, sum);
        }
    }
                                                                                                                        // getter functions
    int getLeft(int index){
        return graph[index].left;
    }

    int getRight(int index){
        return graph[index].right;
    }

    int getLevel(int index){
        return graph[index].level;
    }

    int getBin(int index){
        return graph[index].bin;
    }
}



