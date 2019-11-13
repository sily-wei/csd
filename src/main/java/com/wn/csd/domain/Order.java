package com.wn.csd.domain;

import lombok.Data;

/**
 * @author weining
 * @date 2019/11/11 16:46
 * 订单实体类
 */
@Data
public class Order {
    private Integer id;
    private Integer cid;
    private Integer uid;
    private Integer getId;
    private Integer backId;
    private Double oprice;
    private String status = "已预订";
}
