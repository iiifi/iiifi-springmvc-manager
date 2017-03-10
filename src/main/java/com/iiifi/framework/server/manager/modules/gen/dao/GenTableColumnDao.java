/**
 *
 */
package com.iiifi.framework.server.manager.modules.gen.dao;

import com.iiifi.framework.server.manager.common.persistence.CrudDao;
import com.iiifi.framework.server.manager.common.persistence.annotation.MyBatisDao;
import com.iiifi.framework.server.manager.modules.gen.entity.GenTableColumn;

/**
 * 业务表字段DAO接口
 */
@MyBatisDao
public interface GenTableColumnDao extends CrudDao<GenTableColumn> {
	
	public void deleteByGenTableId(String genTableId);
}
