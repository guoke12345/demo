package com.springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登记信息的用户
 * </p>
 *
 * @author weichao
 * @since 2019-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HlHlappMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 部门
     */
    @TableField("partId")
    private Long partId;

    /**
     * 微信openId
     */
    @TableField("openId")
    private String openId;

    /**
     * 公众号标识
     */
    @TableField("mId")
    private Integer mId;

    /**
     * 创建时间
     */
    private Long createTime;

    private Long updateTime;

    private Long deleteTime;


}
