package com.hao.xu.lang.score.mapper;

import com.hao.xu.lang.score.entity.Score;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}