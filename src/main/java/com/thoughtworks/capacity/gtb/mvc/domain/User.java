package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull (message = "用户名不为空")
    @Length(min = 3, max = 10)
   // @Pattern(regexp = "a-zA-Z")
    private String username;
    @NotNull(message = "密码不为空")
    @Length(min = 5, max = 12)
    private String password;
    @Email
    private String email;
}
