package com.seekerhut.model;

import java.io.Serializable;

/**
 * general_commondata
 * @author 
 */
public class GeneralCommondata implements Serializable {
    private Long commonConfigId;

    private String item;

    private String value;

    private static final long serialVersionUID = 1L;

    public Long getCommonConfigId() {
        return commonConfigId;
    }

    public void setCommonConfigId(Long commonConfigId) {
        this.commonConfigId = commonConfigId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GeneralCommondata other = (GeneralCommondata) that;
        return (this.getCommonConfigId() == null ? other.getCommonConfigId() == null : this.getCommonConfigId().equals(other.getCommonConfigId()))
            && (this.getItem() == null ? other.getItem() == null : this.getItem().equals(other.getItem()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommonConfigId() == null) ? 0 : getCommonConfigId().hashCode());
        result = prime * result + ((getItem() == null) ? 0 : getItem().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commonConfigId=").append(commonConfigId);
        sb.append(", item=").append(item);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}