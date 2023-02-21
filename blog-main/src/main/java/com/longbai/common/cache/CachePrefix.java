package com.longbai.common.cache;


import com.longbai.common.security.enums.UserEnums;

/**
 * <h3>ProcessMiniProgram</h3>
 * <p>缓存前缀</p>
 *
 * @author : chenjunjie
 **/
public enum CachePrefix {
    /**
     * 微信会话信息
     */
    WECHAT_SESSION_PARAMS,
    /**
     * 权限
     */
    PERMISSION_LIST,
    /**
     * token 信息
     */
    ACCESS_TOKEN,

    /**
     * 邀请信息
     */
    INVITE_MESSAGE,

    /**
     * 部门缓存信息
     */
    DEPARTMENT_MESSAGE,

    /**
     * 加工户名称缓存信息
     */
    FSupplierName_MESSAGE,

    /**
     * 委托商缓存信息
     */
    CONSIGNOR_MESSAGE,

    /**
     * 订单条码数
     */
    BARCODE_ACTIVE,

    /**
     * 发料单状态
     */
    DISBURSEMENTLIST_STATUS,

    /**
     * token 信息
     */
    REFRESH_TOKEN;


    public static String removePrefix(String str) {
        return str.substring(str.lastIndexOf("}_") + 2);
    }

    /**
     * 通用获取缓存key值
     *
     * @return 缓存key值
     */
    public String getPrefix() {
        return "{" + this.name() + "}_";
    }


    /**
     * 获取缓存key值 + 用户端
     * 例如：三端都有用户体系，需要分别登录，如果用户名一致，则redis中的权限可能会冲突出错
     *
     * @param user 角色
     * @return 缓存key值 + 用户端
     */
    public String getPrefix(UserEnums user) {
        return "{" + this.name() + "_" + user.name() + "}_";
    }

    public String getPrefix(String FDItemID) {
        return "{" + this.name() + "_" + FDItemID + "}_";
    }
}
