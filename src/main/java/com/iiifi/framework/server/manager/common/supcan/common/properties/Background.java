/**
 *
 */
package com.iiifi.framework.server.manager.common.supcan.common.properties;

import com.iiifi.framework.server.manager.common.supcan.annotation.common.properties.SupBackground;
import com.iiifi.framework.server.manager.common.utils.ObjectUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Background")
public class Background {
	
	/**
	 * 背景颜色
	 */
	@XStreamAsAttribute
	private String bgColor = "#FDFDFD";
	
	public Background() {
		
	}
	
	public Background(SupBackground supBackground) {
		this();
		ObjectUtils.annotationToObject(supBackground, this);
	}
	
	public Background(String bgColor) {
		this();
		this.bgColor = bgColor;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
}
