package com.thoughtworks.capacity.gtb.mvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    @NotNull(message = "用户名不为空")
    @Length(min = 3, max = 10, message = "用户名长度错误")
    @Pattern(regexp = "\\w*", message = "用户名只能由字母、数字或下划线组成")
    private String username;
    @NotNull(message = "密码不为空")
    @Length(min = 5, max = 12, message = "密码长度错误")
    private String password;
    @Email
    private String email;
}
