package com.hao.xu.lang.score.service;

import com.hao.xu.lang.score.entity.Score;
import com.hao.xu.lang.score.mapper.ScoreMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:01 2019/10/24
 */
@Service
public class ScoreServiceImpl {

	@Resource
	private ScoreMapper sroceMapper;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void  insert(Score score) {
		sroceMapper.insertSelective(score);
		int i = 1 / 0;
	}


}
