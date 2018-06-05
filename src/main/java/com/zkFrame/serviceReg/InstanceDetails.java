package com.zkFrame.serviceReg;

import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Created by XYY78 on 2017/7/27.
 */
@JsonRootName("details")
public class InstanceDetails
{
    private String        description;

    public InstanceDetails()
    {
        this("");
    }

    public InstanceDetails(String description)
    {
        this.description = description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}