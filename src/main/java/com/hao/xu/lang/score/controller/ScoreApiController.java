package com.hao.xu.lang.score.controller;

import com.hao.xu.lang.score.entity.Score;
import com.hao.xu.lang.score.service.ScoreServiceImpl;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 16:06 2019/10/24
 */
@RestController
@RequestMapping(value = "/scoreApiController")
public class ScoreApiController {

	@Resource
	private ScoreServiceImpl scoreService;

	@RequestMapping(value = "/insert")
	public void insert(Score score) {
		scoreService.insert(score);
	}
}
