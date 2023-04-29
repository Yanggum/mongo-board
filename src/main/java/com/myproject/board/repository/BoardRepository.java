package com.myproject.board.repository;


import com.myproject.board.model.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<Board, String> {

}
