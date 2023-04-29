package com.myproject.board.controller;

import com.myproject.board.model.Board;
import com.myproject.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/")
    public List<Board> getAllBoards() {
        return boardService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable String id) {
        Optional<Board> board = boardService.findById(id);
        return board.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        Board newBoard = boardService.create(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBoard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable String id, @RequestBody Board board) {
        Board updatedBoard = boardService.update(id, board);
        return ResponseEntity.ok(updatedBoard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable String id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
