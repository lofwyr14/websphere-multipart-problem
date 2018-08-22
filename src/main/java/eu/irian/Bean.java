package eu.irian;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@ManagedBean
@SessionScoped
public class Bean {

  private String text = "a\n"
      + "b\n"
      + "c";

  private String parameter = "init";

  private int counter = 0;

  public String action() {
    parameter = "action called ";
    parameter += ++counter;
    parameter += "\n";
    final Map<String, String> parameterMap =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
      parameter += "'" + entry.getKey() + "' -> '" + entry.getValue() + "' \n";
    }

    return null;
  }

  public String getHex() {
    final byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
    final StringBuilder builder = new StringBuilder();
    int c = 0;
    for (byte aByte : bytes) {
      builder.append(String.format("%02x", aByte));
      builder.append(' ');
      if (c++ < 16) {
        continue;
      }
      builder.append('\n');
      c = 0;
    }
    return builder.toString();
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }
}
