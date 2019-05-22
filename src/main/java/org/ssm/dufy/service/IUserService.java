package org.ssm.dufy.service;

import org.ssm.dufy.entity.UserEntity;

public interface IUserService {

	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	public boolean addUserEntity(UserEntity entity);
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public boolean deleteUserEntity(UserEntity entity);
	
	/**
	 * 根据id查找
	 * @param userEntity
	 * @return
	 */
	public UserEntity queryUserEntityByUserId(UserEntity userEntity);
	
}
