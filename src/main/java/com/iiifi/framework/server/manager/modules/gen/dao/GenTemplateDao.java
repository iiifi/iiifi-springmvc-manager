/**
 *
 */
package com.iiifi.framework.server.manager.modules.gen.dao;

import com.iiifi.framework.server.manager.common.persistence.CrudDao;
import com.iiifi.framework.server.manager.common.persistence.annotation.MyBatisDao;
import com.iiifi.framework.server.manager.modules.gen.entity.GenTemplate;

/**
 * 代码模板DAO接口
 */
@MyBatisDao
public interface GenTemplateDao extends CrudDao<GenTemplate> {
	
}
