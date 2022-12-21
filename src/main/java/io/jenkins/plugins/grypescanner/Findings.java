package io.jenkins.plugins.grypescanner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.jenkins.plugins.grypescanner.Finding.SEVERITY;

public class Findings implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Map<SEVERITY, List<Finding>> findings = new HashMap<SEVERITY, List<Finding>>();

  public Map<SEVERITY, List<Finding>> getFindings()
  {
    return findings;
  }
  
  public List<Finding> getFindingsAslist()
  {
    List<Finding> ret = new ArrayList<Finding>();
    for (List<Finding> f : findings.values())
    {
      ret.addAll(f);
    }
    return ret;
  }
  
  public Findings(String text)
  {
    if (text != null && !text.isEmpty())
    {
      String lines[] = text.split("\\r?\\n");
      for (String l : lines)
      {
        String[] props = l.split(",");
        if (props[0].equalsIgnoreCase("\"Package\""))
        {
          continue;
        }
        Finding f = new Finding(props);
        SEVERITY severity = f.getSeverity();
        if (!findings.containsKey(severity))
        {
          findings.put(severity, new ArrayList<Finding>());
        }
        findings.get(severity).add(f);
      }
    }
  }
}
