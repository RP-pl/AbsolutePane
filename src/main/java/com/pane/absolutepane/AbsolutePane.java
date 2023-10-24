package com.pane.absolutepane;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AbsolutePane extends Pane {
    private final Map<Node, Positon> nodes;

    public AbsolutePane() {
        super();
        this.nodes = new HashMap<>();
    }

    public AbsolutePane(Map<Node,Positon> nodes) {
        super();
        this.nodes = nodes;
    }

    public AbsolutePane(double width, double height) {
        super();
        setPrefSize(width, height);
        nodes = new HashMap<>();
    }

    public AbsolutePane(double width, double height, Map<Node,Positon> nodes){
        super();
        setPrefSize(width, height);
        this.nodes = nodes;
    }

    public AbsolutePane(boolean synchronous) {
        super();
        if(!synchronous) {
            this.nodes = new HashMap<>();
        }
        else{
            this.nodes = Collections.synchronizedMap(new HashMap<>());
        }
    }

    public AbsolutePane(Map<Node,Positon> nodes,boolean synchronous) {
        super();
        if(!synchronous) {
            this.nodes = new HashMap<>(nodes);
        }
        else{
            this.nodes = Collections.synchronizedMap(new HashMap<>(nodes));
        }
    }

    public AbsolutePane(double width, double height,boolean synchronous){
        super();
        setPrefSize(width, height);
        if(!synchronous) {
            this.nodes = new HashMap<>();
        }
        else{
            this.nodes = Collections.synchronizedMap(new HashMap<>());
        }
    }

    public AbsolutePane(double width, double height, Map<Node,Positon> nodes, boolean synchronous){
        super();
        setPrefSize(width, height);
        if(!synchronous) {
            this.nodes = new HashMap<>(nodes);
        }
        else{
            this.nodes = Collections.synchronizedMap(new HashMap<>(nodes));
        }
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

    public void addNode(Node node, Positon position){
        nodes.put(node, position);
        getChildren().add(node);
    }
    public void removeNode(Node node){
        nodes.remove(node);
        getChildren().remove(node);
    }

    public void addNodes(Map<Node,Positon> nodes){
        this.nodes.putAll(nodes);
        getChildren().addAll(nodes.keySet());
    }
}
