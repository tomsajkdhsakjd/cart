package weimob.cart.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 老张
 * @Date: 2020/4/2
 */
@Data
public class CartInfoUpdateRequest implements Serializable {
    private static final long serialVersionUID = 6953193768986361756L;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 是否修改购物车checked
     */
    private Boolean isChecked;

    /**
     * 是否是修改所有购物车checked还是单个
     */
    private Boolean isAllChecked;

    /**
     * 是否是修改购物车商品数量
     */
    private Boolean isCount;

    /**
     * 修改后的数量
     */
    private Integer count;

    /**
     * 商品id
     */
    private Integer skuId;

}
