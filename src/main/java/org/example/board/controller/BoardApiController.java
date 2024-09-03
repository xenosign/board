package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.board.domain.Board;
import org.example.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class BoardApiController {

    private final BoardService service;

    @GetMapping("/list")
    public ResponseEntity<List<Board>> list() {
        List<Board> list = service.getList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Board> get(@PathVariable("id") Long id) {
        Board board = service.detail(id);
        return ResponseEntity.ok(board);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(Board board) {
        service.create(board);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(Board board) {
        System.out.println(board.toString());
        service.update(board);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
