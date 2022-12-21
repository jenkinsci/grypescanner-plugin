package io.jenkins.plugins.grypescanner;

import java.io.Serializable;

public class Finding implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  enum SEVERITY{Critical, High, Medium, Low };
  private String packageName;
  private String versionInstalled;
  private String vulnId;
  private SEVERITY severity;
  private String locations;
  
  
  public String getPackageName()
  {
    return packageName;
  }

  public void setPackageName(String packageName)
  {
    this.packageName = packageName;
  }

  public String getVersionInstalled()
  {
    return versionInstalled;
  }

  public void setVersionInstalled(String versionInstalled)
  {
    this.versionInstalled = versionInstalled;
  }

  public String getVulnId()
  {
    return vulnId;
  }

  public void setVulnId(String vulnId)
  {
    this.vulnId = vulnId;
  }

  public String getLocations()
  {
    return locations;
  }

  public void setLocations(String locations)
  {
    this.locations = locations;
  }

  public void setSeverity(SEVERITY severity)
  {
    this.severity = severity;
  }


  public Finding(String[] props)
  {
   packageName = props[0].replaceAll("\"", "");
   versionInstalled = props[1].replaceAll("\"", "");
   vulnId = props[2].replaceAll("\"", "");
   severity = SEVERITY.valueOf(props[3].replaceAll("\"", ""));
   locations = props[4].replaceAll("\"", "");
  }



  public SEVERITY getSeverity()
  {
    return severity;
  }
}
