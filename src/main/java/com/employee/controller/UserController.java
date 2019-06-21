package com.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entity.User;
import com.employee.service.UserService;

/**
 * 
 * @author lanzefei
 * @date 2019年6月20日 下午7:29:49
 */
@Controller
public class UserController {
	@Autowired
    private UserService userService;
	
	//展示所有用户信息
	@RequestMapping("/getAllUser")
	public String getAllUser(Map<String,List<User>> map){
		List<User> listUser = userService.getAllUser();
		map.put("listUser", listUser);
		return "listUser";   //返回/WEB-INF/jsp/listUser.jsp
	}
	
	//根据用户名展示一个用户
	/**
	@RequestMapping("/getByUser_name")
	public String getByEmployee(String user_name,Map<String,User> map) {
		User user = userService.getByUser_name(user_name);
		map.put("user", user);
		return "listOneUser";
	}
	*/
	//添加用户表单
	@RequestMapping("/formAddUser")
	public String formAddUser() {
		return "formAddUser";
	}
	
	//修改用户表单
	@RequestMapping("/formUpdateUser")
	public String formUpdateUser() {
		return "formUpdateUser";
	}
	
	//添加用户
	@RequestMapping("/saveUser")
	public String saveEmployee(User user) {
		userService.saveUser(user);
		return "redirect:getAllUser";     //重定向，重新查询所有用户，并展示
	}
	
	//删除用户
	@RequestMapping("/deleteUser")
	public String deleteEmployee(String user_name) {
		userService.deleteByUser_name(user_name);
		return "redirect:getAllUser";   
	}
	
	//修改用户信息
	@RequestMapping("/updateUser")   
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:getAllUser";   
	}
}
