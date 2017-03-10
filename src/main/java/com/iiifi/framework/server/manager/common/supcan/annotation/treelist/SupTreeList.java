/**
 *
 */
package com.iiifi.framework.server.manager.common.supcan.annotation.treelist;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.iiifi.framework.server.manager.common.supcan.annotation.common.fonts.SupFont;
import com.iiifi.framework.server.manager.common.supcan.annotation.common.properties.SupProperties;
import com.iiifi.framework.server.manager.common.supcan.annotation.treelist.cols.SupGroup;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SupTreeList {
	
	/**
	 * 属性对象
	 */
	SupProperties properties() default @SupProperties;

	/**
	 * 字体对象
	 */
	SupFont[] fonts() default {};
	
	/**
	 * 列表头组
	 */
	SupGroup[] groups() default {};
	
}
