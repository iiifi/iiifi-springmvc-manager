/**
 *
 */
package com.iiifi.framework.server.manager.modules.sys.dao;

import com.iiifi.framework.server.manager.common.persistence.TreeDao;
import com.iiifi.framework.server.manager.common.persistence.annotation.MyBatisDao;
import com.iiifi.framework.server.manager.modules.sys.entity.Area;

/**
 * 区域DAO接口
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {

}
