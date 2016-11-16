package com.frankun.domain.base;

import com.frankun.infrastructure.GuidGenerator;
import com.frankun.infrastructure.utils.DateUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 2016/10/13
 * 抽象的Domain父类，放置公共属性
 *
 * @author frankun
 */
public abstract class BaseDomain implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * Database id
     */
    protected int id;

    /**
     * 用于逻辑删除
     */
    protected boolean archived;

    /**
     * 业务id
     */
    protected String guid = GuidGenerator.generate();

    /**
     * The domain create time
     */
    protected LocalDateTime createTime = DateUtils.now();

    public BaseDomain(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof BaseDomain)){
            return false;
        }
        BaseDomain that = (BaseDomain) o;
        return guid.equals(that.guid);
    }

    @Override
    public int hashCode(){
        return guid.hashCode();
    }

    //For subclass override it
    public void saveOrUpdate() {
    }

    @Override
    public String toString(){
        final StringBuffer sb = new StringBuffer();
        sb.append("{id=").append(id);
        sb.append(", archived=").append(archived);
        sb.append(", guid='").append(guid).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append("}");
        return sb.toString();
    }
}
