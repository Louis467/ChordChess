/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.music.tonaltension.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String label;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(String label) {
        this.label = label;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        child.parent = this;
        children.add(child);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public TreeNode getParent() {
        return parent;
    }
}
