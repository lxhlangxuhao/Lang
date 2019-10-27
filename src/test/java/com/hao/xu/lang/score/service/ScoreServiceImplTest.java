package com.hao.xu.lang.score.service;

import com.hao.xu.lang.score.entity.Score;
import com.hao.xu.lang.score.mapper.ScoreMapper;
import com.sun.scenario.effect.impl.prism.PrImage;
import core.BasejunitTest;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.junit.Test;


/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 12:17 2019/10/26
 */
public class ScoreServiceImplTest extends BasejunitTest {

	@Resource
	private ScoreMapper scoreMapper;

	@Resource
	private ScoreServiceImpl scoreService;

	@Test
	public void insert() {

		scoreService.insert(new Score("2", new BigDecimal("10")));
	}

}