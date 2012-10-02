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

import org.sonar.api.web.*;

@UserRole(UserRole.USER)
@Description("Show error messages on dashboards where date are out of date")
@WidgetCategory("Misc")
@WidgetProperties({
	@WidgetProperty(key = "message",
		description = "Message displayed when data are out of date",
		type = WidgetPropertyType.STRING,
		defaultValue = "WARNING! Data for this project are out of date"
	),
    @WidgetProperty(key = "days",
        description = "days threshold",
        type = WidgetPropertyType.INTEGER,
        defaultValue = "5"
    )
})
public class OutOfDateRubyWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  public String getId() {
    return "outofdate";
  }

  public String getTitle() {
    return "OutOfDate";
  }

  @Override
  protected String getTemplatePath() {
    return "/out_of_date.html.erb";   //"C:/work/sonar-cs/out_of_date.html.erb";
  }
}