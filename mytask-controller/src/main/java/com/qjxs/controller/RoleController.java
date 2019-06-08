package com.qjxs.controller;

import com.qjxs.common.utils.Result;
import com.qjxs.domain.Role;
import com.qjxs.domain.qry.RoleQry;
import com.qjxs.service.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/role")
@RestController
public class RoleController extends AbstractController{
	
    @Autowired
    private RoleService roleService;

    
	@PostMapping("/save")
	public Object save(@RequestBody Role role) {
		Role u=roleService.save(role);
		return Result.success(u);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody RoleQry qry) {
		roleService.delete(qry);
	}
	@DeleteMapping("/deleteById")
	public void deleteById(@RequestParam String id) {
		roleService.deleteById(id);
		
	}
	@DeleteMapping("/deleteByIds")
	public void deleteByIds(@RequestParam List<String> ids) {
		roleService.deleteByIds(ids);
	}
	@GetMapping("/findById")
	public Object findById(@RequestParam String id) {
		return Result.success(roleService.findById(id));
	}
	@GetMapping("/query")
	public Object query(@RequestBody RoleQry qry) {
		return Result.success(roleService.query(qry));
	}
	@GetMapping("/queryPage")
	public Object queryPage(@RequestBody RoleQry qry) {
		return Result.success(roleService.queryPage(qry));
	}
	@GetMapping("/count")
	public Object count(@RequestBody RoleQry qry) {
		return Result.success(roleService.count(qry));
	}


}
