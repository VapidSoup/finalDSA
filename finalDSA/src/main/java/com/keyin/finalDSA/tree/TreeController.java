package com.keyin.finalDSA.tree;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeController {

    private final TreeService service;

    public TreeController(TreeService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTree(@RequestBody List<Integer> numbers) {
        TreeNode tree = service.createTree(numbers);
        return ResponseEntity.ok(tree);
    }

    @GetMapping("/previous")
    public ResponseEntity<List<BinarySearchTree>> getPreviousTrees() {
        List<BinarySearchTree> trees = service.getAllTrees();
        return ResponseEntity.ok(trees);
    }
}
