/**
 *
 */
package com.iiifi.framework.server.manager.modules.sys.dao;

import java.util.List;

import com.iiifi.framework.server.manager.common.persistence.CrudDao;
import com.iiifi.framework.server.manager.common.persistence.annotation.MyBatisDao;
import com.iiifi.framework.server.manager.modules.sys.entity.Dict;

/**
 * 字典DAO接口
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<String> findTypeList(Dict dict);
	
	public List<Dict> findIntegral(Dict dict);
	
}
