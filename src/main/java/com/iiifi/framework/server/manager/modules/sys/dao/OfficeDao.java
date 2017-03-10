/**
 *
 */
package com.iiifi.framework.server.manager.modules.sys.dao;

import com.iiifi.framework.server.manager.common.persistence.TreeDao;
import com.iiifi.framework.server.manager.common.persistence.annotation.MyBatisDao;
import com.iiifi.framework.server.manager.modules.sys.entity.Office;

/**
 * 机构DAO接口
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
