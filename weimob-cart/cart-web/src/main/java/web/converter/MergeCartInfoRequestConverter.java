package web.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import web.query.CartAddQuery;
import web.response.CartInfoVo;
import web.utils.CookieUtils;
import weimob.cart.api.request.CartInfosSaveRequest;
import weimob.cart.api.request.MergeCartInfoRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 老张
 * @Date: 2020/4/10
 */
@Slf4j
public class MergeCartInfoRequestConverter {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static MergeCartInfoRequest mergeCartInfoRequest(String userId, String cookieCartInfo) {
        MergeCartInfoRequest mergeCartInfoRequest = MergeCartInfoRequest.builder().userId(userId).build();

        String decode = null;
        try {
            decode = URLDecoder.decode(cookieCartInfo, "utf-8");
            List<CartInfosSaveRequest> cartInfosSaveRequestList = objectMapper.readValue(decode, new TypeReference<List<CartInfosSaveRequest>>() {
            });
            mergeCartInfoRequest.setCartInfos(cartInfosSaveRequestList);
        } catch (UnsupportedEncodingException e) {
            log.error("购物车cookie编码错误:{}", cookieCartInfo);
        } catch (Exception exception) {
            log.error("购物车数据json转换异常: {}", exception.getCause());

        }
        return mergeCartInfoRequest;
    }

    public static MergeCartInfoRequest mergeCartInfoRequest(CartAddQuery cartAddQuery) {
        MergeCartInfoRequest cartInfoRequest = new MergeCartInfoRequest();
        cartInfoRequest.setUserId(cartAddQuery.getUserId());
        List<CartInfosSaveRequest> list = new ArrayList<>();
        CartInfosSaveRequest saveRequest = CartInfosSaveRequest.builder().userId(cartAddQuery.getUserId()).count(1).checked(1).skuId(cartAddQuery.getId()).build();
        list.add(saveRequest);
        cartInfoRequest.setCartInfos(list);
        return  cartInfoRequest;
    }
}
