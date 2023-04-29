package com.myproject.board.service;

import com.myproject.board.model.Board;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    public Board create(Board board);

    public Optional<Board> findById(String id);

    public List<Board> findAll();

    public Board update(String id, Board board);

    public void delete(String id);
}
