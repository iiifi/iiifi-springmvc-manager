/**
 *
 */
package com.iiifi.framework.server.manager.common.filter;

import com.iiifi.framework.server.manager.common.utils.CacheUtils;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

/**
 * @author vk
 * @version 2016-01-15
 */
public class PageCachingFilter extends SimplePageCachingFilter {

	@Override
	protected CacheManager getCacheManager() {
		return CacheUtils.getCacheManager();
	}
	
}
