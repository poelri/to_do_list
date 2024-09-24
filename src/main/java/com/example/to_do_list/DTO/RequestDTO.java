package com.example.to_do_list.DTO;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RequestDTO {
    private int id;
    private String content;
    private String newContent;
}
