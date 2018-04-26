package org.zstack.header.identity.role;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table
@Entity
@IdClass(RolePolicyRefVO.CompositeID.class)
public class RolePolicyRefVO {
    static class CompositeID implements Serializable {
        private String roleUuid;
        private String policyUuid;

        public String getRoleUuid() {
            return roleUuid;
        }

        public void setRoleUuid(String roleUuid) {
            this.roleUuid = roleUuid;
        }

        public String getPolicyUuid() {
            return policyUuid;
        }

        public void setPolicyUuid(String policyUuid) {
            this.policyUuid = policyUuid;
        }
    }

    @Column
    @Id
    private String roleUuid;
    @Column
    @Id
    private String policyUuid;
    @Column
    private Timestamp createDate;
    @Column
    private Timestamp lastOpDate;

    @PreUpdate
    private void preUpdate() {
        lastOpDate = null;
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    public String getPolicyUuid() {
        return policyUuid;
    }

    public void setPolicyUuid(String policyUuid) {
        this.policyUuid = policyUuid;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastOpDate() {
        return lastOpDate;
    }

    public void setLastOpDate(Timestamp lastOpDate) {
        this.lastOpDate = lastOpDate;
    }
}