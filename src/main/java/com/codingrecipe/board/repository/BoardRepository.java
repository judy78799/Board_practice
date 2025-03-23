package com.codingrecipe.board.repository;
import org.mybatis.spring.SqlSessionTemplate;
import com.codingrecipe.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository{

  private final SqlSessionTemplate sql;
  public void save(BoardDTO boardDTO){
    //Board: mapper 파일 안의 namespace의 Board를 의미 save: 쿼리문을 담고 있는 태그
    //namespace가 Board고 id가 save인 것을 사용하겠다.
    sql.insert("Board.save", boardDTO);
  }

  public List<BoardDTO> findAll(){
    return sql.selectList("Board.findAll");
  }

  public void updateHits(Long id){
    sql.update("Board.updateHits", id);
  }

  public BoardDTO findById(Long id) {
    return sql.selectOne("Board.findById", id);
  }
  public void update(BoardDTO boardDTO){
    sql.update("Board.update", boardDTO);
  }
}
