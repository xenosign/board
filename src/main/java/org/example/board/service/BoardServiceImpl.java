package org.example.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.board.domain.Board;
import org.example.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<Board> getList() {
        return boardMapper.getList();
    }

    @Override
    public Board detail(Long id) {
        return boardMapper.detail(id);
    }

    @Override
    public void create(Board board) { boardMapper.create(board); }

    @Override
    public Board update(Board board) {
        boardMapper.update(board);
        System.out.println(board.toString());
        return detail(board.getId());
    }

    @Override
    public Board delete(Long id) {
        Board board = detail(id);
        boardMapper.delete(id);
        return board;
    }
}
