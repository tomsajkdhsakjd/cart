package weimob.cart.api.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 老张
 * @Date: 2020/3/28
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 6042441471309813312L;
    /**
     * id
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户id
     */
    private String userId;


    /**
     * 用户号码
     */
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 更新日期
     */
    private Date updateDate;
}