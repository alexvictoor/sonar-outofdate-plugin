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