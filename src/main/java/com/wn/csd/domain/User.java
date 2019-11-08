package com.wn.csd.domain;

import lombok.Data;

/**
 * @author weining
 * @date 2019/11/8 19:12
 */
@Data
public class User {
    private Integer id;
    private String tel;
    private String password;
    private String email;
    private String invitation;
}
