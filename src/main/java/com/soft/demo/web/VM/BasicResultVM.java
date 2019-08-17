package com.soft.demo.web.VM;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by chenzhidong on 2018/12/26.
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicResultVM {
    private Integer returnCode;
    private String returnDesc;
    private Object returnResult;
}
