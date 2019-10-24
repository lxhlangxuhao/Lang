package com.hao.xu.lang.student.service;

import com.hao.xu.lang.student.entity.Student;
import com.hao.xu.lang.student.mapper.StudentMapper;
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

	@Transactional
	public void insert(Student student) {
		studentMapper.insertSelective(student);
//		int i = 1 / 0;
	}



}
