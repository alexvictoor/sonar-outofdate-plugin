package org.sonar.plugins.outofdate;


import org.sonar.plugins.outofdate.ui.MessageFooter;
import org.sonar.plugins.outofdate.ui.OutOfDateRubyWidget;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

@Properties({
  @Property(key = "sonar.admin.outage.message",
    name = "Admin message",
    description = "Admin message that can be used to notify users of upcomming outages")
 })
public final class OutOfDatePlugin extends SonarPlugin {

  // This is where you're going to declare all your Sonar extensions
  public List getExtensions() {
    return Arrays.asList(OutOfDateRubyWidget.class, MessageFooter.class);
  }
}