package com.qjxs.controller;

import com.qjxs.common.utils.Result;
import com.qjxs.domain.Permission;
import com.qjxs.domain.qry.PermissionQry;
import com.qjxs.service.PermissionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Permission")
@RestController
public class PermissionController extends AbstractController{
	
    @Autowired
    private PermissionService permissionService;

    
	@PostMapping("/save")
	public Object save(@RequestBody Permission permission) {
		Permission u=permissionService.save(permission);
		return Result.success(u);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody PermissionQry qry) {
		permissionService.delete(qry);
	}
	@DeleteMapping("/deleteById")
	public void deleteById(@RequestParam String id) {
		permissionService.deleteById(id);
		
	}
	@DeleteMapping("/deleteByIds")
	public void deleteByIds(@RequestParam List<String> ids) {
		permissionService.deleteByIds(ids);
	}
	@GetMapping("/findById")
	public Object findById(@RequestParam String id) {
		return Result.success(permissionService.findById(id));
	}
	@GetMapping("/query")
	public Object query(@RequestBody PermissionQry qry) {
		return Result.success(permissionService.query(qry));
	}
	@GetMapping("/queryPage")
	public Object queryPage(@RequestBody PermissionQry qry) {
		return Result.success(permissionService.queryPage(qry));
	}
	@GetMapping("/count")
	public Object count(@RequestBody PermissionQry qry) {
		return Result.success(permissionService.count(qry));
	}


}
