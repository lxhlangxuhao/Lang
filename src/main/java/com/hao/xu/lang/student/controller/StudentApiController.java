package com.hao.xu.lang.student.controller;

import com.hao.xu.lang.base.Response;
import com.hao.xu.lang.student.entity.Student;
import com.hao.xu.lang.student.mapper.StudentMapper;
import com.hao.xu.lang.student.service.StudentServiceImpl;
import com.hao.xu.lang.utils.QRCodeUtil;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 9:45 2019/10/23
 */
@RestController
@RequestMapping(value = "/studentApiController")
public class StudentApiController {

	@Resource
	private StudentMapper studentMapper;

	@Resource
	private StudentServiceImpl studentService;

	@RequestMapping(value = "/selectByPrimaryKey")
	public Student selectByPrimaryKey(int sid) {
		return studentMapper.selectByPrimaryKey(sid);
	}

	@RequestMapping(value = "/insert")
	public Response insert(Student student) {
		return studentService.insert(student);
	}

	@RequestMapping(value = "/createQRCode")
	public void createQRCode(String content, HttpServletResponse response) throws IOException {

		QRCodeUtil.createCodeToOutputStream(content, response.getOutputStream());
	}


}
