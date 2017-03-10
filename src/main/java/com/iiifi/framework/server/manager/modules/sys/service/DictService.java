/**
 *
 */
package com.iiifi.framework.server.manager.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiifi.framework.server.manager.common.persistence.Page;
import com.iiifi.framework.server.manager.common.service.CrudService;
import com.iiifi.framework.server.manager.common.utils.CacheUtils;
import com.iiifi.framework.server.manager.modules.sys.dao.DictDao;
import com.iiifi.framework.server.manager.modules.sys.entity.Dict;
import com.iiifi.framework.server.manager.modules.sys.utils.DictUtils;

/**
 * 字典Service
 */
@Service
@Transactional(readOnly = true)
public class DictService extends CrudService<DictDao, Dict> {
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		super.save(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	public List<Dict> findIntegral(){
		return dao.findIntegral(new Dict());
	}
	

	public Page<Dict> findPageIntegral(Page<Dict> page, Dict dict) {
		dict.setPage(page);
		page.setList(dao.findIntegral(dict));
		return page;
	}
}
