package org.ssm.dufy.service;

import org.ssm.dufy.entity.UserEntity;

public interface IUserService {

	/**
	 * ����
	 * @param entity
	 * @return
	 */
	public boolean addUserEntity(UserEntity entity);
	
	/**
	 * ɾ��
	 * @param entity
	 * @return
	 */
	public boolean deleteUserEntity(UserEntity entity);
	
	/**
	 * ����id����
	 * @param userEntity
	 * @return
	 */
	public UserEntity queryUserEntityByUserId(UserEntity userEntity);
	
}
