package com.pane.absolutepane;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AbsolutePane extends Pane {
    private final Map<Node, Positon> nodes;

    /**
     * Creates a new instance of AbsolutePane
     */
    public AbsolutePane() {
        super();
        this.nodes = Collections.synchronizedMap(new HashMap<>());
    }

    /**
     * Creates a new instance of AbsolutePane with initial nodes
     * @param nodes - a map of nodes and their positions
     */
    public AbsolutePane(Map<Node,Positon> nodes) {
        super();
        this.nodes = Collections.synchronizedMap(nodes);
    }


    /**
     * Creates a new instance of AbsolutePane with specified preferred size
     * @param width - the width of the pane
     * @param height - the height of the pane
     */
    public AbsolutePane(double width, double height){
        this();
        setPrefSize(width, height);
    }

    /**
     * Creates a new instance of AbsolutePane with specified preferred size and initial nodes
     * @param width - the width of the pane
     * @param height - the height of the pane
     * @param nodes - a map of nodes and their positions
     */
    public AbsolutePane(double width, double height, Map<Node,Positon> nodes){
        this(nodes);
        setPrefSize(width, height);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        for (Node node : nodes.keySet()) {
            Positon position = nodes.get(node);
            node.layoutXProperty().bind(position.getX());
            node.layoutYProperty().bind(position.getY());
        }
    }

    /**
     * Adds a node to the pane
     * @param node - the node to be added
     * @param position - the position of the node
     */
    public void addNode(Node node, Positon position){
        nodes.put(node, position);
        getChildren().add(node);
    }
    /**
     * Removes a node from the pane
     * @param node - the node to be removed
     */
    public void removeNode(Node node){
        nodes.remove(node);
        getChildren().remove(node);
    }

    /**
     * Adds nodes to the pane
     * @param nodes - a map of nodes and their positions
     */
    public void addNodes(Map<Node,Positon> nodes){
        this.nodes.putAll(nodes);
        getChildren().addAll(nodes.keySet());
    }

    /**
     * Get node at specified position
     * @param position - the position of the node
     * @return {@link  javafx.scene.Node}
     */
    public Node getNodeAtPosition(Positon position){
        for (Node node : nodes.keySet()) {
            Positon nodePosition = nodes.get(node);
            if(nodePosition.equals(position)){
                return node;
            }
        }
        return null;
    }

    /**
     * Get all nodes with their respective positions
     * @return {@link  java.util.Map}
     */
    public Map<Node, Positon> getNodes() {
        return nodes;
    }
}
