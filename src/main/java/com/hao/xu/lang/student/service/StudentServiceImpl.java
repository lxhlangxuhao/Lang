package com.hao.xu.lang.student.service;

import com.hao.xu.lang.base.Response;
import com.hao.xu.lang.score.entity.Score;
import com.hao.xu.lang.score.service.ScoreServiceImpl;
import com.hao.xu.lang.student.entity.Student;
import com.hao.xu.lang.student.mapper.StudentMapper;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:24 2019/10/24
 */
@Service
public class StudentServiceImpl {

	@Resource
	private StudentMapper studentMapper;

	@Resource
	private ScoreServiceImpl scoreService;

	@Transactional(rollbackFor = Exception.class)
	public Response insert(Student student) {
		studentMapper.insertSelective(student);
//		try {
			scoreService.insert(new Score("2",  new BigDecimal(20)));
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}
		int i = 1 / 0;
		return new Response().success();
	}



}
