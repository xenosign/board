package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.board.domain.Board;
import org.example.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class BoardApiController {

    private final BoardService service;

    @GetMapping("/list")
    public ResponseEntity<List<Board>> list() {
        List<Board> list = service.getList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Board> get(@PathVariable("id") Long id) {
        Board board = service.get(id);
        return ResponseEntity.ok(board);
    }
}
