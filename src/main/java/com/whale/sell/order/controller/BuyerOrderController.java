package com.whale.sell.order.controller;

import com.whale.sell.common.VO.ResultVO;
import com.whale.sell.common.converter.OrderVO2OrderDTOConverter;
import com.whale.sell.common.utils.ResultVOUtil;
import com.whale.sell.enums.ResultEnum;
import com.whale.sell.exception.SellException;
import com.whale.sell.order.domain.DTO.OrderDTO;
import com.whale.sell.order.domain.VO.OrderVO;
import com.whale.sell.order.service.BuyerService;
import com.whale.sell.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BuyerOrderController
 * @Description 买家订单API
 * @Author like
 * @Data 2019/3/8 19:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    /**
     * 1.创建订单
     * 2.订单列表
     * 3.订单详情
     * 4.取消订单
     */

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     *
     * @param orderVO       请求参数
     * @param bindingResult 表单校验
     * @return ResultVO
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderVO orderVO,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderVO={}", orderVO);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderVO2OrderDTOConverter.conver(orderVO);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(responseMap);
    }

    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            log.error("【查询订单详情】orderId不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);

        return ResultVOUtil.success(orderDTO);
    }

    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            log.error("【取消订单】orderId不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        buyerService.cancelOrder(openid, orderId);

        return ResultVOUtil.success();
    }
}
