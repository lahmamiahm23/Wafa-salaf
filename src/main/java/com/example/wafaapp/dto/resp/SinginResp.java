package com.example.wafaapp.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinginResp {
    private String jwt;
    private String mesg;
}
