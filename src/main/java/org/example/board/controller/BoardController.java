package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.board.domain.Board;
import org.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;
    private final String context = "/board";

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boardList = service.getList();
        model.addAttribute("boardList", boardList);
        return context + "/list";
    }

    @GetMapping("/create")
    public void create() {}

    @PostMapping("/create")
    public String create(Board board) {
        service.create(board);
        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public String get(@RequestParam("id") Long id, Model model) {
        Board board = service.get(id);
        model.addAttribute("board", board);
        return context + "/detail";
    }

    @GetMapping("/update")
    public void update(@RequestParam("id") Long id, Model model) {
        model.addAttribute("board", service.get(id));
    }

    @PostMapping("/update")
    public String update(Board board) {
        System.out.println(board.toString());
        service.update(board);
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        service.delete(id);
        return "redirect:/board/list";
    }
}
