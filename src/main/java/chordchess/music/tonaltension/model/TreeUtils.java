/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.music.tonaltension.model;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {
    public static List<TreeNode> getDepthFirstTraversal(TreeNode root) {
        List<TreeNode> visited = new ArrayList<>();
        traverseDFS(root, visited);
        return visited;
    }

    private static void traverseDFS(TreeNode node, List<TreeNode> visited) {
        if (node == null) return;
        visited.add(node);
        for (TreeNode child : node.getChildren()) {
            traverseDFS(child, visited);
        }
    }
}
