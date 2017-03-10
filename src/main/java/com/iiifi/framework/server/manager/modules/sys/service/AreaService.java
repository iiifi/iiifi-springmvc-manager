/**
 *
 */
package com.iiifi.framework.server.manager.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiifi.framework.server.manager.common.service.TreeService;
import com.iiifi.framework.server.manager.modules.sys.dao.AreaDao;
import com.iiifi.framework.server.manager.modules.sys.entity.Area;
import com.iiifi.framework.server.manager.modules.sys.utils.UserUtils;

/**
 * 区域Service
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends TreeService<AreaDao, Area> {

	public List<Area> findAll(){
		return UserUtils.getAreaList();
	}

	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
}
