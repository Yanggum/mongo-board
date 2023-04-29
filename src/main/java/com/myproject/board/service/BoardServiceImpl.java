package com.myproject.board.service;


import com.myproject.board.model.Board;
import com.myproject.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board create(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Optional<Board> findById(String id) {
        return boardRepository.findById(id);
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board update(String id, Board board) {
        Board existingBoard = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        existingBoard.setTitle(board.getTitle());
        existingBoard.setContent(board.getContent());
        existingBoard.setAuthor(board.getAuthor());
        existingBoard.setModifiedDate(board.getModifiedDate());
        return boardRepository.save(existingBoard);
    }

    @Override
    public void delete(String id) {
        boardRepository.deleteById(id);
    }
}

