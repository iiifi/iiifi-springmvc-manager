/**
 *
 */
package com.iiifi.framework.server.manager.modules.sys.dao;

import com.iiifi.framework.server.manager.common.persistence.CrudDao;
import com.iiifi.framework.server.manager.common.persistence.annotation.MyBatisDao;
import com.iiifi.framework.server.manager.modules.sys.entity.Log;

/**
 * 日志DAO接口
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
