package me.blog.acg.core.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/4.
 */
@Entity
@Table(name="user_role_setting")
public class UserRole {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column( name = "user_id",updatable=false, insertable=false)
    private Long userId;

    @Column( name = "role_id",updatable=false, insertable=false)
    private Long roleId;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "role_id", updatable=false)
    private Role role;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable=false)
    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
