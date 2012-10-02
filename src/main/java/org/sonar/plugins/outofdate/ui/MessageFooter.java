/*
 * Sonar Out Of Date Plugin
 * Copyright (C) 2009 Alexandre Victoor
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.outofdate.ui;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.sonar.api.web.Footer;

public class MessageFooter implements Footer {

  private final Configuration configuration;

  public MessageFooter(Configuration configuration) {
    this.configuration = configuration;
  }

  public String getHtml() {

    String outage = configuration.getString("sonar.admin.outage.message", "");
    if (StringUtils.isEmpty(outage)) {
      return "";
    }
    
    StringBuilder sb = new StringBuilder();
    sb.append("<script type=\"text/javascript\">\n");
    sb.append("    Event.observe(window, 'load', function(){\n");

    sb.append("        var messageElement = document.createElement('div');\n");
    sb.append("        messageElement.setAttribute('class', 'big color_WARN');\n");
    sb.append("        messageElement.setAttribute('style', 'width: 100%');\n");
    sb.append("        messageElement.innerHTML = \"" + StringEscapeUtils.escapeJavaScript(outage) + "\";\n");

    sb.append("        var sonarContent = $$('div[id=\"error\"]').first().parentNode;\n");
    sb.append("        sonarContent.insertBefore(messageElement, sonarContent.firstChild);\n");
     
    sb.append("    });\n");
    sb.append("</script>\n");
    return sb.toString();
  }

}