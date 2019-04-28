package org.ssm.dufy.dao;

import java.util.List;
import java.util.Map;

public interface ShiroPermissionDao {
	
	public List queryPermissionByRoleId(Map param);
}
